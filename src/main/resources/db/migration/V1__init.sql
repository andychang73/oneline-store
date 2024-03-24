CREATE TABLE IF NOT EXISTS customer(
	id BIGINT AUTO_INCREMENT,
	phone VARCHAR(32) NOT NULL UNIQUE,
	name VARCHAR(32) NOT NULL,
	address VARCHAR(128) NOT NULL,
	status VARCHAR(12) DEFAULT 'ENABLED',
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	CONSTRAINT uk_customer_phone UNIQUE (phone)
);

CREATE TABLE IF NOT EXISTS product(
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    price DECIMAL(21,4) NOT NULL,
    stock INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_product_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS sales_order(
    id BIGINT AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    total DECIMAL(21,4) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS sales_order_detail(
    id BIGINT AUTO_INCREMENT,
    sales_order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(32) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL NOT NULL,
    sub_total DECIMAL(21,4)
);

INSERT INTO customer (phone, name, address) VALUES
('0900-11111111', 'customer1', 'address1'),
('0900-11111112', 'customer1', 'address1'),
('0900-11111113', 'customer1', 'address1'),
('0900-22222222', 'customer2', 'address2'),
('0900-33333333', 'customer3', 'address3'),
('0900-44444444', 'customer4', 'address4'),
('0900-55555555', 'customer5', 'address5'),
('0900-66666666', 'customer6', 'address6'),
('0900-77777777', 'customer7', 'address7'),
('0900-88888888', 'customer8', 'address8'),
('0900-99999999', 'customer9', 'address9');

INSERT INTO product (name, price, stock) VALUES
('iPhone15', 40000.00, 1),
('iPhone14', 30000.00, 100),
('iPhone13', 20000.00, 100),
('Mac Pro 16-inch', 60000.00, 100),
('Mac Pro 13-inch', 50000.00, 100),
('Mac Air 15-inch', 40000.00, 100),
('Mac Air 13-inch', 30000.00, 100),
('iPad', 20000.00, 100),
('iWatch', 12000.00, 100),
('AirPod', 8000.00, 100);