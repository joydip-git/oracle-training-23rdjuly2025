package com.oracle.basicspringapp;

public class Address {
	private int doorNo;
	private String areaName;
	private String cityName;
	
	public Address() {
	}

	public Address(int doorNo, String areaName, String cityName) {
		this.doorNo = doorNo;
		this.areaName = areaName;
		this.cityName = cityName;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
