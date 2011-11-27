package serviceInterfaces;
import java.rmi.*;
import java.util.Collection;
import java.util.Map;

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
	// Receveive ResponseToChangeReservation is the callback from changeReservation. With him comes the reserved place for the sessionId in the app. All rest can be inferred from the result.  

	public void receiveResponseToChangeReservation(String reservedPlace,String idSession) throws RemoteException; 
		
	public void receiveConfirmationOfBuy(String idSession) throws RemoteException; 
	public void receiveTheaters(Map<String, Map<String, String>> map, String idSession) throws RemoteException;
	public void receiveZones(Collection<String> map, String idSession) throws RemoteException;
	public void error(String string) throws RemoteException;
}
