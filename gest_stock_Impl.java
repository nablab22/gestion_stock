package TP5_22_23;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

	public class gest_stock_Impl extends UnicastRemoteObject implements gest_stock_Interface {

			private static final long serialVersionUID = 1L;
			private ArrayList<Produit> prod = new ArrayList<>();
		    private List<client_notif_interface> clients;

		    public gest_stock_Impl() throws RemoteException {
		        super();
		        prod.add(new Produit("P1", 100 , 15.5));
		        prod.add(new Produit("P2", 150 ,10));
		        prod.add(new Produit("P3", 300 ,20.5));
		        clients = new ArrayList<client_notif_interface>();
		    }

			public void ajouter_produit(String nom, int quantite, double prix) throws RemoteException {
				boolean ExisteP = false;
				for (Produit p : prod) {
		            if (p.getnom().equals(nom)) {
		                p.setquantite(p.getquantite() + quantite);
		                p.setprix(p.getprix() + prix);

		                ExisteP = true;

		                //System.out.println("Produit MAJ");
		                break;
		                }           

		        if (!ExisteP) {
			        prod.add(new Produit(nom, quantite, prix));
			        }
				}
                notifyClients();
			}
		
			public void retier_quantite(String nom, int quantite) throws RemoteException {
				for (Produit p : prod) {
		            if (p.getnom().equals(nom)) {
		                int qtemodif = p.getquantite() - quantite;
		                if (qtemodif >= 0) {
		                    p.setquantite(qtemodif);

		                } else {throw new RemoteException("La quantite demandée est supérieure à la quantite en stock.");}
		            }
				}
                notifyClients();

			}


			public int obtenir_quantite(String nom) throws RemoteException {
				
				for (Produit p : prod) {
		            if (p.getnom().equals(nom)) {
		                return p.getquantite();
		            }
				}
		        throw new RemoteException("Le produit n'existe pas");

			}

			public List<Produit> obtenir_liste() throws RemoteException {
			    return prod;
			}

			@Override
			public void registerClient(client_notif_interface client) throws RemoteException {
				    System.out.println("un client est enregistré : \n"+client);
			        clients.add(client);
			        }

			@Override
			public void unregisterClient(client_notif_interface client) throws RemoteException {
		        clients.remove(client);
				
			}
			private void notifyClients() {
		        for (client_notif_interface client : clients) {
		        	 try {
		                 client.notifyClient();
		             } catch (RemoteException e) {
		                 // Remove the client from the list if there is an error
		                 clients.remove(client);
		                 System.out.println("Problème de notification du client: " + e.getMessage());
		             }
		        }
		    }

			
	}
		 		   
		 	  
