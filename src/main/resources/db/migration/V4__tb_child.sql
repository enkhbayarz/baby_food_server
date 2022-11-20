CREATE TABLE TB_CHILD
(
    id         serial PRIMARY KEY,
    name       VARCHAR(50) NULL,
    born_date  DATE NULL,
    gender     VARCHAR(50) NULL,
    weight     NUMERIC NULL,
    height     NUMERIC NULL,
    index      NUMERIC NULL,
    type       VARCHAR(20) NULL,
    status     VARCHAR(20) NULL,
    user_id    INTEGER NULL,
    index_id   INTEGER NULL,
    created_on TIMESTAMP NULL,
    updated_on TIMESTAMP NULL
);