//Nom : LARBAOUI
//Prénom: Nabila
//Spécialité:  M1_RSSI  Groupe:1
package TP5_22_23;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class gest_stock_Server {

    public static void main(String argv[]){
		    	
			try
			    {
				gest_stock_Impl obj=new gest_stock_Impl();
				LocateRegistry.createRegistry(2023);
			    Naming.rebind("rmi://localhost:2023/serverImpl", obj);
				System.out.println("Serveur en attente de requêtes" );
				
			    }
			catch (Exception e)
			    {
				System.out.println("Erreur Serveur: "+e);
			    }
		    }
	}