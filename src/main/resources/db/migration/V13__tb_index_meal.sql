CREATE TABLE TB_INDEX_MEAL
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) NULL,
    description VARCHAR(50) NULL,
    index_id    INTEGER NULL,
    meal_id     INTEGER NULL,
    type        VARCHAR(20) NULL,
    status      VARCHAR(20) NULL,
    created_on  TIMESTAMP NULL,
    updated_on  TIMESTAMP NULL
);