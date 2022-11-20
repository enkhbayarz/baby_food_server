CREATE TABLE TB_USER_ROLE
(
    id         serial PRIMARY KEY,
    user_id    INTEGER NULL,
    role_id    INTEGER NULL,
    type       VARCHAR(20) NULL,
    status     VARCHAR(20) NULL,
    created_on TIMESTAMP NULL,
    updated_on TIMESTAMP NULL
);