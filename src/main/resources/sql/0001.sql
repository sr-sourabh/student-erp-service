CREATE TABLE student
(
    student_id      INTEGER(10) PRIMARY KEY,
    roll_no         VARCHAR(30) UNIQUE NOT NULL,
    first_name      VARCHAR(30)        NOT NULL,
    last_name       VARCHAR(30),
    email           VARCHAR(30) UNIQUE NOT NULL,
    photograph_path VARCHAR(100),
    cgpa            FLOAT(10)          NOT NULL DEFAULT 0.0,
    total_credits   INTEGER(10)        NOT NULL,
    graduation_year VARCHAR(4)
);

INSERT INTO student
VALUES (1, 'MT2020054', 'shourabh', 'payal', 'test@test.com', '/null', 4.0, 8, 2020);