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

-- Ajout des contraintes pour assurer la relation 1-1 entre products et stocks
ALTER TABLE products
ADD CONSTRAINT fk_product_stock
FOREIGN KEY (product_id) REFERENCES stocks(stock_id);


