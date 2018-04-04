## Spring Job Portal

Job portal for job seekers and companies. The purpose of this project is to create a channel of communication between employers and future prospective employees. Through 
this platform, companies and organisation who are looking for future talents can post ads for open job positions. Then job seeker who are interested in these position can apply . Employers
will be able to see the submitted resumes and then providing the criteria the application will evaluate and recommend which candidate is suitable


## Stack 
+ Spring MVC 
+ Database migration with Liquibase 


## Features 
+ Upload file/ pdf/ picture and encrypt and decrypt files to the server 
+ Database migration 
+ Audit trails and logging using AOP
+ i18n (language : EN - FIN)


### Installing and Running the application

Just run the Application.java.
Type http://localhost:8080/findjobs in your browser to open the application.




### Optimization in the project 
+ MySQL server 
    + Export portal database : `mysqldump -u root -p portal > db_backup.sql`
    + Compress the export data with gzip : `mysqldump -u root -p portal | gzip > db_backup.sql.gz`
+ Hibernate 
    + Hibernate Statistics
    + Hibernate session : 1st level and 2nd level 
        + 1st level cache 
        + 2nd level cacahe : with Redis 
    + Hibernate optimize SQL queries 
        + FetchType
        + Session management
        + Batch insert, update , delete 
        + Periodically flush and clear the Hibernate session
        + Lazy init(loading)


+ Spring MVC 
    + Connection pooling : 
    



+ Multithreading
    + Tomcat server with concurrency with Executor framework 


+ JVM 
    + Tuning JVM memory setting 


