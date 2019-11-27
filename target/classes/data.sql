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
--EQUIPMENT1
INSERT INTO attacco(stamina_cost) VALUES (1);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,1,0);
INSERT INTO difesa VALUES ();
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (1,1,1,1);
INSERT INTO artefatto(artefatto_type,min_requirements_id,upgrades_left) VALUES ('Equipment',1,1);
INSERT INTO artefatto_attacchi(equipment_id,attacchi_id) VALUES (1,1);
INSERT INTO artefatto_difese(equipment_id,difese_id) VALUES (1,1);
--EQUIPMENT2
INSERT INTO attacco(stamina_cost) VALUES (2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (2,2,1);
INSERT INTO difesa VALUES ();
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO artefatto(artefatto_type,min_requirements_id,upgrades_left) VALUES ('Equipment',2,2);
INSERT INTO artefatto_attacchi(equipment_id,attacchi_id) VALUES (2,2);
INSERT INTO artefatto_difese(equipment_id,difese_id) VALUES (2,2);
--TITANITE
INSERT INTO artefatto(artefatto_type) VALUES ('Titanite');
--CREATE SOME PERSONAGGIO AND ADD SOME ARTIFACTS
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO personaggio(statistica_base_id) VALUES (2);
INSERT INTO personaggio_artefatti(artefatti_id,personaggio_id) VALUES (1,1);
INSERT INTO personaggio_artefatti(artefatti_id,personaggio_id) VALUES (2,1);
INSERT INTO personaggio_artefatti(artefatti_id,personaggio_id) VALUES (3,1);

