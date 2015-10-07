package com.dso.safetaxi.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Taxis {

	
	private int taxiId;
	private int placaId;
	private String modelo;
	private String marca;
	private float ratingAvg;
	
	public int getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(int taxiId) {
		this.taxiId = taxiId;
	}

	public int getPlacaId() {
		return placaId;
	}

	public void setPlacaId(int placaId) {
		this.placaId = placaId;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(float ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public Taxis(){
		
	}
	
	public Taxis(int taxiId, int placaId, String modelo, String marca,
			float ratingAvg) {
		super();
		this.taxiId = taxiId;
		this.placaId = placaId;
		this.modelo = modelo;
		this.marca = marca;
		this.ratingAvg = ratingAvg;
	}
	
}
