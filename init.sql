CREATE TABLE IF NOT EXISTS Report (
    reportID SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    espece VARCHAR(60) NOT NULL,
    nombre INT NOT NULL,
    ville VARCHAR(50) NOT NULL,
    date_pub TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);