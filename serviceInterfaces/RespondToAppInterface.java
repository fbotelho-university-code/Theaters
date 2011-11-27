package serviceInterfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;



public interface RespondToAppInterface extends Remote{
		public void putCallback(String sessionID, Boolean success, Boolean doNotTryAgain) throws RemoteException;
		public void getCallback(String sessionID, String value, Boolean doNotTryAgain) throws RemoteException;
		public void getCallBack(String sessionID, Map<String, String> theater, Boolean doNotTryAgain) throws RemoteException;
		public void reservationCallback(String sessionID, Map<String,String> values, boolean result,Boolean doNotTryAgain) throws RemoteException;	
		public void writeIFCallback(String sessionID, boolean success, boolean condition, Boolean doNotTryAgain) throws RemoteException;
		public void getRowsCallback(String sessionId, Map<String,Map<String,String>> values , Boolean exception) throws RemoteException; 
}
