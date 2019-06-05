package it.polito.tdp.model;

public class Vicini {
	
	
	private Centro c1;
	private Centro c2;
	double distance;
	
	
	public Vicini(Centro c1, Centro c2, double distance) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.distance = distance;
	}
	public Centro getC1() {
		return c1;
	}
	public void setC1(Centro c1) {
		this.c1 = c1;
	}
	public Centro getC2() {
		return c2;
	}
	public void setC2(Centro c2) {
		this.c2 = c2;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Vicini [c1=" + c1 + ", c2=" + c2 + ", distance=" + distance + "]";
	}
	
	

}
