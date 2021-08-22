-- insert makes
INSERT INTO make(country, name) VALUES ('USA','FORD')
INSERT INTO make(country, name) VALUES ('Germany','AUDI')

-- insert models
-- FORD
INSERT INTO model(name, type, make_id) VALUES ('Ford Falcon', 'SEDAN',(SELECT id from make WHERE name = 'FORD'))
INSERT INTO model(name, type, make_id) VALUES ('Ford Focus Sedan', 'SEDAN',(SELECT id from make WHERE name = 'FORD'))
INSERT INTO model(name, type, make_id) VALUES ('Ford Focus Hatch', 'HATCHBACK',(SELECT id from make WHERE name = 'FORD'))
INSERT INTO model(name, type, make_id) VALUES ('Ford Puma', 'SUV',(SELECT id from make WHERE name = 'FORD'))
--AUDI
INSERT INTO model(name, type, make_id) VALUES ('Audi A4 Sedan', 'SEDAN',(SELECT id from make WHERE name = 'AUDI'))
INSERT INTO model(name, type, make_id) VALUES ('Audi S4 Sedan', 'SEDAN',(SELECT id from make WHERE name = 'AUDI'))
INSERT INTO model(name, type, make_id) VALUES ('Audi A6 Sedan', 'SEDAN',(SELECT id from make WHERE name = 'AUDI'))
INSERT INTO model(name, type, make_id) VALUES ('Audi Q2', 'SUV',(SELECT id from make WHERE name = 'AUDI'))