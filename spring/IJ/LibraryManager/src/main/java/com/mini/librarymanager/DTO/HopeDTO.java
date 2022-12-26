package com.mini.librarymanager.DTO;

public class HopeDTO {
	private String hopeISBN;
	private String hopeTitle;
	private int hopeNumber;
	private String hopeLink;

	public HopeDTO(String _hopeISBN, String _hopeTitle, int _hopeNumber, String _hopeLink) {
		this.hopeISBN = _hopeISBN;
		this.hopeTitle = _hopeTitle;
		this.hopeNumber = _hopeNumber;
		this.hopeLink = _hopeLink;
	}

	public String getHopeISBN() {
		return hopeISBN;
	}

	public void setHopeISBN(String hopeISBN) {
		this.hopeISBN = hopeISBN;
	}

	public String getHopeTitle() {
		return hopeTitle;
	}

	public void setHopeTitle(String hopeTitle) {
		this.hopeTitle = hopeTitle;
	}

	public int getHopeNumber() {
		return hopeNumber;
	}

	public void setHopeNumber(int hopeNumber) {
		this.hopeNumber = hopeNumber;
	}

	public String getHopeLink() {
		return hopeLink;
	}

	public void setHopeLink(String hopeLink) {
		this.hopeLink = hopeLink;
	}
}