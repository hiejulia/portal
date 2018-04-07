## Spring Job Portal

Job portal for job seekers and companies. The purpose of this project is to create a channel of communication between employers and future prospective employees. Through 
this platform, companies and organisation who are looking for future talents can post ads for open job positions. Then job seeker who are interested in these position can apply . Employers
will be able to see the submitted resumes and then providing the criteria the application will evaluate and recommend which candidate is suitable


## Stack 
+ Spring MVC 
+ Database : MySQL 
+ Apache Maven 
+ Web Service  
+ Lombok 
+ Spring social security login 


## Features 
+ Upload file/ pdf/ picture and encrypt and decrypt files to the server 
+ Database: MySQL 
+ Authentication (with email verification after register) - and CSRF protection 
+ Audit trails and logging using AOP
+ i18n (language : EN - FIN)
+ Email transaction services
+ Validation (JSR 303)
+ MultipartFile interface - upload files - Encrypt and decrypt stored file
    + Upload single and multiple docs to the local repository or file system using the core IO streams
    + Upload docs to FTP server 
    + Upload docs with encrytion and decrytion for added security 
+ AOP : audit trails and logging using AOP 
+ Captcha plugin 
+ SendGrid to monitor email transaction
+ Display excel file 
+ Some views tech integration : Apache tiles, Freemaker, Velocity
+ Scheduler (sending notification to the company when there is job application ) 
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
        + Evaludate query performance 
        + Optimum database structure 
    + Dump some rows in table (of Portal database ) by import csv file data (location of csv files : ./scripts/csv/**.csv)
    + Back up MySQL Portal database(using mysqldump tool )
    + Configuration of MySQL server     
        + Create a back up of the original config file 
        + Adjust settings for InnoDB tables (mysqld.cnf)
            +innodb_buffer_pool_size = 512M  # around 70% of total ram
             innodb_log_file_size  = 64M
             innodb_file_per_table = 1
             innodb_log_buffer_size = 4M
             + Set maximum connection : max_connections = 300
             + Increase the tem table size : tmp_table_size = 32M
             + Increase max_allowed_packet to increase the maximum packet size : max_allowed_packet = 32M
             + Enable binary log for recovery and replication : og_bin = /var/log/mysql/mysql-bin.log
    + MySQL performance tuning primer script : 
        + Download the script : wget http://day32.com/MySQL/tuning-primer.sh
        + `sh tuning-primer.sh`
+ Hibernate 
    + Hibernate Statistics
    + Hibernate session : 1st level and 2nd level 
        + 1st level cache 
        + 2nd level cacahe : with Redis 
    + Hibernate Envars for entity revision auditing
   
    + Hibernate optimize SQL queries 
        + FetchType
        + Session management
        + Batch insert, update , delete 
        + Periodically flush and clear the Hibernate session
        + Lazy init(loading)
        + Indexing 
+ Spring Data JPA 
    + JPA auditing 

+ Spring MVC 
    + Connection pooling : 
    



+ Multithreading
    + Tomcat server with concurrency with Executor framework 


+ JVM 
    + Tuning JVM memory setting 


