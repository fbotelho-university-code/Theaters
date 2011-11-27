import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import domain.Available;
import domain.Seat;
import domain.Session;
import domain.Theater;


public class TesteMap {

	public static void main(String[] args){
		Collection<Theater> val = new LinkedList<Theater>(); 
		for (int i = 0 ; i < 1500 ; i++){
			//TODO different locations
			Theater t =new Theater();
			t.setName(i + ""); 
			if ( i < 300 ){
				t.setLocation("Algarve");
			}
			if ( i >= 300 && i < 767){
				t.setLocation("Açores"); 
			}
			if (i >= 767  && i < 1000){
				t.setLocation("Porto"); 
			}
			if (i >= 1000 ){
				t.setLocation("Lisboa"); 
			}
			
			Session s = t.getSession(); 
			s.setMovie("um filme");
			val.add(t); 
		}

		Theater t = new Theater(); // da te o teatro. 
		t.getReserved(); // Dá -te a chave do lugar que é teu. O booleano de retorno de buy basicamente diz-te se isso tá a null ou nao. PODE ESTAR A NULO!
		Map<String,Seat> se = t.getSession().getSeats(); 
		
		for (char l = 'A' ; l < 'Z' ; l++){
			for (int i =0; i < 40 ; i++){
				String chave_seat = l + "" + i; 
				Seat s = se.get(chave_seat); // Tens o lugar
				
				if (s.getState() instanceof Available){
					// print available; 
				}
				
			}
			
		}
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();  
		
		for (Theater myT : val){
			map.put(myT.getName(), Theater.inversePseudoFactory(myT)); 
		}
		
/*
		Map<String,String>  seats = Theater.inversePseudoFactory(t);

		for(Map.Entry<String, String> en : seats.entrySet()){
			System.out.println(en.getKey() + " = " + en.getValue()); 
		
		}
	*/	
	}
}
