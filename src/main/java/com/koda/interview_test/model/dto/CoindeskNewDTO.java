package com.koda.interview_test.model.dto;

import java.util.List;

public class CoindeskNewDTO {
	
	private String datatime;

	private List<CoindeskNewBpiDTO> coindeskNewBpiDtoList;

	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public List<CoindeskNewBpiDTO> getCoindeskNewBpiDtoList() {
		return coindeskNewBpiDtoList;
	}

	public void setCoindeskNewBpiDtoList(List<CoindeskNewBpiDTO> coindeskNewBpiDtoList) {
		this.coindeskNewBpiDtoList = coindeskNewBpiDtoList;
	}
}
