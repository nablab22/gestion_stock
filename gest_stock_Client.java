//Nom : LARBAOUI
//Prénom: Nabila
//Spécialité:  M1_RSSI  Groupe:1
package TP5_22_23;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

	public class gest_stock_Client implements client_notif_interface{
	
		public gest_stock_Client() throws RemoteException {}
		public static void main(String[] args) {
			
	    Scanner scan=new Scanner(System.in);
	    Scanner scan1=new Scanner(System.in);
	    Scanner scan2=new Scanner(System.in);
	    Scanner scan3=new Scanner(System.in);
	    
	    	try {
	    	    gest_stock_Interface stub = (gest_stock_Interface) Naming.lookup("rmi://localhost:2023/serverImpl");

	    	    gest_stock_Client client = new gest_stock_Client();
	    	    UnicastRemoteObject.exportObject(client, 0);
	    	    stub.registerClient(client);



	    	   while (true) {
	    	    System.out.println("Choisir une opération du Menu: ");
                System.out.println("1. Consulter une quantité d'un produit");
                System.out.println("2. Obtenir la liste des produits");
                System.out.println("3. Ajouter un produit/Quantité");
                System.out.println("4. Retirer une Quantité d'un produit");
                int menu = scan.nextInt();
                switch (menu) {
                case 1:
                	System.out.println("Donner le nom du produit pour avoir sa quantité: ");
                	String nom=scan1.nextLine();
                	System.out.print("La quantité du produit "+nom+": ");
                	System.out.println(stub.obtenir_quantite(nom));
                	break;
                case 2:
                	System.out.println("La liste des produits : ");
		            List<Produit> liste_produit=stub.obtenir_liste();
		            for (int i = 0; i < liste_produit.size(); i++) {
		                System.out.print(liste_produit.get(i));
		                System.out.println();}
		            break;
                case 3:
                	System.out.println("Ajouter un Produit/Quantité: ");
                	System.out.println("Donner le non du produit ");
                	String nomA=scan1.nextLine();
                	System.out.println("Donner sa quantité: ");
                	int qte=scan2.nextInt();
                	System.out.println("Donner son prix: ");
                	double prix=scan3.nextInt();
                	stub.ajouter_produit(nomA,qte,prix);
                	System.out.println("La nouvelle Liste : ");
                	List<Produit> liste_produit1=stub.obtenir_liste();
                	for (int i = 0; i < liste_produit1.size(); i++) {
                		System.out.print(liste_produit1.get(i));
                		System.out.println();
                		}
		            break;
                case 4:
                	System.out.println("Retrait Quantité: ");
                	System.out.println("Donner le non du produit à modifier ");
                	String nomM=scan1.nextLine();
                	System.out.println("Donner la Quantité à retier ");
                	int qteM=scan2.nextInt();
                	stub.retier_quantite(nomM, qteM);
		        
                	System.out.println("La nouvelle Liste : ");
	        	
                	List<Produit> liste_produit3=stub.obtenir_liste();
                	for (int i = 0; i < liste_produit3.size(); i++) {
                		System.out.print(liste_produit3.get(i));
                		System.out.println();
                		}
		            break;

                default:
                    System.out.println("Choix invalide");
                    break;
	    	    }
        		System.out.println();
  
	    	}

	   }
	    	catch (Exception e) {System.out.println("Erreur Client"+e);}
	    	
	}
		public void notifyClient() throws RemoteException{
		 System.out.println("=====\u001B[31mune quantite d'un produit modifié\u001B[0m======");
		 System.out.println("");

		 }
}
