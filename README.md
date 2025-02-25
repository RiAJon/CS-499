# Computer Science ePortfolio

## Self Assessment 

Through the completion of the Computer Science program at SNHU, I have learned, not only about the craft of designing and writing software, but also about how to collaborate with other developers to gain tools and insights for my work. Over the course of earning my degree, I learned uncountable new skills such as database design and management, security analysis, 3D graphic rendering, neural network implementation, and more. Most recently, I have combined many of these skills to create several full stack projects including Web and Mobile applications.

Effective teamwork is essential for success in software development and IT-related fields. Throughout my academic and professional experiences, I have collaborated with cross-functional teams using Agile methodologies, version control systems such as Git, and project management tools. I have experience participating in code reviews, engaging in constructive peer feedback, and integrating multiple components of a project to ensure cohesive functionality.

In the field of computer science, technical proficiency must be accompanied by strong communication skills. My ability to translate complex technical concepts into understandable language allows me to effectively interact with both technical and non-technical stakeholders. Whether through presentations, technical documentation, or reports, I ensure that key project details are conveyed clearly and concisely.

I have experience gathering and analyzing user requirements, which has taught me how to align software solutions with business needs. Additionally, I have worked on projects where I needed to document software development lifecycles, API usage, and data structures, ensuring that all relevant parties—including developers, clients, and end-users—can access and comprehend critical project information.

A strong foundation in data structures and algorithms is vital for writing efficient, scalable software. My coursework and hands-on projects have provided me with deep experience in designing and implementing efficient algorithms for sorting, searching, and optimizing computational tasks. I have applied my knowledge of trees, graphs, hash tables, and dynamic programming to solve complex problems effectively.

My proficiency in software engineering principles extends to designing and implementing robust, scalable applications. I have developed full-stack applications using programming languages such as Java, JavaScript, and C++. I am well-versed in software development methodologies, including Agile and DevOps, and have experience with frameworks like React and Spring Boot.

Database management is another area of expertise where I have demonstrated my ability to design, normalize, and optimize relational and NoSQL databases. I have worked extensively with SQL and NoSQL databases including MongoDB, Realm, MySQL, and SQLite, ensuring efficient data retrieval and storage. Understanding how to implement database indexing, query optimization, and stored procedures has helped me develop scalable back-end solutions.

Security is a fundamental aspect of modern computing, and I am well-versed in secure coding practices, cryptography, authentication protocols, and risk assessment. I have implemented security measures such as encryption, secure authentication methods (OAuth, JWT), and network security protocols to protect applications from vulnerabilities.

Additionally, my coursework in cybersecurity has equipped me with the knowledge to perform security audits, penetration testing, and vulnerability assessments. I understand the importance of writing secure software and following industry best practices to mitigate threats such as SQL injection, cross-site scripting, and buffer overflows.

