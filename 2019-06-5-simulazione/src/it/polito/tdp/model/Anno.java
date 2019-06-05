package it.polito.tdp.model;

import java.time.Year;

public class Anno {
	
	private Year year;
	
	public Anno(Year year){
		this.year=year;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Anno [year=" + year + "]";
	}
	
	
	

}
