package domain;

import java.io.Serializable;

public class Occupied extends SeatState implements Serializable{
	public static final String BD_VALUE = "OCCUPIED"; 
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
	
	@Override
	public String toString() {
		return "Occupied";
	}

	public boolean equals(Object o){
		if (o != null && o.getClass() == Occupied.class) return true;
		return false; 
	}

	@Override
	public String myBdValue() {
		// TODO Auto-generated method stub
		return BD_VALUE; 
	}
}

