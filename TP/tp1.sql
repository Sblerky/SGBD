CREATE TABLE ETUDIANT(
noEtu NUMBER(6,0) CONSTRAINt pk_E PRIMARY KEY,
nomEtu VARCHAR2(50) NOT NULL,
villeEtu VARCHAR2(50) NOT NULL,
genre CHAR(1),
statutM CHAR(1),
description VARCHAR(2000)
);

INSERT INTO ETUDIANT VALUES(10001,'Péqueneau','Mirande', 'H', 'C', 'Je suis un péqueneau');

CREATE TABLE INTERVAL(nomVille VARCHAR(50) CONSTRAINt pk_I PRIMARY KEY,valeurB NUMBER(2,0),valeurH NUMBER(3,0));

INSERT INTO INTERVAL VALUES('Paris',0,22);
INSERT INTO INTERVAL VALUES('Chalon',23,34);
INSERT INTO INTERVAL VALUES('Lyon',35,54);
INSERT INTO INTERVAL VALUES('Longvic',55,64);
INSERT INTO INTERVAL VALUES('Dijon',65,80);
INSERT INTO INTERVAL VALUES('Quetigny',81,88);
INSERT INTO INTERVAL VALUES('Chenove',89,94);
INSERT INTO INTERVAL VALUES('Chevigny',95,98);
INSERT INTO INTERVAL VALUES('Bressey',99,100);

CREATE TABLE STINTER(statut VARCHAR(50) CONSTRAINt pk_SI PRIMARY KEY,valeurB NUMBER(2,0),valeurH NUMBER(3,0));

INSERT INTO STINTER VALUES('C',0,80);
INSERT INTO STINTER VALUES('P',81,86);
INSERT INTO STINTER VALUES('D',87,89);
INSERT INTO STINTER VALUES('V',90,90);
INSERT INTO STINTER VALUES('M',91,100);

CREATE TABLE STGENRE(genre VARCHAR(50) CONSTRAINt pk_SG PRIMARY KEY,valeurB NUMBER(2,0),valeurH NUMBER(3,0));

INSERT INTO STGENRE VALUES('H',0,49);
INSERT INTO STGENRE VALUES('F',50,100);

DECLARE
	randVille integer;
	Ville varchar(50);
	randStatut integer;
	Statut char(1);
	randGenre integer;
	Genre char(1);
	noEtu integer;
	nomRand varchar(50);
BEGIN
	for noEtu in 0..10000
	loop
		randVille:=dbms_random.value(0,100);
		randStatut:=dbms_random.value(0,100);
		randGenre:=dbms_random.value(0,100);
		Select nomVille into Ville From INTERVAL where randVille>=valeurB AND randVille<=valeurH;
		Select statut into Statut From STINTER where randStatut>=valeurB AND randStatut<=valeurH;
		Select genre into Genre From STGENRE where randGenre>=valeurB AND randGenre<=valeurH;
		INSERT INTO ETUDIANT VALUES(
		noEtu,
		DBMS_RANDOM.string('L',TRUNC(DBMS_RANDOM.value(10,21))),
		Ville,
		Genre,
		Statut,
		'');
	end loop;
END;
/


SELECT villeEtu, COUNT(villeEtu)/(SELECT count(*)/100 from Etudiant) FROM ETUDIANT GROUP BY villeEtu;
SELECT genre, COUNT(genre)/(SELECT count(*)/100 from Etudiant) FROM ETUDIANT GROUP BY genre;
SELECT statutM, COUNT(statutM)/(SELECT count(*)/100 from Etudiant) FROM ETUDIANT GROUP BY statutM;

CREATE INDEX index_ville ON ETUDIANT (villeEtu);

Select Count(*) from ETUDIANT where villeEtu='Mirande';

exec DBMS_STATS.GATHER_SCHEMA_STATS('mp861554', cascade=>true);
ALTER SYSTEM FLUSH BUFFER_CACHE;
ALTER SYSTEM FLUSH SHARED_POOL;

select count(*) from ETUDIANT where villeEtu='Dijon';
