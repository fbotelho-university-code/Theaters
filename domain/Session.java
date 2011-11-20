package domain;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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


	public Session(){
		this.seats = new HashMap<String,Seat>(); 
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


