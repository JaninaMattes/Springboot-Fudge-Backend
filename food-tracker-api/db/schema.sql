DROP DATABASE foodtrackerdb;
DROP USER foodtracker;

CREATE USER foodtracker WITH PASSWORD 'password';
CREATE DATABASE foodtrackerdb WITH template=template0 owner=foodtracker;

\connect foodtrackerdb;

ALTER DEFAULT PRIVILEGES GRANT ALL ON tables TO foodtracker;
ALTER DEFAULT PRIVILEGES GRANT ALL ON sequences TO foodtracker;

CREATE TABLE et_users(
                         user_id INTEGER PRIMARY KEY NOT NULL,
                         first_name VARCHAR(20) NOT NULL,
                         last_name VARCHAR(20) NOT NULL,
                         email VARCHAR(30) NOT NULL,
                         password TEXT NOT NULL,
                         user_image VARCHAR(255),
                         is_logged_in BOOLEAN DEFAULT FALSE
);

CREATE TABLE et_settings(
                              settings_id INTEGER PRIMARY KEY NOT NULL,
                              user_id INTEGER NOT NULL,
                              reminder_product_expiration BOOLEAN DEFAULT FALSE,
                              suggest_recipes BOOLEAN DEFAULT FALSE,
                              push_notifications BOOLEAN DEFAULT FALSE
);
ALTER TABLE et_settings add CONSTRAINT settings_users_fk
    FOREIGN KEY(user_id) REFERENCES et_users(user_id);

CREATE TABLE et_recipe(
                              recipe_id INTEGER PRIMARY KEY NOT NULL,
                              user_id INTEGER NOT NULL,
                              title VARCHAR(50) NOT NULL,
                              recipe_description VARCHAR(255) NOT NULL,
                              rating DECIMAL(4,2) NOT NULL,
                              cooking_time DECIMAL(4,2) NOT NULL,
                              difficulty VARCHAR(25) NOT NULL,
                              instruction VARCHAR(1024) NOT NULL,
                              nutrition_value VARCHAR(25) NOT NULL,
                              image_url VARCHAR(1024) NOT NULL
);
ALTER TABLE et_recipe add CONSTRAINT recipe_users_fk
    FOREIGN KEY(user_id) REFERENCES et_users(user_id);

CREATE TABLE et_ingredient(
                              ingredient_id INTEGER PRIMARY KEY NOT NULL,
                              ingredient_name VARCHAR(25) NOT NULL,
                              quantity VARCHAR(50) NOT NULL
);

CREATE TABLE et_recipe_ingredient(
                              recipe_id INTEGER REFERENCES et_recipe,
                              ingredient_id INTEGER REFERENCES et_ingredient,
                              PRIMARY KEY(recipe_id, ingredient_id)
);

CREATE TABLE et_tag(
                              tag_id INTEGER PRIMARY KEY NOT NULL,
                              label VARCHAR(25) NOT NULL
);

CREATE TABLE et_user_tag(
                              user_id INTEGER REFERENCES et_users,
                              tag_id INTEGER REFERENCES et_tag,
                              PRIMARY KEY(user_id, tag_id)
);

CREATE TABLE et_recipe_tag(
                              recipe_id INTEGER REFERENCES et_recipe,
                              tag_id INTEGER REFERENCES et_tag,
                              PRIMARY KEY(recipe_id, tag_id)
);

CREATE TABLE et_inventorylist(
                              inventorylist_id INTEGER PRIMARY KEY NOT NULL,
                              user_id INTEGER NOT NULL
);
ALTER TABLE et_inventorylist add CONSTRAINT inventorylist_users_fk
    FOREIGN KEY(user_id) REFERENCES et_users(user_id);

CREATE TABLE et_shoppinglist(
                              current_shoppinglist_id INTEGER PRIMARY KEY NOT NULL,
                              past_shoppinglist_id INTEGER
);

CREATE TABLE et_product(
                              product_id INTEGER PRIMARY KEY NOT NULL,
                              user_id INTEGER NOT NULL,
                              shoppinglist_id INTEGER,
                              inventorylist_id INTEGER,
                              product_name VARCHAR(50) NOT NULL,
                              expiration_date date NOT NULL, 
                              quantity DECIMAL(4,2) NOT NULL,
                              manufacturer VARCHAR(25),
                              nutrition_value VARCHAR(25),
                              image_url VARCHAR(1024)
);
ALTER TABLE et_product add CONSTRAINT product_users_fk
    FOREIGN KEY(user_id) REFERENCES et_users(user_id);
ALTER TABLE et_product add CONSTRAINT product_shoppinglist_fk
    FOREIGN KEY(shoppinglist_id) REFERENCES et_shoppinglist(current_shoppinglist_id);
ALTER TABLE et_product add CONSTRAINT product_inventorylist_fk
    FOREIGN KEY(inventorylist_id) REFERENCES et_inventorylist(inventorylist_id);

CREATE SEQUENCE et_users_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_settings_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_recipe_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_ingredient_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_tag_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_inventorylist_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_shoppinglist_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE et_product_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;
