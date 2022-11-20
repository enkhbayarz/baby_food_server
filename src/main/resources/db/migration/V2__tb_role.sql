CREATE TABLE TB_ROLE
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) NULL,
    description VARCHAR(50) NULL,
    type        VARCHAR(20) NULL,
    status      VARCHAR(20) NULL,
    created_on  TIMESTAMP NULL,
    updated_on  TIMESTAMP NULL
);