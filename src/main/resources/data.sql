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
INSERT INTO descrittore_equipment(dtype,min_requirements_id,upgrades_max, name,body_part_requirement_id) VALUES ('Arma',1,1, 'Spada leggera',1);
INSERT INTO descrittore_equipment_attacchi(arma_name,attacchi_id) VALUES ('Spada leggera',1);
INSERT INTO descrittore_equipment_attacchi(arma_name,attacchi_id) VALUES ('Spada leggera',2);--Tabella di JOIN
INSERT INTO equipment(descrittore_equipment_name) VALUES ('Spada leggera');
--EQUIPMENT2
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (3,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO descrittore_equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Armatura',2,2,'Armatura leggera',2);
INSERT INTO descrittore_equipment_difese(descrittore_equipment_name,difese_id) VALUES ('Armatura leggera',3); --Tabella di JOIN
INSERT INTO equipment(descrittore_equipment_name) VALUES ('Armatura leggera');
--EQUIPMENT3
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (4,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO descrittore_equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Armatura',3,2,'Armatura pesante',3);
INSERT INTO descrittore_equipment_difese(difese_id,descrittore_equipment_name) VALUES (4,'Armatura pesante');
 INSERT INTO equipment(descrittore_equipment_name) VALUES ('Armatura pesante');--Tabella di JOIN
--EQUIPMENT4
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (5,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (6,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,1);
INSERT INTO descrittore_equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Arma',4,2, 'Ascia',4);
INSERT INTO descrittore_equipment_attacchi(arma_name,attacchi_id) VALUES ('Ascia',5); --Tabella di JOIN
INSERT INTO descrittore_equipment_difese(descrittore_equipment_name,difese_id) VALUES ('Ascia',6); --Tabella di JOIN
INSERT INTO equipment(descrittore_equipment_name) VALUES ('Ascia');
--EQUIPMENT5
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (7,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (8,2,1);
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,2);
INSERT INTO descrittore_equipment(dtype,min_requirements_id,upgrades_max,name,body_part_requirement_id) VALUES ('Arma',5,2,'Spadone Imperiale',5);
INSERT INTO descrittore_equipment_attacchi(arma_name,attacchi_id) VALUES ('Spadone Imperiale',7); --Tabella di JOIN
INSERT INTO descrittore_equipment_difese(difese_id,descrittore_equipment_name) VALUES (8,'Spadone Imperiale'); --Tabella di JOIN
INSERT INTO equipment(descrittore_equipment_name) VALUES ('Spadone Imperiale');
--BODYPART1
INSERT INTO body_part(name,body_part_type) VALUES ('Mano Sinistra',0);
--BODYPART2
INSERT INTO body_part(name,body_part_type) VALUES ('Mano Destra',0);
--BODYPART3
INSERT INTO body_part(name,body_part_type) VALUES ('Corpo',1);
--BODYPART4
INSERT INTO body_part(name,body_part_type) VALUES ('Due Mani',0);
--TITANITE
INSERT INTO titanite(equipment_type,available,looted,dice_color,anime) VALUES (0,4,4,0,2);
INSERT INTO titanite(equipment_type,available,looted,dice_color,anime) VALUES (0,4,4,1,1);
INSERT INTO titanite(equipment_type,available,looted,dice_color,anime) VALUES (1,3,3,2,1);

--CREATE SOME descrittore_personaggio AND ADD SOME ARTIFACTS
INSERT INTO statistiche_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO descrittore_personaggio_base(dtype,hp,velocita,statistiche_base_id,anime,stamina,name) VALUES ('Persoanggio',10,7,6,1000,10,'Guerriero');
INSERT INTO descrittore_personaggio_base_body_parts(descrittore_personaggio_name,body_parts_name) VALUES ('Guerriero','Mano Sinistra');
INSERT INTO descrittore_personaggio_base_body_parts(descrittore_personaggio_name,body_parts_name) VALUES ('Guerriero','Mano Destra');
INSERT INTO descrittore_personaggio_base_body_parts(descrittore_personaggio_name,body_parts_name) VALUES ('Guerriero','Corpo');
INSERT INTO descrittore_personaggio_base_zaino_equip(descrittore_personaggio_name,zaino_equip_id) VALUES ('Guerriero',1);
INSERT INTO descrittore_personaggio_base_zaino_equip(descrittore_personaggio_name,zaino_equip_id) VALUES ('Guerriero',2);
INSERT INTO descrittore_personaggio_base_zaino_equip(zaino_equip_id,descrittore_personaggio_name) VALUES (3,'Guerriero');
INSERT INTO descrittore_personaggio_base_zaino_equip(zaino_equip_id,descrittore_personaggio_name) VALUES (4,'Guerriero');
INSERT INTO descrittore_personaggio_base_zaino_equip(zaino_equip_id,descrittore_personaggio_name) VALUES (5,'Guerriero');
INSERT INTO descrittore_personaggio_base_titaniti(titaniti_id,descrittore_personaggio_name) VALUES (1,'Guerriero');
INSERT INTO descrittore_personaggio_base_titaniti(titaniti_id,descrittore_personaggio_name) VALUES (2,'Guerriero');
INSERT INTO descrittore_personaggio_base_titaniti(titaniti_id,descrittore_personaggio_name) VALUES (3,'Guerriero');
--CREATE SOME NEMICO AND ADD TO ENCOUNTERS

INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (9,2,1);
INSERT INTO descrittore_equipment(dtype,name,upgrades_max) VALUES ('Arma','Spada Nemico 1',0);
INSERT INTO descrittore_equipment_difese(descrittore_equipment_name,difese_id) VALUES ('Spada Nemico 1',9);
INSERT INTO descrittore_equipment_attacchi(arma_name,attacchi_id) VALUES ('Spada Nemico 1',10);
INSERT INTO equipment(descrittore_equipment_name) VALUES ('Spada Nemico 1');
INSERT INTO descrittore_personaggio_base(dtype,name,hp,velocita) VALUES ('Nemico','Undead Hollow',8,5);
INSERT INTO statistiche_combattimento_base(dtype,descrittore_personaggio_base_name) VALUES ('Nemico','Undead Hollow');
INSERT INTO statistiche_combattimento_base_equipaggiati(statistiche_combattimento_base_id,equipaggiati_id) VALUES (1,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (11,1,2);
INSERT INTO descrittore_equipment(dtype,name,upgrades_max) VALUES ('Arma','Spada Nemico 2',0);
INSERT INTO descrittore_equipment_difese(descrittore_equipment_name,difese_id) VALUES ('Spada Nemico 2',11);
INSERT INTO descrittore_equipment_attacchi(arma_name,attacchi_id) VALUES ('Spada Nemico 2',12);
INSERT INTO descrittore_personaggio_base(dtype,name,hp,velocita) VALUES ('Nemico','Soldier',6,2);
INSERT INTO statistiche_combattimento_base(dtype,descrittore_personaggio_base_name) VALUES ('Nemico','Soldier');
INSERT INTO statistiche_combattimento_base_equipaggiati(statistiche_combattimento_base_id,equipaggiati_id) VALUES (2,2);
INSERT INTO nemico_wrapper(number_nemici,statistiche_combattimento_nemico_id) VALUES (1,1);
INSERT INTO nemico_wrapper(number_nemici,statistiche_combattimento_nemico_id) VALUES (2,2);

--ADD ENEMY TO ENCOUNTER ID:1
INSERT INTO descrittore_incontro_nemici_wrappers(descrittore_incontro_id,nemici_wrappers_id)VALUES(1,1);
INSERT INTO descrittore_incontro_nemici_wrappers(descrittore_incontro_id,nemici_wrappers_id)VALUES(1,2);