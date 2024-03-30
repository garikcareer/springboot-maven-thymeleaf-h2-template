CREATE TABLE IF NOT EXISTS company
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(40) UNIQUE NOT NULL,
    location VARCHAR(100)       NOT NULL,
    INDEX (name)
) engine = InnoDB;