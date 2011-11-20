package serviceInterfaces;
import java.rmi.*;
import java.util.Collection;

import domain.Theater;

public interface RespondToWebServerInterface extends Remote{
	public void receiveTheaterAfterBuy(Theater t, String idSession) throws RemoteException;
	public void receiveTheaterAfterReservation(Theater t,String idSession) throws RemoteException; 
	public void receiveConfirmationOfBuy(String idSession) throws RemoteException; 
	public void receiveTheaters(Collection<Theater> theaters, String idSession) throws RemoteException;
	public void receiveZones(Collection<String> zones, String idSession) throws RemoteException;
}
