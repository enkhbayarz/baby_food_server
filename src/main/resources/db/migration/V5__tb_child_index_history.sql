CREATE TABLE TB_CHILD_FOOD_INDEX_HISTORY
(
    id         serial PRIMARY KEY,
    weight     NUMERIC NULL,
    height     NUMERIC NULL,
    index      NUMERIC NULL,
    type       VARCHAR(20) NULL,
    status     VARCHAR(20) NULL,
    child_id   INTEGER NULL,
    created_on TIMESTAMP NULL,
    updated_on TIMESTAMP NULL
);