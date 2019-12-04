--CREATE MODALITA STORIA
INSERT INTO modalita(name) values ('storia');
INSERT INTO descrittore_dungeon(boss_name) values ('prova1');
INSERT INTO descrittore_dungeon(boss_name) values ('prova2');
INSERT INTO descrittore_dungeon(boss_name) values ('prova3');
INSERT INTO descrittore_incontro values (1);
INSERT INTO descrittore_incontro values (2);
INSERT INTO descrittore_incontro values (3);
INSERT INTO descrittore_incontro values (4);
INSERT INTO descrittore_incontro values (5);
INSERT INTO descrittore_incontro values (6);
INSERT INTO descrittore_incontro values (7);
INSERT INTO descrittore_incontro values (8);
INSERT INTO descrittore_incontro values (9);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova1',1);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova1',2);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova1',3);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova2',4);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova2',5);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova2',6);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova3',7);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova3',8);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova3',9);
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova1');
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova2');
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova3');

--CREATE SOME EQUIPMENT
--EQUIPMENT1 - Spada Leggera
INSERT INTO attacco(stamina_cost) VALUES (1); --id = 1
INSERT INTO attacco(stamina_cost) VALUES (2); --id = 2
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,1,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (2,2,2);
INSERT INTO difesa VALUES ();
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (1,1,1,1); --E' il primo oggetto creato quindi il suo ID = 1
INSERT INTO equipment(slot_type,min_requirements_id,upgrades_left, name) VALUES (0,1,1, 'Spada leggera');
INSERT INTO equipment_attacchi(equipment_id,attacchi_id) VALUES (1,1); --Tabella di JOIN
INSERT INTO equipment_attacchi(equipment_id,attacchi_id) VALUES (1,2); --Tabella di JOIN
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (1,1); --Tabella di JOIN

--EQUIPMENT2 - Armatura leggera
INSERT INTO attacco(stamina_cost) VALUES (2); --id = 3
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (3,2,1);
INSERT INTO difesa VALUES ();
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO equipment(slot_type,min_requirements_id,upgrades_left, name) VALUES (1,2,2, 'Armatura leggera');
INSERT INTO equipment_attacchi(equipment_id,attacchi_id) VALUES (2,3); --Tabella di JOIN
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (2,2); --Tabella di JOIN

--TITANITE
INSERT INTO titanite(slot_type,available,looted,dice_color) VALUES (0,4,4,0);
INSERT INTO titanite(slot_type,available,looted,dice_color) VALUES (0,4,4,1);
INSERT INTO titanite(slot_type,available,looted,dice_color) VALUES (1,3,3,1);

--CREATE SOME PERSONAGGIO AND ADD SOME ARTIFACTS
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO personaggio(statistica_base_id) VALUES (2);
INSERT INTO personaggio_equipaggiamenti(equipaggiamenti_id,personaggio_id) VALUES (1,1);
INSERT INTO personaggio_equipaggiamenti(equipaggiamenti_id,personaggio_id) VALUES (2,1);
INSERT INTO personaggio_titaniti(titaniti_id,personaggio_id) VALUES (1,1);
INSERT INTO personaggio_titaniti(titaniti_id,personaggio_id) VALUES (2,1);
INSERT INTO personaggio_titaniti(titaniti_id,personaggio_id) VALUES (3,1);
