package hu.me.model;

public class User {

	private String nev;
	private long id;
	
	public User() {
	}
	
	public User(String nev, long id) {
		super();
		this.nev = nev;
		this.id = id;
	}
	
	public String getNev() {
		return nev;
	}
	
	public void setNev(String nev) {
		this.nev = nev;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
