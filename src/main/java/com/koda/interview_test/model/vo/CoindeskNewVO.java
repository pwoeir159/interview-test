package com.koda.interview_test.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindeskNewVO {
	
	@JsonProperty(value = "time")
	private CoindeskNewTimeVO coindeskNewTimeVo;

	@JsonProperty(value = "bpi")
	private CoindeskNewBpiVO coindeskNewBpiVo;

	public CoindeskNewTimeVO getCoindeskNewTimeVo() {
		return coindeskNewTimeVo;
	}

	public void setCoindeskNewTimeVo(CoindeskNewTimeVO coindeskNewTimeVo) {
		this.coindeskNewTimeVo = coindeskNewTimeVo;
	}

	public CoindeskNewBpiVO getCoindeskNewBpiVo() {
		return coindeskNewBpiVo;
	}

	public void setCoindeskNewBpiVo(CoindeskNewBpiVO coindeskNewBpiVo) {
		this.coindeskNewBpiVo = coindeskNewBpiVo;
	}

}
