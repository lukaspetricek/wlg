-- plants

INSERT INTO wlg.plant (nick, name, latin_name, plant_type)
VALUES

-- keře

    ('Kanadská borůvka', 'Brusnice chocholičnatá', 'Vaccinium corymbosum', 'keřík'),
    ('Angrešt', 'Srstka angrešt', 'Ribes uva-crispa', 'keřík'),
    ('Rybíz', 'Rybíz červený/bílý/černý', 'Ribes rubrum', 'keřík'),
    ('Muchovník', 'Muchovník olšolistý', 'Amelanchier alnifolia', 'keřík'),

-- stromy

    ('Moruše', 'Moruše bílá/černá', 'Morus alba', 'strom'),
    ('Hrušeň', 'Hrušeň obecná', 'Pyrus communis', 'strom'),
    ('Jabloň', 'Jabloň domácí', 'Malus domestica', 'strom'),
    ('Švestka', 'Slivoň švestka', 'Prunus domestica', 'strom'),
    ('Třešeň', 'Třešeň ptačí', 'Prunus avium', 'strom'),
    ('Meruňka', 'Meruňka obecná', 'Prunus armeniaca', 'strom'),
    ('Nektarinka', 'Nektarinka', 'Prunus persica var. nucipersica', 'strom');


-- plants_action

INSERT INTO wlg.plant_action (action_type, action_detail, month_from, month_to, note, plant_id)
VALUES

-- BORŮVKA
('stříhání', 'prořez', 3, 3, 'odstranit staré, slabé a málo plodící větve',
 (SELECT id FROM wlg.plant WHERE name = 'Brusnice chocholičnatá')),
('hnojení', 'jarní', 4, 5, 'hnojivo pro kyselomilné rostliny cca 50g/m2',
 (SELECT id FROM wlg.plant WHERE name = 'Brusnice chocholičnatá')),

-- ANGREŠT
('stříhání', 'prořez', 3, 3, 'odstranit staré větve a prosvětlit keř',
 (SELECT id FROM wlg.plant WHERE name = 'Srstka angrešt')),
('hnojení', 'jarní', 4, 5, 'organické hnojivo nebo kompost',
 (SELECT id FROM wlg.plant WHERE name = 'Srstka angrešt')),

-- RYBÍZ
('stříhání', 'prořez', 3, 3, 'odstranit staré větve, ponechat mladé výhony',
 (SELECT id FROM wlg.plant WHERE name = 'Rybíz červený/bílý/černý')),
('hnojení', 'jarní', 4, 5, 'kompost nebo univerzální hnojivo',
 (SELECT id FROM wlg.plant WHERE name = 'Rybíz červený/bílý/černý')),

-- MUCHOVNÍK
('stříhání', 'prořez', 2, 3, 'lehké prosvětlení, odstranit poškozené větve',
 (SELECT id FROM wlg.plant WHERE name = 'Muchovník olšolistý')),
('hnojení', 'jarní', 4, 5, 'nenáročný, stačí kompost',
 (SELECT id FROM wlg.plant WHERE name = 'Muchovník olšolistý')),

-- MORUŠE
('stříhání', 'prořez', 2, 3, 'tvarovací řez, odstranit přerostlé větve',
 (SELECT id FROM wlg.plant WHERE name = 'Moruše bílá/černá')),
('hnojení', 'jarní', 4, 5, 'organické hnojivo nebo kompost',
 (SELECT id FROM wlg.plant WHERE name = 'Moruše bílá/černá')),

-- HRUŠEŇ
('stříhání', 'prořez', 2, 3, 'odstranit křížící se větve, tvarovat korunu',
 (SELECT id FROM wlg.plant WHERE name = 'Hrušeň obecná')),
('hnojení', 'jarní', 3, 4, 'hnojivo pro ovocné stromy',
 (SELECT id FROM wlg.plant WHERE name = 'Hrušeň obecná')),

-- JABLOŇ
('stříhání', 'prořez', 2, 3, 'zimní řez, odstranit staré a nemocné větve',
 (SELECT id FROM wlg.plant WHERE name = 'Jabloň domácí')),
('hnojení', 'jarní', 3, 4, 'dusíkaté hnojivo pro podporu růstu',
 (SELECT id FROM wlg.plant WHERE name = 'Jabloň domácí')),

-- ŠVESTKA
('stříhání', 'prořez', 3, 3, 'lehké prořezání, spíše po sklizni',
 (SELECT id FROM wlg.plant WHERE name = 'Slivoň švestka')),
('hnojení', 'jarní', 3, 4, 'kompost nebo organické hnojivo',
 (SELECT id FROM wlg.plant WHERE name = 'Slivoň švestka')),

-- TŘEŠEŇ
('stříhání', 'prořez', 6, 7, 'řez po sklizni, aby se snížilo riziko chorob',
 (SELECT id FROM wlg.plant WHERE name = 'Třešeň ptačí')),
('hnojení', 'jarní', 3, 4, 'hnojivo pro ovocné stromy',
 (SELECT id FROM wlg.plant WHERE name = 'Třešeň ptačí')),

-- MERUŇKA
('stříhání', 'prořez', 3, 4, 'odstranit poškozené větve, tvarování',
 (SELECT id FROM wlg.plant WHERE name = 'Meruňka obecná')),
('hnojení', 'jarní', 3, 4, 'kompost nebo lehké hnojení',
 (SELECT id FROM wlg.plant WHERE name = 'Meruňka obecná')),

-- NEKTARINKA
('stříhání', 'prořez', 3, 4, 'prosvětlení koruny, podpora plodnosti',
 (SELECT id FROM wlg.plant WHERE name = 'Nektarinka')),
('hnojení', 'jarní', 3, 4, 'hnojivo pro peckoviny',
 (SELECT id FROM wlg.plant WHERE name = 'Nektarinka'));