DROP DATABASE IF EXISTS brief_architecture;
DROP USER IF EXISTS admin_architecture;
DROP ROLE IF EXISTS admin_architecture;

-- Création de l'utilisateur administrateur et attribution des droits
CREATE USER $DB_USER WITH PASSWORD '$DB_PASSWORD';
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO $DB_USER;

CREATE DATABASE brief_architecture OWNER $DB_USER;
\c brief_architecture;

-- Création de la table products
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    product_description VARCHAR(255) NOT NULL,
    product_price DECIMAL(15,2) NOT NULL
);

-- Création de la table stocks avec clé étrangère vers products
CREATE TABLE stocks (
    stock_id SERIAL PRIMARY KEY,
    product_stock INT NOT NULL,
    product_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Création de la table shopping_carts
CREATE TABLE shopping_carts (
    cart_id SERIAL PRIMARY KEY,
    product_quantity INT NOT NULL
);

-- Création de la table de jointure products_shopping_carts
CREATE TABLE products_shopping_carts (
    product_id BIGINT,
    cart_id BIGINT,
    quantity INT NOT NULL,
    PRIMARY KEY (product_id, cart_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (cart_id) REFERENCES shopping_carts(cart_id)
);


-- Insertion des données dans la table products
INSERT INTO products (product_name, product_description, product_price) VALUES
    ('Ordinateur portable', 'Ordinateur portable haute performance', 999.99),
    ('Smartphone', 'Smartphone dernière génération', 699.99),
    ('Tablette', 'Tablette tactile 10 pouces', 299.99),
    ('Casque audio', 'Casque audio sans fil', 149.99),
    ('Souris gaming', 'Souris gaming RGB', 79.99);

-- Insertion des données dans la table stocks
INSERT INTO stocks (product_stock, product_id) VALUES
    (50, 1),
    (100, 2),
    (75, 3),
    (200, 4),
    (150, 5);

-- Insertion des données dans la table shopping_carts
INSERT INTO shopping_carts (product_quantity) VALUES
    (3),
    (2),
    (4);

-- Insertion des données dans la table de jointure products_shopping_carts
INSERT INTO products_shopping_carts (product_id, cart_id, quantity) VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 1),
    (4, 2, 1),
    (5, 3, 2),
    (1, 3, 2);