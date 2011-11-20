package domain;
import java.io.Serializable;


public class Theater implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2855223915712795638L;
	/**
	 * 
	 */
	
	private String name;
	private String location;
	private Session session;
	
	public Theater(){
		name = location ="";
		session = new Session(); 
	}
	
	/**
	 * @param name
	 * @param location
	 */
	public Theater(String name, String location, Session s) {
		this.name = name;
		this.location = location;
		session = s; 
	}
	
	public Theater(Theater t){
		this.name = t.getName();
		this.location = t.getLocation();
		this.session = t.getSession(); 
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
