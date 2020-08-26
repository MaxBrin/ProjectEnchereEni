USE PROJET_ENCHERE

ALTER TABLE ENCHERES DROP CONSTRAINT encheres_utilisateur_fk;
ALTER TABLE ENCHERES DROP CONSTRAINT encheres_no_article_fk;

ALTER TABLE RETRAITS DROP CONSTRAINT retrait_article_fk;

ALTER TABLE ARTICLES_VENDUS DROP CONSTRAINT articles_vendus_categories_fk;
ALTER TABLE ARTICLES_VENDUS DROP CONSTRAINT ventes_utilisateur_fk;

DROP TABLE CATEGORIES,UTILISATEURS,ARTICLES_VENDUS,RETRAITS,ENCHERES;

CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)

  

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(50) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(50) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)

ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)


CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATETIME NOT NULL,
    date_fin_encheres             DATETIME NOT NULL,
    prix_initial                  INTEGER NOT NULL,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL
)



ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)


CREATE TABLE RETRAITS (
	no_article       INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL
)

ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_article)
ALTER TABLE RETRAITS
    ADD CONSTRAINT retrait_article_fk FOREIGN KEY ( no_article ) REFERENCES  ARTICLES_VENDUS (no_article)
ON DELETE NO ACTION 
    ON UPDATE no action 


CREATE TABLE ENCHERES(	
	no_enchere  INTEGER IDENTITY(1,1) NOT NULL,
	date_enchere datetime NOT NULL,
	montant_enchere INTEGER NOT NULL,
	no_article INTEGER NOT NULL,
	no_utilisateur INTEGER NOT NULL
 )

ALTER TABLE ENCHERES ADD constraint enchere_pk PRIMARY KEY ( no_enchere)
 
ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_no_article_fk FOREIGN KEY ( no_article ) REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 
	

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

INSERT INTO UTILISATEURS VALUES ('CocoCaliendo44','Caliendo','Julien','jcaliendo@campus-eni.fr','0123456789','1 boulevard TeslaLover','44000','NANTES','Pa$$w0rd',0,1);
INSERT INTO UTILISATEURS VALUES ('Max','Brin','Maxime','maxime.brin2020@campus-eni.fr','0123456789','10 rue du calvaire','85530','LA BRUFFIERE','Pa$$w0rd',100,0);

INSERT INTO CATEGORIES VALUES ('Informatique');
INSERT INTO CATEGORIES VALUES('Ameublement');
INSERT INTO CATEGORIES VALUES('Vetements');
INSERT INTO CATEGORIES VALUES ('Sport & Loisirs');

INSERT INTO ARTICLES_VENDUS VALUES('PC Gamer','Super Pc qui défonce','20200618 10:34:09 AM','20200820 10:34:09 AM',200,null,2,1)
INSERT INTO ARTICLES_VENDUS VALUES('PC Gamer','Super Pc qui défonce','20200617 8:34:09 AM','20201201 9:10:09 AM',200,null,2,1)
INSERT INTO ARTICLES_VENDUS VALUES('PC Gamer','Super Pc qui défonce','20200618 10:25:09 AM','20200718 5:08:09 pM',200,null,1,1)

INSERT INTO RETRAITS VALUES (3,'1 boulevard TeslaLover','44000','NANTES');
INSERT INTO RETRAITS VALUES (1,'10 rue du calvaire','85530','LA BRUFFIERE');
INSERT INTO RETRAITS VALUES (2,'10 rue du calvaire','85530','LA BRUFFIERE');

SELECT * FROM CATEGORIES WHERE libelle like '%Sport%'
SELECT * FROM CATEGORIES WHERE libelle like '%Informatique%'  or libelle like '%Sport%';