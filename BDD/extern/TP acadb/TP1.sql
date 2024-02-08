 --supprimer la table employes
 DROP table Employes;
 --Creation de la table employes 
 CREATE TABLE  Employes 
 (
    NumEmploye   NUMBER(10)    PRIMARY KEY, 
    Nom          VARCHAR(10)   NOT NULL, 
    Salaire      NUMBER(10,2), 
    Fonction     VARCHAR(10), 
    Date_Recrutement date,
    Date_promotion date	
    Code_Service NUMBER (10), 
    Code_Departement NUMBER (10) 
); 
-- Modification du schema de la bd( par modifier la table employes )
   --1° Ajouter la colonne nommée SEXE
ALTER TABLE Employes ADD (  SEXE  varchar (4) );
   --2° Supprimer la colonne nommée SEXE
ALTER TABLE Employes DROP COLUMN SEXE;
   -- 3° changer le type de la colonne NumEmploye
ALTER TABLE Employes MODIFY ( NumEmploye NUMBER(25)  );
   --4° Ajouter la containte not null a l'attribut salaire ==> le salaire ne peux pas être vide 
ALTER TABLE Employes 
ADD CONSTRAINT C1 CHECK ( Salaire is not null);
   --5° Ajouter la contarinte qui permet de verifier que la date du recrutement doit etre avant de la date de promotion d'un employe
ALTER TABLE Employes 
ADD CONSTRAINT C2 CHECK
 ( Date_Recrutement< Date_promotion);

-- creation de la table CLIENT
--Methode 1:
CREATE TABLE CLIENT 
(
    CodeC               varchar (12)  PRIMARY KEY, 
    Nom                 varchar (12), 
    Prenom              varchar (12), 
    Email               varchar (12), 
    psw                 varchar (12), 
    date_enregistrement    DATE  , 
    date_dernier_acces     DATE, 
    ville               varchar (12), 
    pays                varchar (12), 
    code_postal         varchar (12), 
    telephone           varchar (12), 
    age                  varchar (12)
); 
--Methode 2:
CREATE TABLE CLIENT1 
(
  CodeC         varchar (12), 
  Nom           varchar (12), 
  Prenom        varchar (12), 
  Email         varchar (12), 
  psw           varchar (12), 
  date_enregistrement    DATE  , 
  date_dernier_acces     DATE, 
  ville         varchar (12), 
  pays          varchar (12), 
  code_postal   varchar (12), 
  telephone     varchar (12), 
  age          varchar (12),
  CONSTRAINT C5 PRIMARY KEY (CodeC) 
);
--Methode 3:
CREATE TABLE CLIENT2 (
CodeC         varchar (12), 
Nom           varchar (12), 
Prenom        varchar (12), 
Email         varchar (12), 
psw           varchar (12), 
date_enregistrement    DATE  , 
date_dernier_acces     DATE, 
ville         varchar (12), 
pays          varchar (12), 
code_postal   varchar (12), 
telephone     varchar (12), 
age          varchar (12)
);

Alter table Client2 add constraint C6 primary key (codec);
--Modification de la table client:

ALTER TABLE CLIENT MODIFY ( age  number(12));
ALTER TABLE CLIENT ADD CONSTRAINT C4 check (Nom is not null);
ALTER TABLE CLIENT ADD CONSTRAINT C2 check (age >=21);
ALTER TABLE CLIENT ADD CONSTRAINT C3 check (date_enregistrement < date_dernier_acces);
alter table CLIENT ADD CONSTRAINT C7 check ( ville in ('BABEZZOUAR', 'ALGER','HARRACH'));

Remarque importante: 
------------------------------------------------------
PRIMARY KEY = UNIQUE + NOT NULL; 
CREATE TABLE test1 ( id      varchar (2) UNIQUE,
                     att1   varchar(2));
					 
					 ID peut etre null mais il est impossible d avoir 2 enregistrement avec le meme ID

CREATE TABLE test3 ( id      varchar (2) PRIMARY KEY,
                     att1   varchar(2));
------------------------------------------------------

CREATE TABLE PRODUIT( 
CodeP , 
NomProd, 
Prix_unitaire, 
date_fabrication);

CREATE TABLE ACHAT
( 
   CodeC  varchar (12), 
   CodeP  varchar (12), 
   date_achat  date , 
   quantite number(12),
   CONSTRAINT C8 PRIMARY KEY (CodeC,CodeP,date_achat));
   
   codeC     codeP    date_achat      quantité 
   10         P1         janvier      12
   12         P1
   10         P1
   
) ;
CREATE TABLE ACHAT
( 
   CodeC  varchar (12), 
   CodeP  varchar (12), 
   date_achat  date , 
   quantite number(12)
) ;
ALTER TABLE ACHAT add CONSTRAINT C8 PRIMARY KEY (CodeC,CodeP,date_achat);


