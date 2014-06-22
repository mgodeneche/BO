/*
	Creation Tables
*/

CREATE TABLE Client ( 
	IdClient NUMBER,
	Prenom VARCHAR(30),
	Nom VARCHAR(30),
	Email VARCHAR(100),
	CONSTRAINT pk_IdClient PRIMARY KEY (IdClient)
	);
	
CREATE TABLE Categorie ( 
	IdCat NUMBER,
	Nom VARCHAR(30),
	CONSTRAINT pk_IdCategorie PRIMARY KEY (IdCat)
	);
	
CREATE TABLE SousCategorie ( 
	IdSousCat NUMBER,
	IdCat NUMBER,
	Nom VARCHAR(30),
	CONSTRAINT pk_IdSousCategorie PRIMARY KEY (IdSousCat),
	CONSTRAINT fk_IdCategorie FOREIGN KEY (IdCat) REFERENCES Categorie (IdCat)
	);
	
CREATE TABLE TVA (
	IdTVA NUMBER,
	Nom VARCHAR(30),
	Taux NUMBER,
	CONSTRAINT pk_IdTVA PRIMARY KEY (IdTVA)
	);
	
CREATE TABLE Fournisseur ( 
	IdFournisseur NUMBER,
	Nom VARCHAR(30),
	Email VARCHAR(50),
	CONSTRAINT pk_IdFournisseur PRIMARY KEY (IdFournisseur)
	);
	
CREATE TABLE Produit ( 
	IdProduit NUMBER,
	IdFournisseur NUMBER,
	IdTVA NUMBER,
	IdSousCategorie NUMBER,
	Nom VARCHAR(30),
	Description VARCHAR(150),
	QteStock NUMBER,
	CONSTRAINT pk_IdProduit PRIMARY KEY (IdProduit),
	CONSTRAINT fk_IdFournisseur FOREIGN KEY (IdFournisseur) REFERENCES Fournisseur(IdFournisseur),
	CONSTRAINT fk_IdTVA FOREIGN KEY (IdTVA) REFERENCES TVA (IdTVA),
	CONSTRAINT fk_IdSousCategorie FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCat)
	);
	
CREATE TABLE Commande ( 
	IdCommande NUMBER,
	IdClient NUMBER,
	IdProduit NUMBER,
	DateCommande TIMESTAMP,
	Qte NUMBER,
	CONSTRAINT fk_IdClient FOREIGN KEY (IdClient) REFERENCES Client(IdClient),
	CONSTRAINT fk_IdProduit FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
	);
	
CREATE TABLE StatutCmd (
	IdStatutCmd NUMBER,
	Nom VARCHAR(30),
	CONSTRAINT pk_IdStatutCmd PRIMARY KEY (IdStatutCmd)
	);
	
CREATE TABLE HistoriqueStatutCmd ( 
	IdHistoStatutCmd NUMBER,
	IdStatutCmd NUMBER,
	IdCommande NUMBER,
	DateStatut TIMESTAMP,
	CONSTRAINT pk_IdHistoriqueStatutCmd PRIMARY KEY (IdHistoStatutCmd),
	CONSTRAINT fk_IdStatutCmd FOREIGN KEY (IdStatutCmd) REFERENCES StatutCmd (IdStatutCmd),
	--CONSTRAINT fk_IdCommande FOREIGN KEY (IdCommande) REFERENCES Commande (IdCommande)
	);
	
CREATE TABLE Approvisionnement ( 
	IdApprovisionnement NUMBER,
	IdProduit NUMBER,
	DateCommande TIMESTAMP,
	Qte NUMBER,
	Reception NUMBER,
	CONSTRAINT pk_IdApprovisionnement PRIMARY KEY (IdApprovisionnement),
	CONSTRAINT fk_ApproIdProduit FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
	);
	
CREATE TABLE Prix (
	IdPrix NUMBER,
	Prix NUMBER,
	CONSTRAINT pk_IdPrix PRIMARY KEY (IdPrix)
	);
	
CREATE TABLE Catalogue (
	IdCatalogue NUMBER,
	IdProduit NUMBER,
	IdTVA NUMBER,
	IdPrix NUMBER,
	Nom VARCHAR,
	DateDebut TIMESTAMP,
	DateFin TIMESTAMP,
	CONSTRAINT fk_CatalogueIdProduit FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit),
	CONSTRAINT fk_CatalogueIdTVA FOREIGN KEY (IdTVA) REFERENCES TVA (IdTVA),
	CONSTRAINT fk_CatalogueIdPrix FOREIGN KEY (IdPrix) REFERENCES Prix(IdPrix)
	);