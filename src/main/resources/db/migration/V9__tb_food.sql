CREATE TABLE TB_FOOD
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) NULL,
    description VARCHAR(50) NULL,
    calorie     NUMERIC NULL,
    type        VARCHAR(20) NULL,
    status      VARCHAR(20) NULL,
    created_on  TIMESTAMP NULL,
    updated_on  TIMESTAMP NULL
);