--------------------------------------------------------
--  Fichier créé - mardi-mai-06-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Function F_CLIENTSFIDELENBPRODUITS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_CLIENTSFIDELENBPRODUITS" 
RETURN SYS_REFCURSOR
AS
  clientsCursor SYS_REFCURSOR;
  v_idclient Client.idClient%type;
  v_count NUMBER;
BEGIN
  OPEN clientsCursor FOR
    SELECT idClient, SUM(Qte) AS QTE INTO v_idclient, v_count
    FROM commande
    GROUP BY idClient ORDER BY qte DESC;
  RETURN clientsCursor;
  CLOSE clientsCursor;
END;

/
--------------------------------------------------------
--  DDL for Function F_CLIENTSFIDELESNBCOMMANDES
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_CLIENTSFIDELESNBCOMMANDES" 
RETURN SYS_REFCURSOR 
--  produits les plus  commandes
AS
  clientsFideles SYS_REFCURSOR;
  v_count NUMBER;
  v_idclient Client.idClient%type;
BEGIN 
  OPEN clientsFideles FOR
    SELECT idClient, SUM(Qte) AS QTE INTO v_idclient, v_count
    FROM commande
    GROUP BY idClient ORDER BY qte DESC;
 
    RETURN clientsFideles;  
    CLOSE clientsFideles;
END;

/
--------------------------------------------------------
--  DDL for Function F_GETCATALOGUE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_GETCATALOGUE" (p_IdCatalogue IN NUMBER) RETURN SYS_REFCURSOR
IS
  catalogueCursor SYS_REFCURSOR;
BEGIN
  OPEN catalogueCursor FOR
     SELECT Ca.Nom, Ca.DateDebut, Ca.DateFin, P.Nom, P.Description, Prix.Prix, TVA.Taux
     FROM Catalogue Ca
     INNER JOIN Produit P ON P.IdProduit = Ca.IdProduit
     INNER JOIN Prix ON Prix.IdPrix = Ca.IdPrix
     INNER JOIN TVA ON TVA.IdTVA = Ca.idtva
     WHERE Ca.IdCatalogue = p_IdCatalogue;
  RETURN catalogueCursor;
  CLOSE catalogueCursor;
END;

/
--------------------------------------------------------
--  DDL for Function F_GETCOMMANDE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_GETCOMMANDE" (p_IdCommande IN NUMBER) RETURN SYS_REFCURSOR
IS
  cmdCursor SYS_REFCURSOR;
BEGIN
  OPEN cmdCursor FOR
     SELECT C.DateCommande, C.Qte, P.Nom,  P.Description, F_GetPrixProduit(C.DateCommande, C.IdProduit), F_GetTVAProduit(C.DateCommande,C.idProduit, C.IdProduit)
     FROM Commande C
     INNER JOIN Produit P ON P.IdProduit = C.IdProduit
     WHERE C.IdCommande = p_IdCommande;
  RETURN cmdCursor;
  CLOSE cmdCursor;
END;

/
--------------------------------------------------------
--  DDL for Function F_GETNBRECOMMDUMOISANNEE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_GETNBRECOMMDUMOISANNEE" (p_Month IN varchar, p_Year IN varchar) RETURN NUMBER
IS
  v_TotCom Prix.Prix%type; 
  v_date VARCHAR(10);
BEGIN
 v_date := CONCAT(p_Month,'/');
 v_date := CONCAT(v_date,p_year);
 SELECT COUNT(DISTINCT(IdCommande)) INTO v_TotCom 
 FROM Commande
 WHERE TO_CHAR(Commande.DateCommande,'MM/YYYY') = v_date;
 RETURN v_TotCom;
END;

/
--------------------------------------------------------
--  DDL for Function F_GETPRIXPRODUIT
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_GETPRIXPRODUIT" (p_Date IN TIMESTAMP, P_IdProduit IN NUMBER) 
    RETURN Prix.Prix%TYPE 
is
  v_Prix Prix.Prix%TYPE ; 
begin
  -- Reguete récup du prix
    SELECT Prix INTO v_Prix  
    FROM Prix, Catalogue
    WHERE Prix.IdPrix = Catalogue.IdPrix
    AND Catalogue.IdProduit = P_IdProduit
    AND p_Date > Catalogue.DateDebut
    AND p_Date < Catalogue.DateFin;
    RETURN v_Prix; 
end;

