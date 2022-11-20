CREATE TABLE TB_INGREDIENT_FOOD
(
    id            serial PRIMARY KEY,
    name          VARCHAR(50) NULL,
    description   VARCHAR(50) NULL,
    food_id       INTEGER NULL,
    ingredient_id INTEGER NULL,
    type          VARCHAR(20) NULL,
    status        VARCHAR(20) NULL,
    created_on    TIMESTAMP NULL,
    updated_on    TIMESTAMP NULL
);