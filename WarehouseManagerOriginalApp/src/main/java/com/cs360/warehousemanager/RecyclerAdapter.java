package com.cs360.warehousemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private final RecyclerViewInterface myInterface;
    private Context context;
    private ArrayList names, skus, counts;

    // constructor
    public RecyclerAdapter(Context context, RecyclerViewInterface myInterface, ArrayList names, ArrayList skus, ArrayList counts){
        this.context = context;
        this.myInterface = myInterface;

        this.names = names;
        this.skus = skus;
        this.counts = counts;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView, skuView, countView;

        public MyViewHolder(final View view, RecyclerViewInterface myInterface) {
            super(view);
            nameView = view.findViewById(R.id.nameView);
            skuView = view.findViewById(R.id.skuView);
            countView = view.findViewById(R.id.countView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // get adapter position
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        myInterface.onItemClick(position);
                    }
                }
            });
        }

    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.display, parent, false);
        return new MyViewHolder(itemView, myInterface);
    }


    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {

        holder.nameView.setText(String.valueOf(names.get(position)));
        holder.skuView.setText(String.valueOf(skus.get(position)));
        holder.countView.setText(String.valueOf(counts.get(position)));

    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}
