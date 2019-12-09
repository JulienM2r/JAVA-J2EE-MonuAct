package org.o7planning.thymeleaf.model;

public class VilleLoc {
	private String cp;
    private String city;
    private String latitude;
    private String longitude;
	
    public VilleLoc(String cp, String city, String latitude, String longitude) {
		this.cp = cp;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


}
