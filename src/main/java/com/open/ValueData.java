package com.open;

import java.util.List;

public class ValueData {
	
	private List<Information> information;
	
	public ValueData() {
		
	}

	/**
	 * @param information
	 */
	public ValueData(List<Information> information) {
		super();
		this.information = information;
	}

	public List<Information> getInformation() {
		return information;
	}

	public void setInformation(List<Information> information) {
		this.information = information;
	}
	
	@Override
	
	public String toString() {
		
		return String.format("{information:%s }",information);
	}
	

}
