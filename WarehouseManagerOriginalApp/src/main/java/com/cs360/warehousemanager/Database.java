package com.cs360.warehousemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Objects;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WarehouseData.db";
    private static final int VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    // table to hold item info
    private static final class ItemTable {
        private static final String TABLE = "items";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_SKU = "sku";
        private static final String COL_COUNT = "count";
    }

    // table to hold user credentials
    private static final class UserCreds {
        private static final String TABLE = "user_credentials";
        private static final String COL_USERID = "id";
        private static final String COL_USERNAME = "username";
        private static final String COL_PASSWORD = "password";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables

        db.execSQL("create table " + UserCreds.TABLE + " (" +
                UserCreds.COL_USERID + " integer primary key autoincrement, " +
                UserCreds.COL_USERNAME + " text, " +
                UserCreds.COL_PASSWORD + " text)");


        db.execSQL("create table " + ItemTable.TABLE + " (" +
                ItemTable.COL_ID + " integer primary key autoincrement, " +
                ItemTable.COL_NAME + " text, " +
                ItemTable.COL_SKU + " text, " +
                ItemTable.COL_COUNT + " text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists " + ItemTable.TABLE);
        db.execSQL("drop table if exists " + UserCreds.TABLE);

        onCreate(db);
    }

    // method which returns cursor
    public Cursor getItems() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ItemTable.TABLE, null);

        return cursor;
    }

    // method to add item to item table
    public void addItem(String name, String sku, String count) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ItemTable.COL_NAME, name);
        values.put(ItemTable.COL_SKU, sku);
        values.put(ItemTable.COL_COUNT, count);

        db.insert(ItemTable.TABLE, null, values);
        db.close();
    }

    // method to add user to user table
    public void addUser(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserCreds.COL_USERNAME, username);
        values.put(UserCreds.COL_PASSWORD, password);

        db.insert(UserCreds.TABLE, null, values);
        db.close();
    }

    // method to get password based on username from user table
    public String getUserCreds(String username) {
        // will return
        String password = null;

        SQLiteDatabase db = getReadableDatabase();

        String sql = "select * from " + UserCreds.TABLE + " where username = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{username});

        if (cursor.moveToFirst()) {
            // get password from row - column 2
            password = cursor.getString(2);
        }

        cursor.close();
        return password;
    }

    // method to check usernames for duplicates in user table
    public boolean checkName(String username) {
        // will return
        boolean duplicate = false;
        String userNameDB = null;

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = new String[]{UserCreds.COL_USERNAME};
        Cursor cursor = db.query(UserCreds.TABLE, columns, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                userNameDB = cursor.getString(0);
                if (Objects.equals(userNameDB, username)) {
                    duplicate = true;
                    break;
                }
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        return duplicate;
    }

    // FIXME: should figure out a way to do these 2 methods with primary key

    public boolean updateItem(String originName, String name, String sku, String count){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ItemTable.COL_NAME, name);
        values.put(ItemTable.COL_SKU, sku);
        values.put(ItemTable.COL_COUNT, count);

        int updated = db.update(ItemTable.TABLE, values, "name=?",
                new String[] {originName});

        db.close();

        // return result of update
        return updated > 0;
    }

    public boolean deleteItem(String name) {
        SQLiteDatabase db = getWritableDatabase();
        int deleted = db.delete(ItemTable.TABLE, ItemTable.COL_NAME + "=?",
                new String[] {name});

        db.close();

        // return result of delete
        return deleted > 0;
    }

}
