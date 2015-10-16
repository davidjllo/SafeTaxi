package com.dso.safetaxi.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Taxis {

	
	private int placaId;
	private int modelo;
	private String marca;
	private float ratingAvg;
	private int rateCount;

	public int getRateCount() {
		return rateCount;
	}

	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}

	public int getPlacaId() {
		return placaId;
	}

	public void setPlacaId(int placaId) {
		this.placaId = placaId;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
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
	
	public Taxis(int placaId, int modelo, String marca,
				float ratingAvg, int rateCount) {
		super();
		this.placaId = placaId;
		this.modelo = modelo;
		this.marca = marca;
		this.ratingAvg = ratingAvg;
		this.rateCount = rateCount;
	}
	
}
