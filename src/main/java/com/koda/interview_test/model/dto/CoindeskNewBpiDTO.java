package com.koda.interview_test.model.dto;

import com.koda.interview_test.model.vo.CoindeskNewBpiEurVO;
import com.koda.interview_test.model.vo.CoindeskNewBpiGbpVO;
import com.koda.interview_test.model.vo.CoindeskNewBpiUsdVO;
import com.koda.interview_test.model.vo.CoindeskNewBpiVO;
import com.koda.interview_test.util.Util;

public class CoindeskNewBpiDTO {

	private CoindeskNewBpiUsdDTO coindeskNewBpiUsdDto;
	
	private CoindeskNewBpiGbpDTO coindeskNewBpiGbpDto;

	private CoindeskNewBpiEurDTO coindeskNewBpiEurDto;
	
	public CoindeskNewBpiUsdDTO getCoindeskNewBpiUsdDto() {
		return coindeskNewBpiUsdDto;
	}

	public void setCoindeskNewBpiUsdDto(CoindeskNewBpiUsdDTO coindeskNewBpiUsdDto) {
		this.coindeskNewBpiUsdDto = coindeskNewBpiUsdDto;
	}

	public CoindeskNewBpiGbpDTO getCoindeskNewBpiGbpDto() {
		return coindeskNewBpiGbpDto;
	}

	public void setCoindeskNewBpiGbpDto(CoindeskNewBpiGbpDTO coindeskNewBpiGbpDto) {
		this.coindeskNewBpiGbpDto = coindeskNewBpiGbpDto;
	}

	public CoindeskNewBpiEurDTO getCoindeskNewBpiEurDto() {
		return coindeskNewBpiEurDto;
	}

	public void setCoindeskNewBpiEurDto(CoindeskNewBpiEurDTO coindeskNewBpiEurDto) {
		this.coindeskNewBpiEurDto = coindeskNewBpiEurDto;
	}
	
	public CoindeskNewBpiVO convertVo() {
		CoindeskNewBpiVO vo = new CoindeskNewBpiVO();
		vo.setCoindeskNewBpiUsdVo(Util.toVo(this.coindeskNewBpiUsdDto, new CoindeskNewBpiUsdVO()));
		vo.setCoindeskNewBpiGbpVo(Util.toVo(this.coindeskNewBpiGbpDto, new CoindeskNewBpiGbpVO()));
		vo.setCoindeskNewBpiEurVo(Util.toVo(this.coindeskNewBpiEurDto, new CoindeskNewBpiEurVO()));
		
		return vo;
	}

	@Override
	public String toString() {
		return "CoindeskNewBpiDTO [coindeskNewBpiEurDto=" + coindeskNewBpiEurDto + ", coindeskNewBpiGbpDto="
				+ coindeskNewBpiGbpDto + ", coindeskNewBpiUsdDto=" + coindeskNewBpiUsdDto + "]";
	}
}