### Artifacts
To demonstrate my abilies in the areas of software design and engineering, algorithms and data structures, and databases I enhanced two artifacts from previous coursework. The first of these is an android app developed using Java SDK in Android studio. To enhance this artifact, I added several functional features to help user navigation, security, and increase efficiency. This work was completed hand in hand with my database enhancement whch also utilizes the mobile app. I migrated the previously SQLite data layer over to the open-source database project [Realm](https://github.com/realm) by mongoDB. The realm database schema is object oriented rather then relational so the shift included creating new CRUD modules, but the database's inherently smooth implementation helped significantly.

The artifact which showcases my skills in the area of algorithmns and data structures is a binary search tree model which takes a CSV file and offers functionality to insert, sort, and search through data. For my enhancement, I ported the original model to Java so that I could utilize the module with other java projects easily. I also designed and implemented a new red and black tree which is another model which is self-balancing and has a slightly better time complexity with high input than the original tree. 


## Code Review
The initial code review for this project can be found [here](https://youtube.com/playlist?list=PLR8ofoWi60ZuU3sn5STf4Om_Txww9rYqG&si=JUI9ZJTV0dNwNS6T).

## Artifacts Narratives

### Warehouse Manager App  

The artifact being enhanced is a mobile application developed for android using Android Studio and SQLite. The app was designed to be a warehouse manager for inventory managers, small business owners, and anyone else who would benefit from automating their inventory tracking. I initially worked on the app during my seventh term at SNHU for CS-360 in 2024.

I decided to include this artifact in my portfolio because I did a lot of learning during the initial development of the app, and I had already thought of several areas for improvement by the time I turned in the original project. When the opportunity arose to enhance a project, I knew this app would be a good one to work on. I honed many skills while developing and enhancing the app. These include front end development, modular design, database architecture, and more.

To improve the artifact, I have completed several enhancements. These include a new warehouse management system, new search capabilities, photo capabilities, fixes to the notification system, increased user accessibility, and increased security in the form of input validation and user authentication. During the process of enhancing the artifact I learned much. One of the biggest challenges I faced happened to also be the area where I learned the most. I designed another aspect of the app with a recycler view which was difficult because there are many facets, and I had not truly understood the process the first time around. However, after much trial and error, I learned to implement the view in a way that will be simple to replicate in the future. 

The database used in the original is embedded SQLite. I created the original database and implemented it in my application using custom CRUD operations. I had enjoyed the process of building the data layer in my app, but I felt that the interactions between the database and application could be better. To enhance the artifact, I decided to upgrade to an external object database with simpler implementation and broader data storage capability. Through the new database implementation, the artifact has been improved in areas like modularity, readability, storage capabilities, and more.

Creating the new warehouse management system was certainly the most difficult aspect of the enhancement because it involved creating a new activity, designing a new database schema, and implementing new user interfaces. This process was made more laborious by some nuances of the Realm database which I was learning as I went. Much of the troubleshooting was centered on fixing interactions between the database objects and the app logic. Despite this, I was able to fully implement the Realm object-oriented schema and use it to create more efficient data insertion and retrieval throughout the app, and I feel that all course outcomes were met.


 Main Page  | Warehouse Management 
 ------------- | ------------- 
 ![Screenshot 2025-02-24 183130](https://github.com/user-attachments/assets/e86adb23-7aaf-4f0c-8763-cebb1777bdf3) | ![Screenshot 2025-02-24 183538](https://github.com/user-attachments/assets/e01287d9-5029-478b-8d57-a131406484aa) |




### Binary Search Tree  

This artifact is a binary search tree structure which implements insertion, deletion, search, and sort algorithms. It was created in my fifth term at SNHU for CS260: Data Structures and Algorithms. I selected this item because I was very interested in the process of creating different data storage structures and evaluating their efficiency in areas like searching and sorting. My professor in that class mentioned more complicated self-balancing trees but said that they were outside the scope of the class. 

When the opportunity arose to revisit the data structure, I decided I wanted to expand my understanding of data structures and create a red and black tree. I wanted to be able to use the structure in some of my java projects, so I decided to complete the enhancement in java. I also decided to port the original binary search tree from C++ to java so that I could compare the efficiency of the structures with big O notation. This enhancement displays skills including the ability to port projects between OOP languages, algorithm design, efficiency analysis, and unit testing. 

Porting the original tree helped me write the code for the red and black tree because the logic follows the same lines with an extra element in each storage node. The biggest challenge in the new implementation was learning how to create the self-balancing effect in the structure through rotation. Luckily, having just worked on the first tree, I had some fresh ideas about how to make the code clearer and reusable in the new tree. This included aspects like variable names, class data fields, function modules, and more. 

![Binary Search Tree Flow Chart (2)](https://github.com/user-attachments/assets/d563ddf1-288d-4c86-9ac2-337f7a31e8e4)


#### Narrative 

### Skills Demonstrated to meet Course Outcomes

⭐**Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science**
  - Created code review video which evaluates the source code for each enhancement. The review appraised the code structure, documentation, variables, arithmetic operations, loops/branches, and security.
  - Produced easily readable code through use of contectual and organizational comments.
  - Analyzed binary search tree model efficiencies through nanosecond measurement and big-O analysis to support decision making with stakeholders in mind.

⭐**Design, develop, and deliver professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts**
  - Gained and implemented feedback on code review through collaborative environment.
  - Created UML flow and sequence diagrams to document the structural plan for artifact enhancements.

⭐**Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices**
  - Wrote pseudocode to document the functional changes to be made to assist in feature implementation.
  - Designed and implemented algorithm for two seperate binary search tree models using logical analysis.
  - Implemented Realm data models and learned the itricacies of the open-source database through testing and de-bugging.

⭐**Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals**
  - Created and employed test cases for data insertion and retrieval into/from the binary search trees including real-data tests using CSV format.
  - Implemented industry standards and best coding practices through use of accepted design patterns and checklist-based review.
  - Utilized third party tools like Realm Studio to manage data and create test-cases.

⭐**Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources**
  - Evaluated source code for security vulnerabilities using OWASP resources and reported findings in code review.
  - Implemented secure design practices through data and input validation, code modulation, error handling, and user authentication.
  - Tested encryption techniques for data security through Realm's encryption capabilities.
  - Defined database migration strategy for future database updates.

