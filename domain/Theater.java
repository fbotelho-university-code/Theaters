package domain;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Theater implements Serializable{
	//TODO - alter reserved to BD. 
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -2855223915712795638L;
	public static final String BD_NAME = "name"; 
	public static final String BD_LOCATION = "location"; 
	public static final String BD_RESERVED = "reserved"; 
	
	public static Theater pseudoFactory(Map<String, String> values ) {
			// I do regret the following code. 
		String name = values.get(BD_NAME); 
		String location = values.get(BD_LOCATION); 
		String session_movie = values.get(Session.BD_MOVIE_NAME);
		String reserved = values.get(BD_RESERVED);
		
		HashMap<String, Seat> seats = new HashMap<String,Seat>(); 

		for (int l = 'A' ; l < 'Z' ; l++){
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
					Seat s = new Seat(String.valueOf(id), state); 
					seats.put(s.getId(), s); 
				}
			}
		}
		return new Theater(name, location, new Session(seats, session_movie), reserved); 
	}
	
	public static Map<String,String> inversePseudoFactory(Theater t){
		Map<String,String> values = new HashMap<String,String>(); 
		
		values.put(Theater.BD_LOCATION, t.getLocation()); 
		values.put(Theater.BD_NAME, t.getName()); 
		values.put(Theater.BD_RESERVED, t.getReserved()); 
		values.put(Session.BD_MOVIE_NAME, t.getSession().getMovie());
		
		for (Seat s : t.getSession().getSeats().values()){
			values.put(s.getId(), s.getState().myBdValue()); 
		}
		return values; 
	}
	
	
	/**
	 * 
	 */
	
	private String name;
	private String location;
	private Session session;
	
	private String reserved; 
	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public Theater(){
		reserved = name = location ="";
		session = new Session(); 
	}
	
	/**
	 * @param name
	 * @param location
	 */
	public Theater(String name, String location, Session s, String reserved) {
		this.name = name;
		this.location = location;
		session = s;
		this.reserved = reserved; 
	}
	
	public Theater(Theater t){
		this.name = t.getName();
		this.location = t.getLocation();
		this.session = t.getSession();
		this.reserved = t.getReserved(); 
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((reserved == null) ? 0 : reserved.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
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
		Theater other = (Theater) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reserved == null) {
			if (other.reserved != null)
				return false;
		} else if (!reserved.equals(other.reserved))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Theater [name=" + name + ", location=" + location + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public Theater clone(){ 
		return new Theater(this); 
	}
	
}
