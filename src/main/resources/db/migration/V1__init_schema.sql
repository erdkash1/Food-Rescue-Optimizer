
CREATE TABLE donors (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(255) ,
    name VARCHAR(255),
    latitude NUMERIC(10, 7),
    longitude NUMERIC(10, 7)

    );