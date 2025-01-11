DROP SCHEMA IF EXISTS ecommerce;

CREATE SCHEMA ecommerce;

CREATE TABLE IF NOT EXISTS ecommerce.product_category (
                                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                          category_name VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS ecommerce.product (
                                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                 sku VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    unit_price DECIMAL(13,2),
    image_url VARCHAR(255),
    active BOOLEAN,
    units_in_stock INT,
    date_created TIMESTAMP,
    last_updated TIMESTAMP,
    category_id BIGINT,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES ecommerce.product_category (id)
    );

COMMIT;