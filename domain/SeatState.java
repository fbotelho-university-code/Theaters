package domain;

import java.io.Serializable;

public abstract class SeatState implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4757903652703753442L;

	public abstract SeatState clone(); 
}
