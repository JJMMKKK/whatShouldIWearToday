CREATE TABLE clothvo (
         clothid SERIAL PRIMARY KEY,
         userid INTEGER REFERENCES membervo(userid) ON DELETE CASCADE,
         category VARCHAR(50) NOT NULL,
         clothdata VARCHAR(100) NOT NULL
);