package domain;

import java.io.Serializable;

public class Reserved extends SeatState implements Serializable{
	public static final String BD_VALUE = "RESERVED"; 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1528975515258859292L;
	public static final Reserved instance = new Reserved(); 
	

	private Reserved(){
	
	}
	
	@Override
	public SeatState clone() {
		return instance; 
	}
	
	public boolean equals(Object o){
		if (o != null && o.getClass() == Reserved.class) return true;
		return false; 
	}

	@Override
	public String myBdValue() {
		return BD_VALUE; 
	}
	
}