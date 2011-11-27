package serviceInterfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;




public interface BDInterfaceRemote extends Remote{
	public void put(String sessionID, RespondToAppInterface callback, String table,String rowKey, Map<String,String> valuesToWrite, Map<String,String> readOnlyData) throws RemoteException;
	public void put(String sessionID, RespondToAppInterface callback, String table, String rowKey, String columnKey, String valueToWrite) throws RemoteException;
	public void get(String sessionID, RespondToAppInterface callback, String table, String rowKey) throws RemoteException;
	public void get(String sessionID, RespondToAppInterface callback, String table, String rowKey, String columnKey) throws RemoteException;
	public void writeif(String sessionID, RespondToAppInterface callback, String table, String rowKey, String columnKey, String valueToWrite, String expectedValue) throws RemoteException;
	public void reserveIfFree(String sessionID, RespondToAppInterface callback, String table, String rowKey) throws RemoteException;
	
	/**
	 * To this moment only returns data from the readonly hardcoded collumn family 
	 */
	
	public void getRows(String sessionID, RespondToAppInterface callback, String tableKey) throws RemoteException; 
	/**
 * Write if based on condition variable present 
 * @param idSession
 * @param callback
 * @param idTheater
 * @param newPlace
 * @param bdValue
 * @param valuesToWrite
 */
	public void writeif(String idSession, RespondToAppInterface callback, String table, 
			String rowKey, String columnKey, String condition,
			Map<String, String> valuesToWrite) throws RemoteException;

}