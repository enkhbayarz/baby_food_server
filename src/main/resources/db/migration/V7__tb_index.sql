CREATE TABLE TB_INDEX
(
    id           serial PRIMARY KEY,
    index_number NUMERIC NULL,
    type         VARCHAR(20) NULL,
    status       VARCHAR(20) NULL,
    created_on   TIMESTAMP NULL,
    updated_on   TIMESTAMP NULL
);