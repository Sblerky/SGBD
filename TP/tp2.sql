--Script PL/SQL qui permet de chronométrer au millionième de seconde
CREATE OR REPLACE PROCEDURE CHRONO IS
	hd timestamp;
	hf timestamp;
	duree interval day to second;
	nbEtu integer;
BEGIN
	hd := systimestamp;
	select count(*) into nbEtu from ETUDIANT_IP where villeEtu ='Dijon';
	hf:=systimestamp;
	duree:=hf-hd;
	dbms_output.put_line('Commentaire : ' || extract(minute from duree) || ' minutes ' || extract (second from duree) || ' secondes ');
end;
.
/

CREATE TABLE ETUDIANT_IP (
    noEtu CONSTRAINt pk_EI PRIMARY KEY,
	nomEtu,
	villeEtu,
	genre ,
	statutM ,
	description
) ORGANIZATION INDEX AS SELECT * FROM ETUDIANT;

CREATE TABLE ETUDIANT_SEQ (
    noEtu CONSTRAINt pk_Eseq PRIMARY KEY,
	nomEtu,
	villeEtu,
	genre,
	statutM ,
	description
)AS SELECT * FROM ETUDIANT ORDER BY DBMS_RANDOM.VALUE;

--Hashkeys = nombre d'étudiants/nb étudiant dans 1 bloc
--nb étudiant dans 1 bloc = taille d'1 bloc / taille d'1 étudiant

CREATE CLUSTER CLU_ETU(VILLE VARCHAR(50))
HASHKEYS 10;

CREATE TABLE ETUDIANT_CLU CLUSTER CLU_ETU(villeEtu) AS SELECT * FROM ETUDIANT ;
