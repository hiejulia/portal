## Spring Job Portal

Job portal for job seekers and companies. The purpose of this project is to create a channel of communication between employers and future prospective employees. Through 
this platform, companies and organisation who are looking for future talents can post ads for open job positions. Then job seeker who are interested in these position can apply . Employers
will be able to see the submitted resumes and then providing the criteria the application will evaluate and recommend which candidate is suitable


## Stack 
+ Spring MVC 
+ Database : MySQL 
+ Apache Maven 
 



## Features 
+ Upload file/ pdf/ picture and encrypt and decrypt files to the server 
+ Database: MySQL 
+ Authentication (with email verification after register)
+ Audit trails and logging using AOP
+ i18n (language : EN - FIN)
+ Email transaction services
+ Validation (JSR 303)
+ MultipartFile interface - upload files - Encrypt and decrypt stored file
    + Upload single and multiple docs to the local repository or file system using the core IO streams
    + Upload docs to FTP server 
    + Upload docs with encrytion and decrytion for added security 


### Installing and Running the application

Just run the Application.java.
Type http://localhost:8080/findjobs in your browser to open the application.




### Optimization in the project 
+ MySQL server 
    + Export portal database : `mysqldump -u root -p portal > db_backup.sql`
    + Compress the export data with gzip : `mysqldump -u root -p portal | gzip > db_backup.sql.gz`
    + Scale MySQL server : 
        + Mem cache 
        + Indexing: invisible index, descending index , check index usage, query optimizer, index hint, performance_schema, sys schema 
        + Explain plan 
        + 
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
        + Indexing 


+ Spring MVC 
    + Connection pooling : 
    



+ Multithreading
    + Tomcat server with concurrency with Executor framework 


+ JVM 
    + Tuning JVM memory setting 


