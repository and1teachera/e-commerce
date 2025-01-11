-- Clear existing data to avoid primary key conflicts
DELETE FROM ecommerce.PRODUCT;
DELETE FROM ecommerce.PRODUCT_CATEGORY;

-- Insert categories into the PRODUCT_CATEGORY table
INSERT INTO ecommerce.PRODUCT_CATEGORY (id, category_name) VALUES (1, 'BOOKS');

-- Insert products into the PRODUCT table
INSERT INTO ecommerce.PRODUCT (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript', 'assets/images/products/placeholder.png', 1, 100, 19.99, 1, NOW());

INSERT INTO ecommerce.PRODUCT (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring', 'assets/images/products/placeholder.png', 1, 100, 29.99, 1, NOW());

INSERT INTO ecommerce.PRODUCT (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes', 'assets/images/products/placeholder.png', 1, 100, 24.99, 1, NOW());

INSERT INTO ecommerce.PRODUCT (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT', 'assets/images/products/placeholder.png', 1, 100, 29.99, 1, NOW());

INSERT INTO ecommerce.PRODUCT (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go', 'assets/images/products/placeholder.png', 1, 100, 24.99, 1, NOW());
COMMIT ;