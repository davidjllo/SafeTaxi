package com.dso.safetaxi.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Placas {
	
	private int placaId;
	private String placa;
	private String hash;
	
	public int getPlacaId() {
		return placaId;
	}
	public void setPlacaId(int placaId) {
		this.placaId = placaId;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public Placas(){}
	
	public Placas(int placaId, String placa, String hash) {
		super();
		this.placaId = placaId;
		this.placa = placa;
		this.hash = hash;
	}

}