/
--------------------------------------------------------
--  DDL for Function F_GETTVAPRODUIT
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_GETTVAPRODUIT" (p_Date IN TIMESTAMP, P_IdProduit IN NUMBER ,P_IdTVA IN NUMBER) 
    RETURN TVA.taux%TYPE 
is
 v_TauxTVA TVA.taux%TYPE; 
begin
  -- Reguete récup du taux
    SELECT Taux INTO v_TauxTVA  
    FROM TVA, Catalogue
    WHERE TVA.IdTVA = Catalogue.IdTVA
    AND Catalogue.IdProduit = P_IdProduit
    AND p_Date > Catalogue.DateDebut
    AND p_Date < Catalogue.DateFin;
    
    RETURN v_TauxTVA; 
end; 

/
--------------------------------------------------------
--  DDL for Function F_NOMBRECMDPARCLIENT
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_NOMBRECMDPARCLIENT" 
RETURN SYS_REFCURSOR
AS
  cmdCursor SYS_REFCURSOR;
  v_idClient Client.idClient%type;
  v_nbCmd NUMBER;
BEGIN
  OPEN cmdCursor FOR
    SELECT idClient, count(*) INTO v_idClient,v_nbCmd
    FROM commande
    GROUP BY idClient ORDER BY idClient ASC;
  RETURN cmdcursor;
  CLOSE cmdCursor;
END;

/
--------------------------------------------------------
--  DDL for Function F_PRODUITSPOPULAIRES
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_PRODUITSPOPULAIRES" 
RETURN SYS_REFCURSOR 
--  produits les plus  commandes
AS
  productCursor SYS_REFCURSOR;
  v_idProduit Produit.idProduit%type;
  v_qte NUMBER;
BEGIN 
  OPEN productCursor FOR
    SELECT idProduit , SUM(qte) as qte into v_idProduit, v_qte
    FROM commande
    group by idProduit ORDER BY qte DESC ;
 
    RETURN productCursor;  
    CLOSE productcursor;
END;

/
--------------------------------------------------------
--  DDL for Function F_QTEMOYENNEPARCOMMANDE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_QTEMOYENNEPARCOMMANDE" RETURN SYS_REFCURSOR
AS
  avgCursor SYS_REFCURSOR;
BEGIN
  OPEN avgCursor FOR
    select avg(sum(qte)) FROM commande GROUP BY idCOmmande;
  RETURN avgCursor;
END;

/
--------------------------------------------------------
--  DDL for Function F_GETNBRECOMMDUMOISANNEE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_GETNBRECOMMDUMOISANNEE" (p_Month IN varchar, p_Year IN varchar) RETURN NUMBER
IS
  v_TotCom Prix.Prix%type; 
  v_date VARCHAR(10);
BEGIN
 v_date := CONCAT(p_Month,'/');
 v_date := CONCAT(v_date,p_year);
 SELECT COUNT(DISTINCT(IdCommande)) INTO v_TotCom 
 FROM Commande
 WHERE TO_CHAR(Commande.DateCommande,'MM/YYYY') = v_date;
 RETURN v_TotCom;
END;

/
--------------------------------------------------------
--  DDL for Function F_NBRECOMMANDECHAQUEMOIS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_NBRECOMMANDECHAQUEMOIS" (p_Year IN NUMBER)
 RETURN SYS_REFCURSOR
IS 
 v_CursorResults SYS_REFCURSOR;
BEGIN
 FOR i IN 1..12 LOOP
  IF TO_DATE(i+'/'+p_Year) <= TO_DATE(CURRENT_DATE, 'MM/YYYY') THEN
  OPEN v_CursorResults(i,GetNbreCommOfThisMonth(i,p_Year));
  END IF;
 END LOOP;
 
 RETURN v_CursorResults;
END;

/
--------------------------------------------------------
--  DDL for Function F_CLIENTSAYANTPAYERLEPLUS
--------------------------------------------------------
CREATE OR REPLACE FUNCTION "BOCOMMERCE"."F_ClientsAyantPayerLePlus"
 RETURN SYS_REFCURSOR
IS 
 v_CursorResults SYS_REFCURSOR;
BEGIN
 OPEN v_CursorResults FOR
 
  SELECT Cl.Nom, SUM(F_GetPrixProduit(C.DateCommande, C.IdProduit))
  FROM Commande C, Client Cl
  WHERE C.IdClient = Cl.IdClient;
 
 RETURN v_CursorResults;
END;

/
