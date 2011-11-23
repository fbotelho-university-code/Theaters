package serviceInterfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;



public interface RespondToAppInterface extends Remote{
		public void putCallback(String sessionID, Boolean success) throws RemoteException;
		public void getCallback(String sessionID, String value) throws RemoteException;
		public void getCallBack(String sessionID, Map<String, String> theater) throws RemoteException;
		public void reservationCallback(String sessionID, Map<String,String> values, boolean result) throws RemoteException;	
		public void writeIFCallback(String sessionID, boolean success, boolean condition) throws RemoteException;
}
