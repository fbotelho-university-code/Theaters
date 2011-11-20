package domain;

import java.io.Serializable;

public class Occupied extends SeatState implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3685796512239241545L;
	public static final Occupied instance = new Occupied(); 
	

	private Occupied(){
	
	}
	
	@Override
	public SeatState clone() {
		return instance; 
	}
	
	public boolean equals(Object o){
		if (o != null && o.getClass() == Occupied.class) return true;
		return false; 
	}
}

