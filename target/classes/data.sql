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
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',1);
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (1,1,0);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (2,2,2);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (1,1,1,1); --E' il primo oggetto creato quindi il suo ID = 1
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name,weight) VALUES ('Arma',1,1, 'Spada leggera',1);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (1,1);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (1,2);--Tabella di JOIN
--EQUIPMENT2
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (3,2,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name) VALUES ('Armatura',2,2,'Armatura leggera');
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (2,3); --Tabella di JOIN
--EQUIPMENT3
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (4,2,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name) VALUES ('Armatura',3,2,'Armatura pesante');
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (3,4); --Tabella di JOIN
--EQUIPMENT4
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (5,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (6,2,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name,weight) VALUES ('Arma',4,2, 'Ascia',1);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (4,5); --Tabella di JOIN
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (4,6); --Tabella di JOIN
--EQUIPMENT5
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',2);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (7,2,1);
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (8,2,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name,weight) VALUES ('Arma',5,2,'Spadone Imperiale',2);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (5,7); --Tabella di JOIN
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (5,8); --Tabella di JOIN
--EQUIPMENT6
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',1);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (9,1,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (0,0,0,0);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name,weight) VALUES ('Arma',6,0,'Mano Sinistra',0);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (6,9); --Tabella di JOIN


--EQUIPMENT7
INSERT INTO azione(dtype,stamina_cost) VALUES ('Attacco',1);
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (10,1,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (0,0,0,0);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left, name,weight) VALUES ('Arma',7,0,'Mano Sinistra',0);
INSERT INTO equipment_attacchi(arma_id,attacchi_id) VALUES (7,10); --Tabella di JOIN


--EQUIPMENT8
INSERT INTO azione(dtype) VALUES ('Difesa');
INSERT INTO dice_combination(azione_id,combination,dice_color) VALUES (11,1,1);
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (0,0,0,0);
INSERT INTO equipment(dtype,min_requirements_id,upgrades_left,name,weight) VALUES ('Armatura',8,0,'Corpo Libero',0);
INSERT INTO equipment_difese(equipment_id,difese_id) VALUES (8,11); --Tabella di JOIN


--TITANITE
INSERT INTO titanite(equipment_type,available,looted,dice_color) VALUES (0,4,4,0);
INSERT INTO titanite(equipment_type,available,looted,dice_color) VALUES (0,4,4,1);
INSERT INTO titanite(equipment_type,available,looted,dice_color) VALUES (1,3,3,1);

--CREATE SOME PERSONAGGIO AND ADD SOME ARTIFACTS
INSERT INTO statistica_base(forza,destrezza,intelligenza,fede) VALUES (2,2,2,2);
INSERT INTO personaggio(statistica_base_id) VALUES (6);
INSERT INTO personaggio_zaino_equip(zaino_equip_id,personaggio_id) VALUES (1,1);
INSERT INTO personaggio_zaino_equip(zaino_equip_id,personaggio_id) VALUES (2,1);
INSERT INTO personaggio_zaino_equip(zaino_equip_id,personaggio_id) VALUES (3,1);
INSERT INTO personaggio_zaino_equip(zaino_equip_id,personaggio_id) VALUES (4,1);
INSERT INTO personaggio_zaino_equip(zaino_equip_id,personaggio_id) VALUES (5,1);
INSERT INTO personaggio_current_equipped(personaggio_id,current_equipped_id,body_personaggio) VALUES (1,7,0);
INSERT INTO personaggio_current_equipped(personaggio_id,current_equipped_id,body_personaggio) VALUES (1,6,1);
INSERT INTO personaggio_current_equipped(personaggio_id,current_equipped_id,body_personaggio) VALUES (1,8,2);
INSERT INTO personaggio_titaniti(titaniti_id,personaggio_id) VALUES (1,1);
INSERT INTO personaggio_titaniti(titaniti_id,personaggio_id) VALUES (2,1);
INSERT INTO personaggio_titaniti(titaniti_id,personaggio_id) VALUES (3,1);
