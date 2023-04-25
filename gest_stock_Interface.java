package TP5_22_23;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface gest_stock_Interface extends Remote {
	
    List<Produit> obtenir_liste() throws RemoteException;
    int obtenir_quantite(String nom) throws RemoteException;
    void ajouter_produit(String nom, int quantite, double prix) throws RemoteException;
    void retier_quantite(String nom, int quantite) throws RemoteException;
    void unregisterClient(client_notif_interface notif_client) throws RemoteException;
	void registerClient(client_notif_interface notif_client) throws RemoteException;
    }

