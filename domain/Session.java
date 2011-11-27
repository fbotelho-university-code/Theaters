package domain;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Session implements Serializable{
	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1519121059578595718L;
	private Map<String, Seat> seats; 
	private String movie;

	
	
	public static Map<String,String> getSeats(Session s){
		Map<String,String> map = new HashMap<String,String>();
		
		for(Seat seat : s.getSeats().values()){
			map.put(seat.getId(), seat.getState().myBdValue()); 
		}
		
		return map;
	}
	
	public static Session getMap(Map<String,String> values){
		Session se = new Session();
		Map<String,Seat> myValues = new HashMap<String,Seat>();
		
		for (char l = 'A' ; l < 'Z' ; l++){
			for (int i =0; i < 40 ; i++){
				//TODO - Mário martins stated that this was a big bottleneck when writing to files
				String id = l + "" + i;
				SeatState state = null; 
				String value = values.get(id);

				if (value != null){
					if (value.equals(Occupied.BD_VALUE)){
						state = Occupied.instance; 
					}
					else{
						if (value.equals(Reserved.BD_VALUE)){
							state = Reserved.instance; 
						}
						else{
							if (value.equals(Available.BD_VALUE)){
								state = Reserved.instance; 
							}
						}
					}
				}
				//else  (If we found a valid seat state)
				if (state != null){
					Seat s = new Seat(id, state);
					myValues.put(s.getId(), s);
				}
			}
		}
		se.setSeats(myValues); 
		
		return se;
	}
	
	
	public Session(){
		this.seats = new HashMap<String,Seat>();
		
		for (char l = 'A' ; l < 'Z' ; l++){
			for (int i =0; i < 40 ; i++){
				String id = l + "" + i;
				Seat s = new Seat(id, Available.instance);
				seats.put(id, s); 
			}
		}
		this.movie = ""; 
	}
	
	
	/**
	 * @param seats
	 * @param movie
	 */
	public Session(Map<String, Seat> seats, String movie) {
		this.seats = seats;
		this.movie = movie;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(); 
		s.append("Session [seats=" + seats + ", movie=" + movie +  "]"); 
		s.append("[ "); 

		for (Seat en : seats.values()){
			s.append(en.getId() + " - " + en.getState().toString()); 
		}
		
		return movie; 
	}

	public Session(Session s){
		this.seats = s.getSeats(); 
		this.movie = s.getMovie(); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!compareMap(seats, other.getSeats()))
			return false;
		return true;
	}


	public Map<String, Seat> getSeats() {
		return cloneMap(seats);
	}


	public void setSeats(Map<String, Seat> seats) {
		this.seats = cloneMap(seats);
	}


	public String getMovie() {
		return movie;
	}


	public void setMovie(String movie) {
		this.movie = movie;
	}


	private static Map<String,Seat> cloneMap(Map<String,Seat> seats){
		Map<String,Seat> result = new HashMap<String,Seat>(); 
		for (Map.Entry<String,Seat> en : seats.entrySet()){
			result.put(en.getKey(), en.getValue().clone()); 
		}
		return result; 
	}
	
	private static boolean compareMap(Map<String,Seat> seats, Map<String,Seat> seats2){
		Iterator<Seat> it = seats.values().iterator();
		if (seats.size() != seats2.size()){
			return false; 
		}
		while(it.hasNext()){
			Seat s = it.next(); 
			if (!seats2.containsKey((s.getId()))){
				return false; 
			}
		}
		return true; 
	}
}


