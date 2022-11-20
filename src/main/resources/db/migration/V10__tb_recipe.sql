CREATE TABLE TB_RECIPE
(
    id             serial PRIMARY KEY,
    name           VARCHAR(50) NULL,
    ingredient_id  INTEGER NULL,
    instruction_id INTEGER NULL,
    meal_id        INTEGER NULL,
    type           VARCHAR(20) NULL,
    status         VARCHAR(20) NULL,
    created_on     TIMESTAMP NULL,
    updated_on     TIMESTAMP NULL
);