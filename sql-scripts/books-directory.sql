CREATE DATABASE IF NOT EXISTS `books_directory`;
USE `books_directory`;

-- Table structure for table `book`
DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(45) DEFAULT NULL,
                        `price` VARCHAR(45) DEFAULT NULL,
                        `created_at` DATE DEFAULT CURRENT_DATE,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Data for table `book`
INSERT INTO `book` (`id`, `name`, `price`) VALUES
                                               (1, 'MATHS', '3000'),
                                               (2, 'ENGLISH', '4000'),
                                               (3, 'BIOLOGY', '2500');

-- USERS TABLE

CREATE DATABASE IF NOT EXISTS `user_management`;
USE `user_management`;

-- Table structure for table `users`
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `first_name` VARCHAR(50) NOT NULL,
                         `last_name` VARCHAR(50) NOT NULL,
                         `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Data for table `users`
INSERT INTO `users` (`first_name`, `last_name`) VALUES
                                                    ('Joy', 'Phoebe'),
                                                    ('Jane', 'Sarah'),

