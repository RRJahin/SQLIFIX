 SELECT SUM(quantite) AS nb FROM ParcClient WHERE codeTParc = X_16030521721500 AND codeCliPros IN (SELECT codeProspect FROM Prospect WHERE cRep = X_16030521721501 OR codeProspect IN (SELECT codeCliPros FROM Revoir WHERE codeUtilisateur = X_16030521721502 ) )