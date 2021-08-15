truncate table vets cascade;
insert into vets values (1, 'james', 'carter');
insert into vets values (2, 'helen', 'leary');
insert into vets values (3, 'linda', 'douglas');
insert into vets values (4, 'rafael', 'ortega');
insert into vets values (5, 'henry', 'stevens');
insert into vets values (6, 'sharon', 'jenkins');
select setval('vets_id_seq', (select max(id) from vets));

truncate table specialties cascade;
insert into specialties values (1, 'radiology');
insert into specialties values (2, 'surgery');
insert into specialties values (3, 'dentistry');
select setval('specialties_id_seq', (select max(id) from specialties));

truncate table vet_specialties cascade;
insert into vet_specialties values (2, 1);
insert into vet_specialties values (3, 2);
insert into vet_specialties values (3, 3);
insert into vet_specialties values (4, 2);
insert into vet_specialties values (5, 1);

truncate table types cascade;
insert into types values (1, 'cat');
insert into types values (2, 'dog');
insert into types values (3, 'lizard');
insert into types values (4, 'snake');
insert into types values (5, 'bird');
insert into types values (6, 'hamster');
select setval('types_id_seq', (select max(id) from types));

truncate table owners cascade;
insert into owners values (1, 'george', 'franklin', '110 w. liberty st.', 'madison', '6085551023');
insert into owners values (2, 'betty', 'davis', '638 cardinal ave.', 'sun prairie', '6085551749');
insert into owners values (3, 'eduardo', 'rodriquez', '2693 commerce st.', 'mcfarland', '6085558763');
insert into owners values (4, 'harold', 'davis', '563 friendly st.', 'windsor', '6085553198');
insert into owners values (5, 'peter', 'mctavish', '2387 s. fair way', 'madison', '6085552765');
insert into owners values (6, 'jean', 'coleman', '105 n. lake st.', 'monona', '6085552654');
insert into owners values (7, 'jeff', 'black', '1450 oak blvd.', 'monona', '6085555387');
insert into owners values (8, 'maria', 'escobito', '345 maple st.', 'madison', '6085557683');
insert into owners values (9, 'david', 'schroeder', '2749 blackhawk trail', 'madison', '6085559435');
insert into owners values (10, 'carlos', 'estaban', '2335 independence la.', 'waunakee', '6085555487');
select setval('owners_id_seq', (select max(id) from owners));

truncate table pets cascade;
insert into pets values (1, 'leo', '2010-09-07', 1, 1);
insert into pets values (2, 'basil', '2012-08-06', 6, 2);
insert into pets values (3, 'rosy', '2011-04-17', 2, 3);
insert into pets values (4, 'jewel', '2010-03-07', 2, 3);
insert into pets values (5, 'iggy', '2010-11-30', 3, 4);
insert into pets values (6, 'george', '2010-01-20', 4, 5);
insert into pets values (7, 'samantha', '2012-09-04', 1, 6);
insert into pets values (8, 'max', '2012-09-04', 1, 6);
insert into pets values (9, 'lucky', '2011-08-06', 5, 7);
insert into pets values (10, 'mulligan', '2007-02-24', 2, 8);
insert into pets values (11, 'freddy', '2010-03-09', 5, 9);
insert into pets values (12, 'lucky', '2010-06-24', 2, 10);
insert into pets values (13, 'sly', '2012-06-08', 1, 10);
select setval('pets_id_seq', (select max(id) from pets));

truncate table visits cascade;
insert into visits values (1, 7, '2013-01-01', 'rabies shot');
insert into visits values (2, 8, '2013-01-02', 'rabies shot');
insert into visits values (3, 8, '2013-01-03', 'neutered');
insert into visits values (4, 7, '2013-01-04', 'spayed');
select setval('visits_id_seq', (select max(id) from visits));
