package com.dso.safetaxi.entities;

public class Comments {
	
	private float rating;
	private String comment;
	private String hash;
	private int rateCount;
	
	public Comments(){}
	
	public Comments(float rating, String comment, String hash, int rateCount) {
		this.rating = rating;
		this.comment = comment;
		this.hash = hash;
		this.rateCount = rateCount;
	}
	
	public Comments(float rating, int rateCount) {
		this.rating = rating;
		this.rateCount = rateCount;
	}
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public int getRateCount() {
		return rateCount;
	}
	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}
}
