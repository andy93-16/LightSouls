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
INSERT INTO azione(dtype,stamina_cost,difficolta_schivata) VALUES ('Attacco',1,0);
INSERT INTO azione(dtype,stamina_cost,difficolta_schivata) VALUES ('Attacco',2,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,1,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,2,1);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (2,2,2);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,1);
INSERT INTO equipment(dtype,upgrades,name,body_part_requirement_id,
forza,destrezza,intelligenza,fede) VALUES ('Arma',1,'Spada leggera',1,1,1,1,1);
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (1,0);
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (1,1);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (1,1);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (1,2);--Tabella di JOIN
--EQUIPMENT2
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (3,2,1);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO equipment(dtype,upgrades,name,body_part_requirement_id,
forza,destrezza,intelligenza,fede) VALUES ('Armatura',2,'Armatura leggera',2,2,2,2,2);
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (2,3); --Tabella di JOIN
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (2,0);
--EQUIPMENT3
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (4,2,1);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO equipment(dtype,upgrades,name,body_part_requirement_id,
forza,destrezza,intelligenza,fede) VALUES ('Armatura',3,'Armatura pesante',3,2,2,2,2);
INSERT INTO equipment_difese(difese_id,equipment_id) VALUES (4,3);
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (3,1);
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (3,2);
--EQUIPMENT4
INSERT INTO azione(dtype,stamina_cost,difficolta_schivata) VALUES ('Attacco',2,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (5,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (6,2,1);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,1);
INSERT INTO equipment(dtype,upgrades,name,body_part_requirement_id,
forza,destrezza,intelligenza,fede) VALUES ('Arma',4, 'Ascia',4,2,2,2,2);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (4,5); --Tabella di JOIN
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (4,6); --Tabella di JOIN
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (4,0);
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (4,1);
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (4,2);
--EQUIPMENT5
INSERT INTO azione(dtype,stamina_cost,difficolta_schivata) VALUES ('Attacco',2,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (7,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (8,2,1);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (0,2);
INSERT INTO equipment(dtype,upgrades,name,body_part_requirement_id,
forza,destrezza,intelligenza,fede) VALUES ('Arma',2,'Spadone Imperiale',5,2,2,2,2);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (5,7); --Tabella di JOIN
INSERT INTO equipment_difese(difese_id,equipment_id) VALUES (8,5); --Tabella di JOIN
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (5,0);
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
INSERT INTO personaggio_base(dtype,classe,hp_base,velocita_base,stamina_base,stamina_regen,name,anime,forza,destrezza,intelligenza,fede)
VALUES ('Personaggio',0,10,7,10,2,'Guerriero',10,2,2,2,2);
/*INSERT INTO personaggio_base_body_parts(personaggio_name,body_parts_name) VALUES ('Guerriero','Mano Sinistra');
*/INSERT INTO personaggio_base_body_parts(personaggio_name,body_parts_name) VALUES ('Guerriero','Mano Destra');
INSERT INTO personaggio_base_body_parts(personaggio_name,body_parts_name) VALUES ('Guerriero','Corpo');
INSERT INTO personaggio_base_zaino_equip(personaggio_name,zaino_equip_id) VALUES ('Guerriero',2);
INSERT INTO personaggio_base_zaino_equip(zaino_equip_id,personaggio_name) VALUES (3,'Guerriero');
INSERT INTO personaggio_base_zaino_equip(zaino_equip_id,personaggio_name) VALUES (4,'Guerriero');
INSERT INTO personaggio_base_zaino_equip(zaino_equip_id,personaggio_name) VALUES (5,'Guerriero');
INSERT INTO personaggio_base_titaniti(titaniti_id,personaggio_name) VALUES (1,'Guerriero');
INSERT INTO personaggio_base_titaniti(titaniti_id,personaggio_name) VALUES (2,'Guerriero');
INSERT INTO personaggio_base_titaniti(titaniti_id,personaggio_name) VALUES (3,'Guerriero');
INSERT INTO stato_personaggio_base(dtype,personaggio_base_name) VALUES ('StatoPersonaggio','Guerriero');
INSERT INTO equipment_equipped_body_parts(equipment_id,equipped_body_parts_name) VALUES (1,'Mano Sinistra');
INSERT INTO stato_personaggio_base_equipaggiati(stato_personaggio_base_id,equipaggiati_id) VALUES (1,1);


--CREATE SOME NEMICO AND ADD TO ENCOUNTERS

INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO azione(dtype,stamina_cost,difficolta_schivata) VALUES ('Attacco',0,2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (10,2,1);
INSERT INTO equipment(dtype,name,upgrades) VALUES ('Arma','Spada Nemico 1',0);
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (6,9);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (6,10);
INSERT INTO personaggio_base(dtype,name,hp_base,velocita_base) VALUES ('Nemico','Undead Hollow',8,5);
INSERT INTO stato_personaggio_base(dtype,personaggio_base_name) VALUES ('StatoNemico','Undead Hollow');
INSERT INTO stato_personaggio_base_equipaggiati(stato_personaggio_base_id,equipaggiati_id) VALUES (2,6);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO azione(dtype,stamina_cost,difficolta_schivata) VALUES ('Attacco',0,1);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (12,2,1);
INSERT INTO equipment(dtype,name,upgrades) VALUES ('Arma','Spada Nemico 2',0);
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (7,11);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (7,12);
INSERT INTO personaggio_base(dtype,name,hp_base,velocita_base) VALUES ('Nemico','Soldier',6,2);
INSERT INTO stato_personaggio_base(dtype,personaggio_base_name) VALUES ('StatoNemico','Soldier');
INSERT INTO stato_personaggio_base_equipaggiati(stato_personaggio_base_id,equipaggiati_id) VALUES (3,7);
INSERT INTO nemico_wrapper(number_nemici,stato_nemico_id) VALUES (1,2);
INSERT INTO nemico_wrapper(number_nemici,stato_nemico_id) VALUES (1,3);

--ADD ENEMY TO ENCOUNTER ID:1
INSERT INTO descrittore_incontro_nemici_wrappers(descrittore_incontro_id,nemici_wrappers_id)VALUES(1,1);
INSERT INTO descrittore_incontro_nemici_wrappers(descrittore_incontro_id,nemici_wrappers_id)VALUES(1,2);

--EQUIPMENT6
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (13,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (14,2,1);
INSERT INTO body_part_requirement(body_part_type,number_body_part) VALUES (1,1);
INSERT INTO equipment(dtype,upgrades,name,body_part_requirement_id,
forza,destrezza,intelligenza,fede) VALUES ('Arma',4, 'Shotel',6,2,2,2,2);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (8,13); --Tabella di JOIN
INSERT INTO equipment_difese(difese_id,equipment_id) VALUES (14,8); --Tabella di JOIN
INSERT INTO equipment_classi_compatibili(equipment_id, classi_compatibili) VALUES (8,0);
INSERT INTO personaggio_base_lootable (personaggio_name, lootable_id) VALUES ('Guerriero', 8);