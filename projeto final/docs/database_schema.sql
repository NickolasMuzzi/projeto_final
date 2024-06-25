CREATE TABLE `projeto_final`.`users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(200) NOT NULL,
    `password` LONGTEXT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO
    products (name, description, price)
VALUES
    (
        'Samsung Galaxy S22 Ultra',
        'Smartphone Samsung, 256GB de armazenamento, 12GB de RAM',
        5999.99
    ),
    (
        'Dell XPS 15 9500',
        'Notebook Dell, SSD 512GB, Intel Core i7-10750H, NVIDIA GTX 1650 Ti 4GB, RAM 16GB',
        8999.00
    ),
    (
        'Logitech G Pro X Superlight',
        'Mouse Gamer, sensor HERO 25K, peso leve, sem fio',
        499.90
    ),
    (
        'Crucial P5 Plus 2TB NVMe',
        'SSD NVMe PCIe Gen4, velocidades de leitura de até 6600MB/s',
        499.99
    ),
    (
        'Apple AirPods Pro',
        'Fones de ouvido sem fio, cancelamento ativo de ruído, resistência à água e suor',
        1499.00
    ),
    (
        'Sony PlayStation 5',
        'Console de videogame, disco SSD 825GB, suporte para ray tracing, 4K HDR',
        4999.00
    ) (
        'Iphone 15 Pro Max',
        'Smartphone Apple, 128GB de armazenamento, 8GB de RAM',
        7000.00
    ),
    (
        'Notebook Acer Nitro 5',
        'Notebook Gamer, SSD 1TB, Intel core I7 9600k, RTX 4090 8GB, RAM 32GB',
        10000.00
    ),
    (
        'Mouse Gamer Razer Deathadder',
        'Mouse Gamer, 16.000 dpi, sensor Razer focus PRO, sem fio',
        700.00
    ),
    (
        'SSD 480GB KINGSTON',
        'SSD SATA 480GB KINGSTON',
        250.00
    );

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    card_number VARCHAR(16) NOT NULL,
    card_holder_name VARCHAR(100) NOT NULL,
    expiration_date VARCHAR(7) NOT NULL,
    -- Formato MM/AAAA
    cvv VARCHAR(3) NOT NULL,
    installments INT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    product_ids TEXT,
    -- Campo para armazenar os IDs dos produtos selecionados
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
