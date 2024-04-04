package com.open;

import java.util.Date;

public class Information {
	
	 private String timestamp;
     private String feature;
     private int ean;
     private String data;
     
     public Information() {
    	 
     }

	/**
	 * @param timestamp
	 * @param feature
	 * @param ean
	 * @param data
	 */
	public Information(String timestamp, String feature, int ean, String data) {
		super();
		this.timestamp = timestamp;
		this.feature = feature;
		this.ean = ean;
		this.data = data;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public int getEan() {
		return ean;
	}

	public void setEan(int ean) {
		this.ean = ean;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
     
	@Override public String toString() {
	  
	  return String.format("{timestamp: %s , feature: %s , earn :%s , Data:%s }",
	  timestamp,feature,ean,data); }
	 

}
