package com.infy.model;

public class Details {
	
	private String detailsId;
	private String about;
	private String packageInclusion;
	private String highlights;
	private String pace;
	private Itinerary itinerary;
	
	public String getDetailsId() {
		return detailsId;
	}
	
	public void setDetailsId(String detailsId) {
		this.detailsId = detailsId;
	}
	
	public String getAbout() {
		return about;
	}
	
	public void setAbout(String about) {
		this.about = about;
	}
	
	public String getPackageInclusion() {
		return packageInclusion;
	}
	
	public void setPackageInclusion(String packageInclusion) {
		this.packageInclusion = packageInclusion;
	}
	
	public String getHighlights() {
		return highlights;
	}
	
	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}
	
	public String getPace() {
		return pace;
	}
	
	public void setPace(String pace) {
		this.pace = pace;
	}
	
	public Itinerary getItinerary() {
		return itinerary;
	}
	
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
}
