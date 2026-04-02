-- (user -- garden) -- plant -- plant_action

CREATE SCHEMA IF NOT EXISTS wlg;

CREATE TABLE IF NOT EXISTS wlg.plant (
    id BIGSERIAL PRIMARY KEY,                   -- generovane id
    nick VARCHAR(64) NOT NULL,                  -- kanadska boruvka
    name VARCHAR(64) NOT NULL,                  -- brusnice chocholičnatá
    latin_name VARCHAR(256),                    -- Vaccinium corymbosum
    plant_type VARCHAR(64),                     -- kerik, strom
    CONSTRAINT uq_plant_name UNIQUE (name)
    );

CREATE TABLE IF NOT EXISTS wlg.plant_action (
    id BIGSERIAL PRIMARY KEY,                   -- generovane id
    action_type VARCHAR(64) NOT NULL,           -- strihani, hnojeni
    action_detail VARCHAR(128),                 -- strihani, hnojeni
    month_from INT NOT NULL,                    -- odkdy
    month_to INT NOT NULL,                      -- dokdy
    note VARCHAR(512),                          -- jak strihat nebo cim hnojit
    plant_id BIGINT NOT NULL,                   -- reference na rostlinu
    CONSTRAINT fk_plant
        FOREIGN KEY (plant_id)
        REFERENCES wlg.plant(id)
        ON DELETE CASCADE,                      -- smaznout kdyz neni plant, mesice platne jen 1-12
    CONSTRAINT chk_month_range CHECK (month_from BETWEEN 1 AND 12 AND month_to BETWEEN 1 AND 12)
    );
                                                -- index na plant pro plant_action
CREATE INDEX idx_plant_action_plant_id ON wlg.plant_action(plant_id);
                                                -- pro search podle bezneho nazvu
CREATE INDEX idx_plant_nick ON wlg.plant(nick);

