package hu.me.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


public class GetMunkakModel {
	
	@Min(18)
	private int eletkor;

	@NotBlank
	@NotNull
	private String nev;
	
	public int getEletkor() {
		return eletkor;
	}
	
	public void setEletkor(int eletkor) {
		this.eletkor = eletkor;
	}
	
	public String getNev() {
		return nev;
	}
	
	public void setNev(String nev) {
		this.nev = nev;
	}
}
