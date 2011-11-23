package domain;

import java.io.Serializable;

public   class Seat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5296453674269806373L;
	String id; 
	SeatState state; 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
	public Seat(){
		id =""; 
		state = Available.instance; 
	}
	
	/**
	 * @param id
	 * @param state
	 */
	
	public Seat(String id, SeatState state) {
		this.id = id;
		this.state = state.clone();
	}

	public Seat(Seat s){
		this.state = s.getState(); 
		this.id = s.getId(); 
	}

	
	public  Seat clone(){ return new Seat(this); }


	public SeatState getState(){
		return state.clone();
	}


	public void setState(SeatState state) {
		this.state = state.clone();
	}; 
}
