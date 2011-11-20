package serviceInterfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;




public interface BDInterfaceRemote extends Remote{
	public void put(String sessionID, RespondToAppInterface callback, String key, Map<String,String> values) throws RemoteException;
	public void put(String sessionID, RespondToAppInterface callback, String key1, String key2, String value) throws RemoteException;
	public void get(String sessionID, RespondToAppInterface callback, String key) throws RemoteException;
	public void get(String sessionID, RespondToAppInterface callback, String key1, String key2) throws RemoteException;
	public void writeif(String sessionID, RespondToAppInterface callback, String key1, String key2, String value, String expected) throws RemoteException;
	public void reserveIfFree(String sessionID, RespondToAppInterface callback, String key) throws RemoteException;

}