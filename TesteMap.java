import java.util.Map;

import domain.Session;
import domain.Theater;


public class TesteMap {

	public static void main(String[] args){
		Theater t = new Theater();
		System.out.println("aki"); 

		t.setLocation("location"); 
		t.setName("myName");
		t.setReserved("reservado"); 
		Session s = t.getSession(); 
		s.setMovie("maluk"); 
		t.setSession(s); 
		
		Map<String,String> map = Theater.inversePseudoFactory(t);
		

		for(Map.Entry<String, String> en : map.entrySet()){
			System.out.println(en.getKey() + " = " + en.getValue()); 
		
		}
		
/*
		Map<String,String>  seats = Theater.inversePseudoFactory(t);

		for(Map.Entry<String, String> en : seats.entrySet()){
			System.out.println(en.getKey() + " = " + en.getValue()); 
		
		}
	*/	
	}
}
