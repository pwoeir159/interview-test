package com.koda.interview_test.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindeskNewBpiVO {

	@JsonProperty(value = "USD")
	private CoindeskNewBpiUsdVO coindeskNewBpiUsdVo;
	
	@JsonProperty(value = "GBP")
	private CoindeskNewBpiGbpVO coindeskNewBpiGbpVo;

	@JsonProperty(value = "EUR")
	private CoindeskNewBpiEurVO coindeskNewBpiEurVo;

	public CoindeskNewBpiUsdVO getCoindeskNewBpiUsdVo() {
		return coindeskNewBpiUsdVo;
	}

	public void setCoindeskNewBpiUsdVo(CoindeskNewBpiUsdVO coindeskNewBpiUsdVo) {
		this.coindeskNewBpiUsdVo = coindeskNewBpiUsdVo;
	}

	public CoindeskNewBpiGbpVO getCoindeskNewBpiGbpVo() {
		return coindeskNewBpiGbpVo;
	}

	public void setCoindeskNewBpiGbpVo(CoindeskNewBpiGbpVO coindeskNewBpiGbpVo) {
		this.coindeskNewBpiGbpVo = coindeskNewBpiGbpVo;
	}

	public CoindeskNewBpiEurVO getCoindeskNewBpiEurVo() {
		return coindeskNewBpiEurVo;
	}

	public void setCoindeskNewBpiEurVo(CoindeskNewBpiEurVO coindeskNewBpiEurVo) {
		this.coindeskNewBpiEurVo = coindeskNewBpiEurVo;
	}

}
