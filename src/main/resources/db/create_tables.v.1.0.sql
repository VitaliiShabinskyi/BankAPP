# CREATE TABLE IF NOT EXISTS managers
# (
#     id         INT PRIMARY KEY AUTO_INCREMENT,
#     first_name VARCHAR(50) NOT NULL,
#     last_name  VARCHAR(50) NOT NULL,
#     status     INT(1),
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );
#
# CREATE TABLE IF NOT EXISTS products
# (
#     id            INT PRIMARY KEY AUTO_INCREMENT,
#     manager_id    INT         NOT NULL,
#     name          VARCHAR(70) NOT NULL,
#     status        INT(1),
#     currency_code INT(2),
#     interest_rate DECIMAL(6, 4) DEFAULT 0,
#     `limit`       INT,
#     created_at    TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
#     updated_at    TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
#     FOREIGN KEY (manager_id) REFERENCES managers (id)
# );
#
# CREATE TABLE IF NOT EXISTS clients
# (
#     id         BINARY(16) PRIMARY KEY NOT NULL,
#     manager_id INT                    NOT NULL,
#     status     INT(1),
#     tax_code   VARCHAR(20),
#     first_name VARCHAR(50)            NOT NULL,
#     last_name  VARCHAR(50)            NOT NULL,
#     email      VARCHAR(60),
#     address    VARCHAR(80)            NOT NULL,
#     phone      VARCHAR(20)            NOT NULL,
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     FOREIGN KEY (manager_id) REFERENCES managers (id)
# );
#
# CREATE TABLE IF NOT EXISTS accounts
# (
#     id            BINARY(16) PRIMARY KEY NOT NULL,
#     client_id     BINARY(16)             NOT NULL,
#     name          VARCHAR(100)           NOT NULL,
#     type          INT(1),
#     status        INT(1),
#     balance       DECIMAL(15, 2) DEFAULT 0,
#     currency_code INT(2),
#     created_at    TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
#     updated_at    TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
#     FOREIGN KEY (client_id) REFERENCES clients (id)
# );
#
# CREATE TABLE IF NOT EXISTS agreements
# (
#     id            INT PRIMARY KEY AUTO_INCREMENT,
#     account_id    BINARY(16) NOT NULL,
#     product_id    INT        NOT NULL,
#     interest_rate DECIMAL(6, 4)  DEFAULT 0,
#     status        INT(1),
#     sum           DECIMAL(15, 2) DEFAULT 0,
#     created_at    TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
#     updated_at    TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
#     FOREIGN KEY (account_id) REFERENCES accounts (id),
#     FOREIGN KEY (product_id) REFERENCES products (id)
# );
#
# CREATE TABLE IF NOT EXISTS transactions
# (
#     id                BINARY(16) PRIMARY KEY NOT NULL,
#     debit_account_id  BINARY(16)             NOT NULL,
#     credit_account_id BINARY(16)             NOT NULL,
#     type              INT(1),
#     amount            DECIMAL(12, 4) DEFAULT 0,
#     description       VARCHAR(255),
#     created_at        TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
#     FOREIGN KEY (debit_account_id) REFERENCES accounts (id),
#     FOREIGN KEY (credit_account_id) REFERENCES accounts (id)
# );