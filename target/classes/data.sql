INSERT INTO modalita(name) values ('storia');
INSERT INTO descrittore_dungeon(boss_name) values ('prova');
INSERT INTO descrittore_incontro values (1);
INSERT INTO descrittore_incontro values (2);
INSERT INTO descrittore_incontro values (3);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova',1);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova',2);
INSERT INTO descrittore_dungeon_lista_incontri(descrittore_dungeon_boss_name,lista_incontri_id_descrittore_incontro) values ('prova',3);
INSERT INTO modalita_lista_dungeons(modalita_name,lista_dungeons_boss_name) values ('storia','prova');