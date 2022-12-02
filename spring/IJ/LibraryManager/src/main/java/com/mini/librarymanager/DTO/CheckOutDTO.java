package com.mini.librarymanager.DTO;

import java.sql.*;

public class CheckOutDTO {
	private String checkOutISBN;
	private String checkOutTitle;
	private String checkOutEmail;
	private Date checkOutRentalDate;
	private Date checkOutReturnDueDate;
	private int checkOutExtensionCount;

	public CheckOutDTO(String _inputCheckOutISBN, String _inputCheckOutEmail) {
		// 데이터 추가 때
		this.checkOutISBN = _inputCheckOutISBN;
		this.checkOutEmail = _inputCheckOutEmail;
	}

	public CheckOutDTO(String _checkOutISBN, String _checkOutTitle, String _checkOutEmail, Date _checkOutRentalDate,
			Date _checkOutReturnDueDate, int _checkOutExtensionCount) {
		// 데이터 받아올 때
		super();
		this.checkOutISBN = _checkOutISBN;
		this.checkOutTitle = _checkOutTitle;
		this.checkOutEmail = _checkOutEmail;
		this.checkOutRentalDate = _checkOutRentalDate;
		this.checkOutReturnDueDate = _checkOutReturnDueDate;
		this.checkOutExtensionCount = _checkOutExtensionCount;
	}

	public String getCheckOutISBN() {
		return checkOutISBN;
	}

	public void setCheckOutISBN(String checkOutISBN) {
		this.checkOutISBN = checkOutISBN;
	}

	public String getCheckOutTitle() {
		return checkOutTitle;
	}

	public void setCheckOutTitle(String checkOutTitle) {
		this.checkOutTitle = checkOutTitle;
	}

	public String getCheckOutEmail() {
		return checkOutEmail;
	}

	public void setCheckOutEmail(String checkOutEmail) {
		this.checkOutEmail = checkOutEmail;
	}

	public Date getCheckOutRentalDate() {
		return checkOutRentalDate;
	}

	public void setCheckOutRentalDate(Date checkOutRentalDate) {
		this.checkOutRentalDate = checkOutRentalDate;
	}

	public Date getCheckOutReturnDueDate() {
		return checkOutReturnDueDate;
	}

	public void setCheckOutReturnDueDate(Date checkOutReturnDueDate) {
		this.checkOutReturnDueDate = checkOutReturnDueDate;
	}

	public int getCheckOutExtensionCount() {
		return checkOutExtensionCount;
	}

	public void setCheckOutExtensionCount(int checkOutExtensionCount) {
		this.checkOutExtensionCount = checkOutExtensionCount;
	}

	@Override
	public String toString() {
		return "CheckOutDTO [checkOutISBN=" + checkOutISBN + ", checkOutTitle=" + checkOutTitle + ", checkOutEmail="
				+ checkOutEmail + ", checkOutRentalDate=" + checkOutRentalDate + ", checkOutReturnDueDate="
				+ checkOutReturnDueDate + "]";
	}
}
