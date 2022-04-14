DROP TABLE IF EXISTS student_;
DROP TABLE IF EXISTS group_;
DROP TABLE IF EXISTS professor_;

-- PROFESSOR table
CREATE TABLE professor_ (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    department_name VARCHAR(50)
);

INSERT INTO professor_ (id, first_name, last_name, email, department_name) VALUES (1, 'P1F', 'P1L', 'p1@gmail.com', 'IS');
INSERT INTO professor_ (id, first_name, last_name, email, department_name) VALUES (2, 'P2F', 'P2L', 'p2@gmail.com', 'IS');
INSERT INTO professor_ (id, first_name, last_name, email, department_name) VALUES (3, 'P3F', 'P3L', 'p3@gmail.com', 'CS');
INSERT INTO professor_ (id, first_name, last_name, email, department_name) VALUES (4, 'P4F', 'P4L', 'p4@gmail.com', 'CS');

CREATE TABLE group_ (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    member_count INT DEFAULT 0,
    supervisor_id INT,
    FOREIGN KEY (supervisor_id) REFERENCES professor_ (id) ON DELETE SET NULL
);

INSERT INTO group_ (id, name, member_count, supervisor_id) VALUES (1, 'IS-1801K', 0, 1);
INSERT INTO group_ (id, name, member_count, supervisor_id) VALUES (2, 'IS-1808K', 0, 2);
INSERT INTO group_ (id, name, member_count, supervisor_id) VALUES (3, 'CS-1801K', 0, 3);
INSERT INTO group_ (id, name, member_count, supervisor_id) VALUES (4, 'CS-1802K', 0, 4);

-- STUDENT
CREATE TABLE student_ (
    id                   INT AUTO_INCREMENT PRIMARY KEY,
    group_id             INT,
    first_name           VARCHAR(50) NOT NULL,
    last_name            VARCHAR(50),
    last_submission_date DATE,
    gpa                  DOUBLE DEFAULT 0.0,
    city                 VARCHAR(50),
    is_have_scholarship  BOOLEAN,
    FOREIGN KEY (group_id) REFERENCES group_ (id) ON DELETE SET NULL
);

INSERT INTO student_ VALUES (1, 1, 'S1F', 'S1L', null, 0.0, 'Almaty', false);
INSERT INTO student_ VALUES (2, 2, 'Yerbolat', 'Pazyl', null, 0.0, 'Almaty', false);
INSERT INTO student_ VALUES (3, 3, 'S3F', 'S3L', null, 0.0, 'Nur-Sultan', false);
INSERT INTO student_ VALUES (4, 4, 'S3F', 'S3L', null, 0.0, 'Nur-Sultan', false);
