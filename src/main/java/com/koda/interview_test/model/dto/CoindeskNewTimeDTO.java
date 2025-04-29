package com.koda.interview_test.model.dto;

public class CoindeskNewTimeDTO {

	private String updated;

	private String updatedISO;

	private String updateduk;

	public CoindeskNewTimeDTO() {
		super();
	}

	public CoindeskNewTimeDTO(String updated, String updatedISO, String updateduk) {
		super();
		this.updated = updated;
		this.updatedISO = updatedISO;
		this.updateduk = updateduk;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String  getUpdatedISO() {
		return updatedISO;
	}

	public void setUpdatedISO(String  updatedISO) {
		this.updatedISO = updatedISO;
	}

	public String getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}

	@Override
	public String toString() {
		return "CoindeskNewTimeDTO [updated=" + updated + ", updatedISO=" + updatedISO + ", updateduk=" + updateduk
				+ "]";
	}

}
