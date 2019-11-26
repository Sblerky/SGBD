CREATE INDEX INDEX_VILLE ON ETUDIANT (villeEtu);
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'INDEX_VILLE';--=32
DROP INDEX INDEX_VILLE;

CREATE BITMAP INDEX BI_VILLE ON ETUDIANT(villeEtu);
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'BI_VILLE'; --=8
DROP INDEX BI_VILLE;



CREATE INDEX INDEX_NOETU ON ETUDIANT (noEtu);
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'INDEX_NOETU'; --=24 (on a utilisé PK_E à la place de INDEX_NOETU)
DROP INDEX INDEX_NOETU;

CREATE BITMAP INDEX BI_NOETU ON ETUDIANT(noEtu);
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'BI_NOETU';
DROP INDEX BI_NOETU;

--Pour le rapport faire sur d'autres attributs

CREATE INDEX INDEX_NOMETU ON ETUDIANT (nomEtu);
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'INDEX_NOMETU'; --=48
DROP INDEX INDEX_NOMETU;

CREATE BITMAP INDEX BI_NOMETU ON ETUDIANT(nomEtu);
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'BI_NOMETU'; --=64
DROP INDEX BI_NOMETU;


CREATE CLUSTER CLU_ETU(VILLE VARCHAR(50))
HASHKEYS 10;
CREATE TABLE ETUDIANT_CLU CLUSTER CLU_ETU(villeEtu) AS SELECT * FROM ETUDIANT ;
SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'CLU_ETU';--=64

SELECT BLOCKS FROM USER_SEGMENTS WHERE SEGMENT_NAME = 'ETUDIANT';--=56


--Question 6
CREATE TABLE ETUDIANT_PCT AS SELECT * FROM ETUDIANT.

SELECT pct_free FROM user_tables WHERE table_name = 'ETUDIANT_PCT'; --10

UPDATE ETUDIANT_PCT set description = 'aaaaaaaaaaaaaaaa';

SELECT pct_free FROM user_tables WHERE table_name = 'ETUDIANT_PCT'; --10

UPDATE ETUDIANT_PCT set description ='aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa';

SELECT pct_free FROM user_tables WHERE table_name = 'ETUDIANT_PCT'; --10 mais censé faire quelque chose sauf qu'on peut pas rajouter plus de a
