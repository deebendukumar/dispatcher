-- Warehouses Table
CREATE TABLE warehouses (
    warehouse_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Products Table
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    unit_price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Stock Table (Tracks inventory levels per warehouse)
CREATE TABLE stock (
    stock_id SERIAL PRIMARY KEY,
    warehouse_id INT REFERENCES warehouses(warehouse_id) ON DELETE CASCADE,
    product_id INT REFERENCES products(product_id) ON DELETE CASCADE,
    quantity INT NOT NULL DEFAULT 0,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (warehouse_id, product_id)  -- Ensures no duplicate stock entry for the same warehouse-product combination
);

-- Suppliers Table
CREATE TABLE suppliers (
    supplier_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255),
    contact_phone VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Purchase Orders Table (For stock procurement)
CREATE TABLE purchase_orders (
    po_id SERIAL PRIMARY KEY,
    supplier_id INT REFERENCES suppliers(supplier_id) ON DELETE SET NULL,
    warehouse_id INT REFERENCES warehouses(warehouse_id) ON DELETE CASCADE,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) CHECK (status IN ('Pending', 'Received', 'Cancelled'))
);

-- Purchase Order Items (Details of products ordered in a PO)
CREATE TABLE purchase_order_items (
    poi_id SERIAL PRIMARY KEY,
    po_id INT REFERENCES purchase_orders(po_id) ON DELETE CASCADE,
    product_id INT REFERENCES products(product_id) ON DELETE CASCADE,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL
);

-- Sales Orders Table (For stock dispatch)
CREATE TABLE sales_orders (
    so_id SERIAL PRIMARY KEY,
    warehouse_id INT REFERENCES warehouses(warehouse_id) ON DELETE CASCADE,
    customer_name VARCHAR(255) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) CHECK (status IN ('Pending', 'Shipped', 'Delivered', 'Cancelled'))
);

-- Sales Order Items (Details of products in a sales order)
CREATE TABLE sales_order_items (
    soi_id SERIAL PRIMARY KEY,
    so_id INT REFERENCES sales_orders(so_id) ON DELETE CASCADE,
    product_id INT REFERENCES products(product_id) ON DELETE CASCADE,
    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL
);

-- Inventory Transactions (Tracks stock movements)
CREATE TABLE inventory_transactions (
    transaction_id SERIAL PRIMARY KEY,
    warehouse_id INT REFERENCES warehouses(warehouse_id) ON DELETE CASCADE,
    product_id INT REFERENCES products(product_id) ON DELETE CASCADE,
    transaction_type VARCHAR(50) CHECK (transaction_type IN ('Inbound', 'Outbound', 'Adjustment')),
    quantity INT NOT NULL,
    reference_id INT,  -- Can link to purchase_order_items, sales_order_items, or manual adjustments
    reference_type VARCHAR(50), -- 'Purchase Order', 'Sales Order', 'Manual Adjustment'
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);