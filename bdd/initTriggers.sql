--------------------------------------------------------
--  Fichier créé - mardi-mai-06-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger TESTQTESTOCKPRODUIT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOCOMMERCE"."TESTQTESTOCKPRODUIT" 
AFTER UPDATE OF QteStock ON Produit
FOR EACH ROW
DECLARE 
  v_reception  Approvisionnement.Reception%TYPE;
BEGIN
 IF (:new.QteStock)<10 THEN
  SELECT Reception INTO v_Reception FROM Approvisionnement
  WHERE DateCommande = (SELECT MAX(DateCommande) FROM Approvisionnement
                        WHERE Approvisionnement.IdProduit = :new.idProduit);
  IF v_reception != 1  THEN
      AddApprovisionnement(:new.idProduit,'2014/04/24 21:02:44', 10, 1);
  END IF;
 END IF;
END;
/
ALTER TRIGGER "BOCOMMERCE"."TESTQTESTOCKPRODUIT" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRIGNEWCMD
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BOCOMMERCE"."TRIGNEWCMD" 
 AFTER INSERT ON Commande
 FOR EACH ROW
DECLARE
 v_CountHistoCmd NUMBER;
BEGIN
 -- On regarde si la commande a déjà un HistoriqueStatutCmd
 SELECT COUNT(H.IdHistostatutcmd) INTO v_CountHistoCmd
 FROM HistoriqueStatutCmd H
 WHERE H.IdCOmmande = :NEW.IdCommande;
 
 -- Si aucun Historique : on l'initialise a "En Attente de paiement" sinon rien
 IF v_CountHistoCmd = 0 THEN
  AddHistoriqueStatutCmd(0, :NEW.IdCommande, :NEW.DateCommande) ;
 END IF;
END;
/
ALTER TRIGGER "BOCOMMERCE"."TRIGNEWCMD" ENABLE;
