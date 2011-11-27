import java.rmi.registry.LocateRegistry;

import serviceInterfaces.AppInterfaceRemote;


public class GetAndSetRmi {

	public  GetAndSetRmi(){
	}
	
	
	/*
		try{
			java.rmi.registry.Registry reg = LocateRegistry.getRegistry(host); 
			Hello stub = (Hello) reg.lookup("Hello"); 
			String response = stub.sayHello(); 
			System.out.println("response:" + response);
			
		}catch(Exception e){
			System.err.println("Client exception: " + e.getMessage()); 
			e.printStackTrace(); 
		}
		return null;
	}
	*/
}
