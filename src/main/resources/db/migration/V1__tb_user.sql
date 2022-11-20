CREATE TABLE TB_USER
(
    id         serial PRIMARY KEY,
    name       VARCHAR(50) NULL,
    username   VARCHAR(50) NULL,
    password   VARCHAR(100) NULL,
    email      VARCHAR(50) NULL,
    phone      VARCHAR(20) NULL,
    type       VARCHAR(20) NULL,
    status     VARCHAR(20) NULL,
    created_on TIMESTAMP NULL,
    updated_on TIMESTAMP NULL
);