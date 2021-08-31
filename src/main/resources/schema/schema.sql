DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id     INT AUTO_INCREMENT,
    name   VARCHAR(20) NOT NULL,
    birth  DATE        NOT NULL,
    gender char(1)     NOT NULL,
    CONSTRAINT USER_PK PRIMARY KEY (id)
) engine = InnoDB;