--------------------------------------------------------
--  Fichier créé - mardi-mai-06-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure ADDAPPROVISIONNEMENT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDAPPROVISIONNEMENT" (p_IdProduit IN NUMBER, p_DateCommande IN VARCHAR, p_Qte IN NUMBER, p_Reception IN NUMBER) 
IS 
	v_IdApprovisionnement Approvisionnement.IdApprovisionnement%TYPE;
  v_DateCommande Commande.DateCommande%TYPE;
BEGIN
  v_DateCommande := TO_TIMESTAMP(p_DateCommande, 'YYYY//MM/DD HH:MI:SS');
	SELECT seq_Approvisionnement.Nextval INTO v_IdApprovisionnement FROM DUAL;
	INSERT INTO Approvisionnement 
	VALUES (v_IdApprovisionnement, p_IdProduit, p_DateCommande, p_Qte, p_Reception);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDCATALOGUE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDCATALOGUE" (p_idCatalogue IN NUMBER,p_IdProduit IN NUMBER, p_IdTVA IN NUMBER, p_IdPrix IN NUMBER, p_Nom IN VARCHAR, p_DateDebut IN VARCHAR, p_DateFin IN VARCHAR) 
IS 
	v_IdCatalogue Catalogue.IdCatalogue%TYPE;
BEGIN
  v_idCatalogue := p_idcatalogue;
  IF(p_idCatalogue = 0 ) THEN -- test d'egalite a 0
    SELECT seq_Catalogue.Nextval INTO v_IdCatalogue FROM DUAL;
  END IF;
	
	INSERT INTO Catalogue
	VALUES (v_IdCatalogue, p_IdProduit, p_IdTVA, p_IdPrix, p_Nom, TO_TIMESTAMP(p_DateDebut, 'YYYY//MM/DD HH:MI:SS'), TO_TIMESTAMP(p_DateFin, 'YYYY//MM/DD HH:MI:SS')) ;
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDCATEGORIE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDCATEGORIE" (p_NomCategorie IN VARCHAR) 
IS 
	v_IdCategorie Categorie.IdCat%TYPE;
BEGIN
	SELECT seq_Categorie.Nextval INTO v_IdCategorie FROM DUAL;
	INSERT INTO Categorie
	VALUES (v_IdCategorie, p_NomCategorie);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDCLIENT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDCLIENT" (p_Prenom IN VARCHAR, p_Nom IN VARCHAR, p_Email IN VARCHAR) 
IS 
	v_IdClient Client.IdClient%TYPE;
BEGIN
	SELECT seq_Client.Nextval INTO v_IdClient FROM DUAL;
	INSERT INTO Client 
  VALUES (v_IdClient, p_Prenom, p_Nom, p_Email) ;
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDCOMMANDE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDCOMMANDE" (p_idCmd IN NUMBER,p_IdClient IN NUMBER, p_IdProduit IN NUMBER, p_DateCommande IN VARCHAR, p_Qte Number) 
IS 
	v_IdCommande Commande.IdCommande%TYPE;
  v_DateCommande Commande.DateCommande%TYPE;
BEGIN
  v_idCommande := p_idCmd;
  v_DateCommande := TO_TIMESTAMP(p_DateCommande, 'YYYY//MM/DD HH:MI:SS');
  IF(p_idcmd = 0) THEN -- si l'id commande est égal à 0 on crée une nouvelle commande
    SELECT seq_Commande.Nextval INTO v_IdCommande FROM DUAL;
  END IF;
	INSERT INTO Commande
	VALUES (v_IdCommande, p_IdClient, p_IdProduit, v_DateCommande, p_Qte);
	
	-- On retire la Qte commandée de la Qte Stock du produit --
	UPDATE Produit 
	Set produit.qtestock = QteStock - p_Qte
	Where idproduit = p_IdProduit;
	
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDFOURNISSEUR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDFOURNISSEUR" (p_Nom IN VARCHAR, p_Email IN VARCHAR) 
IS 
	v_IdFournisseur Fournisseur.IdFournisseur%TYPE;
BEGIN
	SELECT seq_Fournisseur.Nextval INTO v_IdFournisseur FROM DUAL;
	INSERT INTO Fournisseur 
	VALUES (v_IdFournisseur, p_Nom, p_Email);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDHISTORIQUESTATUTCMD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDHISTORIQUESTATUTCMD" (p_IdStatut IN NUMBER, p_IdCommande IN NUMBER, p_DateStatut IN VARCHAR) 
