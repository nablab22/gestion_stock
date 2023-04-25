# gestion_stock
TP5 :« Application client-serveur pour la gestion de stock avec java RMI»
Construire une application java RMI permettant la gestion d’un stock représenté par une liste
de produits chez le serveur.
Pour simplifier chaque produit peut être représenté par son nom et sa quantité.
Le serveur doit permettre :
- La consultation du stock : par exemple, chaque client doit pouvoir obtenir la quantité
d’un produit donné, la liste de tous les produits disponibles.
- La modification du stock : chaque client doit pouvoir demander à ajouter une quantité
d’un produit, à retirer une quantité d’un produit.
- D’alerter, en temps réel tous les clients lorsqu'une modification est apportée au stock.
Pour cela la notion de callback doit être utilisée. Chaque client doit donc s’enregistrer
auprès du serveur .Les clients désirant être informés doivent rester connectés au serveur.
