package TP5_22_23;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface client_notif_interface extends Remote{
	

	public void notifyClient() throws RemoteException;;

	}
