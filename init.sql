
CREATE SCHEMA IF NOT EXISTS games_truth;
CREATE TABLE IF NOT EXISTS games_truth.player
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) not null
    )