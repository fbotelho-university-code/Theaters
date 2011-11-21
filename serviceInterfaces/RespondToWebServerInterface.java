package serviceInterfaces;
import java.rmi.*;
import java.util.Collection;

import domain.Theater;

public interface RespondToWebServerInterface extends Remote{
	/**
	 * 
	 * @param t The theater state. 
	 * @param idSession 
	 * @param result Has successfull reserved a place in Theater. 
	 * @throws RemoteException
	 */
	public void receiveTheaterAfterBuy(Theater t, String idSession,boolean result) throws RemoteException;
	public void receiveTheaterAfterReservation(Theater t,String idSession) throws RemoteException; 
	public void receiveConfirmationOfBuy(String idSession) throws RemoteException; 
	public void receiveTheaters(Collection<Theater> theaters, String idSession) throws RemoteException;
	public void receiveZones(Collection<String> zones, String idSession) throws RemoteException;
	public void error(String string);
}
