package domain;

import java.io.Serializable;

public class Available extends SeatState implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5428884895987339781L;
	public static final Available instance = new Available(); 
	

	private Available() {
		
	}
	
	@Override
	public SeatState clone() {
		return instance; 
	}
	
	public boolean equals(Object o){
		if (o != null && o.getClass() == Available.class) return true;
		return false; 
	}
	
}