IS 
	v_IdHistoriqueStatutCmd HistoriqueStatutCmd.IdHistoStatutCmd%TYPE;
BEGIN
	SELECT seq_HistoriqueStatutCmd.Nextval INTO v_IdHistoriqueStatutCmd FROM DUAL;
	INSERT INTO HistoriqueStatutCmd 
	VALUES (v_IdHistoriqueStatutCmd, p_IdStatut, p_IdCommande, TO_TIMESTAMP(p_DateStatut, 'YYYY//MM/DD HH:MI:SS'));
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDPRIX
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDPRIX" (p_Prix IN NUMBER) 
IS 
	v_IdPrix Prix.IdPrix%TYPE;
BEGIN
	SELECT seq_Prix.Nextval INTO v_IdPrix FROM DUAL;
	INSERT INTO Prix
	VALUES (v_IdPrix, p_Prix);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDPRODUIT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDPRODUIT" (p_IdFournisseur IN NUMBER, p_IdTVA IN NUMBER, p_IdSousCategorie IN NUMBER, p_Nom IN VARCHAR, p_Description IN VARCHAR, p_QteStock IN NUMBER ) 
IS 
	v_IdProduit Produit.IdProduit%TYPE;
BEGIN
	SELECT seq_Produit.Nextval INTO v_IdProduit FROM DUAL;
	INSERT INTO Produit
	VALUES (v_IdProduit, p_IdFournisseur, p_IdTVA, p_IdSousCategorie, p_Nom, p_Description, p_QteStock);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDSOUSCATEGORIE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDSOUSCATEGORIE" (p_IdCategorie IN NUMBER, p_NomSousCategorie IN VARCHAR) 
IS 
	v_IdSousCategorie SousCategorie.IdSousCat%TYPE;
BEGIN
	SELECT seq_SousCategorie.Nextval INTO v_IdSousCategorie FROM DUAL;
	INSERT INTO SousCategorie
	VALUES (v_IdSousCategorie, p_IdCategorie, p_NomSousCategorie);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDSTATUTCMD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDSTATUTCMD" (p_Nom IN VARCHAR) 
IS 
	v_IdStatutCmd StatutCmd.IdStatutCmd%TYPE;
BEGIN
	SELECT seq_StatutCmd.Nextval INTO v_IdStatutCmd FROM DUAL;
	INSERT INTO StatutCmd 
	VALUES(v_IdStatutCmd, p_Nom);
END;

/
--------------------------------------------------------
--  DDL for Procedure ADDTVA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."ADDTVA" (p_Nom IN VARCHAR, p_Taux IN VARCHAR) 
IS 
	v_IdTVA TVA.IdTVA%TYPE;
BEGIN
	SELECT seq_TVA.Nextval INTO v_IdTVA FROM DUAL;
	INSERT INTO TVA 
	VALUES (v_IdTVA, p_Nom, p_Taux);
END;

/
--------------------------------------------------------
--  DDL for Procedure CLIENTFIDELENBCOMMANDES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."CLIENTFIDELENBCOMMANDES" 
IS
  v_count NUMBER;
  v_idclient Client.idClient%type;
BEGIN
		SELECT idClient , COUNT(*) as nbCmd INTO v_idClient, v_count
    FROM commande
    GROUP BY idClient ORDER BY nbCmd DESC ;

END;

/
--------------------------------------------------------
--  DDL for Procedure CLIENTFIDELENBPRODUITS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."CLIENTFIDELENBPRODUITS" 
IS
  v_idclient Client.idClient%type;
  v_count NUMBER;
BEGIN
	SELECT idClient, SUM(Qte) AS QTE INTO v_idclient, v_count
                     FROM commande
                     GROUP BY idClient ORDER BY qte DESC;
END;

/
--------------------------------------------------------
--  DDL for Procedure EDITPRODUIT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "BOCOMMERCE"."EDITPRODUIT" (p_IdProduit in NUMBER, p_IdFournisseur IN NUMBER, p_IdTVA IN NUMBER, p_IdSousCategorie IN NUMBER, p_Nom IN VARCHAR, p_Description IN VARCHAR, p_QteStock IN NUMBER ) 
IS 
BEGIN
	UPDATE Produit 
	Set IdFournisseur = p_IdFournisseur,
	IdTVA = p_IdTVA,
	IdSousCategorie = p_IdSousCategorie,
	Nom = p_Nom, 
	Description = p_Description,
	QteStock = p_QteStock
	Where Produit.IdProduit = p_IdProduit;
END;

/
