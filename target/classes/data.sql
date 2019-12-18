--CREATE MODALITA STORIA
INSERT INTO modalita(name) values ('storia');
INSERT INTO descrittore_dungeon(boss_name) values ('prova1');
INSERT INTO descrittore_dungeon(boss_name) values ('prova2');
INSERT INTO descrittore_dungeon(boss_name) values ('prova3');
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_incontro values ();
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova1',1);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova1',2);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova1',3);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova2',4);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova2',5);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova2',6);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova3',7);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova3',8);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id) values ('prova3',9);
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova1');
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova2');
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova3');
--CREATE SOME EQUIPMENT
--EQUIPMENT1
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',1);
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,1,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,2,1);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (2,2,2);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (1,1,1,1); --E' il primo oggetto creato quindi il suo ID = 1
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,1);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_max, name,body_part_requirement_id) VALUES ('Arma',1,1, 'Spada leggera',1);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (1,1);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (1,2);--Tabella di JOIN
--EQUIPMENT2
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (3,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Armatura',2,2,'Armatura leggera',2);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (2,3); --Tabella di JOIN
--EQUIPMENT3
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (4,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Armatura',3,2,'Armatura pesante',3);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (3,4); --Tabella di JOIN
--EQUIPMENT4
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (5,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (6,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,1);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Arma',4,2, 'Ascia',4);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (4,5); --Tabella di JOIN
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (4,6); --Tabella di JOIN
--EQUIPMENT5
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (7,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (8,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,2);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Arma',5,2,'Spadone Imperiale',5);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (5,7); --Tabella di JOIN
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (5,8); --Tabella di JOIN
--BODYPART1
INSERT INTO body_part(name,body_part_type) VALUES ('Mano Sinistra',0);
--BODYPART2
INSERT INTO body_part(name,body_part_type) VALUES ('Mano Destra',0);
--BODYPART3
INSERT INTO body_part(name,body_part_type) VALUES ('Corpo',1);
--BODYPART4
INSERT INTO body_part(name,body_part_type) VALUES ('Due Mani',0);
--TITANITE
INSERT INTO titanite(equipment_type,available,looted,dice_color) VALUES (0,4,4,0);
INSERT INTO titanite(equipment_type,available,looted,dice_color) VALUES (0,4,4,1);
INSERT INTO titanite(equipment_type,available,looted,dice_color) VALUES (1,3,3,2);
--CREATE SOME descrittore_personaggio AND ADD SOME ARTIFACTS
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO descrittore_personaggio(hp_max,velocita,statistiche_base_id,anime) VALUES (200,5,6,1000);
INSERT INTO descrittore_personaggio_body_parts(descrittore_personaggio_id,body_parts_name) VALUES (1,'Mano Sinistra');
INSERT INTO descrittore_personaggio_body_parts(descrittore_personaggio_id,body_parts_name) VALUES (1,'Mano Destra');
INSERT INTO descrittore_personaggio_body_parts(descrittore_personaggio_id,body_parts_name) VALUES (1,'Corpo');
INSERT INTO descrittore_personaggio_zaino_equip(zaino_equip_id,descrittore_personaggio_id) VALUES (1,1);
INSERT INTO descrittore_personaggio_zaino_equip(zaino_equip_id,descrittore_personaggio_id) VALUES (2,1);
INSERT INTO descrittore_personaggio_zaino_equip(zaino_equip_id,descrittore_personaggio_id) VALUES (3,1);
INSERT INTO descrittore_personaggio_zaino_equip(zaino_equip_id,descrittore_personaggio_id) VALUES (4,1);
INSERT INTO descrittore_personaggio_zaino_equip(zaino_equip_id,descrittore_personaggio_id) VALUES (5,1);
INSERT INTO descrittore_personaggio_titaniti(titaniti_id,descrittore_personaggio_id) VALUES (1,1);
INSERT INTO descrittore_personaggio_titaniti(titaniti_id,descrittore_personaggio_id) VALUES (2,1);
INSERT INTO descrittore_personaggio_titaniti(titaniti_id,descrittore_personaggio_id) VALUES (3,1);
--CREATE SOME NEMICO AND ADD TO ENCOUNTERS
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (9,2,1);
INSERT INTO equipment(dtype,name,upgrades_max) VALUES ('Arma','Spada Nemico',0);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (6,9);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (6,10);
INSERT INTO nemico(nome,hp_max,velocita) VALUES ('Undead Hollow',200,5);
INSERT INTO nemico_equipaggiati(nemico_id,equipaggiati_id) VALUES (1,6);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (11,1,2);
INSERT INTO equipment(dtype,name,upgrades_max) VALUES ('Arma','Spada Nemico',0);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (7,11);
INSERT INTO equipment_azioni(equipment_id,azioni_id) VALUES (7,12);
INSERT INTO nemico(nome,hp_max,velocita) VALUES ('Soldier',300,2);
INSERT INTO nemico_equipaggiati(nemico_id,equipaggiati_id) VALUES (2,7);
INSERT INTO nemici_wrapper(number_nemici,nemico_id) VALUES (1,1);
INSERT INTO nemici_wrapper(number_nemici,nemico_id) VALUES (2,2);
--ADD ENEMY TO ENCOUNTER ID:1
INSERT INTO descrittore_incontro_nemici_wrappers(descrittore_incontro_id,nemici_wrappers_id)VALUES(1,1);
INSERT INTO descrittore_incontro_nemici_wrappers(descrittore_incontro_id,nemici_wrappers_id)VALUES(1,2);