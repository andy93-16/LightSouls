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
INSERT INTO attacco(diceColor, noDice, tipo, stamina_cost) values (BLACK, 2, "Fisico", 2);
--INSERT INTO equipment(upgrades_left,statistica_base)