CREATE TABLE food_items(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    donor_id UUID REFERENCES donors(id),
    description VARCHAR(255),
    quantity_kg NUMERIC(10, 2),
    available_from TIMESTAMP,
    expires_at TIMESTAMP
    );



CREATE TABLE recipients (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email VARCHAR(255) ,
    name VARCHAR(255),
    latitude NUMERIC(10, 7),
    longitude NUMERIC(10, 7),
    capacity NUMERIC(10, 2)

    );

CREATE TABLE vehicles (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    vehicle_type VARCHAR(255),
    capacity_kg NUMERIC(10,2),
    shift_start TIME,
    shift_end TIME

    );


CREATE TABLE routes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    vehicle_id UUID REFERENCES vehicles(id),
    route_date DATE,
    total_distance_km NUMERIC(10, 2),
    total_kg_rescued NUMERIC(10, 2)


    );

CREATE TABLE route_stops (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    vehicle_id UUID REFERENCES vehicles(id),
    food_item_id UUID REFERENCES food_items(id),
    recipient_id UUID REFERENCES recipients(id),
    stop_order INTEGER,
    stop_type VARCHAR(20)

    );
