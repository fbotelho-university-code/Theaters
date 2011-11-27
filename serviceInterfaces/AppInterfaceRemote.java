package serviceInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;





public interface AppInterfaceRemote extends Remote{
	public void changeReservation (String idSession, String lugar, RespondToWebServerInterface resp) throws RemoteException;
	public void buy(String idSession, String idTheater, RespondToWebServerInterface resp) throws RemoteException; 
	public void confirmReservation(String idSession, RespondToWebServerInterface resp) throws RemoteException;
	public void getTheaters(String idSession, RespondToWebServerInterface resp) throws RemoteException; 
	public void getZones(String idSession, RespondToWebServerInterface resp ) throws RemoteException; 
	public void getTheaters(String idSession, String zone, RespondToWebServerInterface resp) throws RemoteException;
	
}

