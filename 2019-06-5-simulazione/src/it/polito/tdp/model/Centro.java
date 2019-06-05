package it.polito.tdp.model;

public class Centro {
	
	private int centro;
	private double latitudine;
	private double longitudine;
	
	public Centro(int centro, double latitudine, double longitudine) {
		super();
		this.centro = centro;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	public int getCentro() {
		return centro;
	}
	public void setCentro(int centro) {
		this.centro = centro;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	@Override
	public String toString() {
		return "Centro [centro=" + centro + ", latitudine=" + latitudine + ", longitudine=" + longitudine + "]";
	}
	
	
	
	

}
