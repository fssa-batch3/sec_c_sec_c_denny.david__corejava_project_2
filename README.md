# sec_c_sec_c_denny.david__corejava_project_2
## Table: students

| Column       | Data Type     | Constraints                         |
|--------------|---------------|-------------------------------------|
| id           | int           | NOT NULL, PRIMARY KEY, AUTO_INCREMENT |
| name         | varchar(100)  | NOT NULL                            |
| email        | varchar(100)  | NOT NULL                            |
| mobile_no    | varchar(10)   | NOT NULL                            |
| password     | varchar(100)  | NOT NULL                            |
| gender       | char(1)       | NOT NULL                            |
| dob          | date          | NOT NULL                            |
| created_date | timestamp     | NOT NULL, DEFAULT CURRENT_TIMESTAMP |
| email (unique)|               |                                     |
| gender (check)|               | IN ('M', 'F')                       |

## Table: student_class

| Column      | Data Type | Constraints                           |
|-------------|-----------|---------------------------------------|
| id          | int       | PRIMARY KEY, AUTO_INCREMENT           |
| student_id  | int       | NOT NULL, FOREIGN KEY (students.id)   |
| class       | int       | NOT NULL                              |
| status      | varchar(20)| NOT NULL                              |
| class (check)|          | BETWEEN 1 AND 12                     |
| status (check)|         | IN ('ACTIVE', 'INACTIVE')            |
