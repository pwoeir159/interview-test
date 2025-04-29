package com.koda.interview_test.model.dto;

import com.koda.interview_test.model.vo.CoindeskNewTimeVO;
import com.koda.interview_test.model.vo.CoindeskNewVO;
import com.koda.interview_test.util.Util;

public class CoindeskNewDTO {
	
	private CoindeskNewTimeDTO coindeskNewTimeDto;

	private CoindeskNewBpiDTO coindeskNewBpiDto;

	public CoindeskNewTimeDTO getCoindeskNewTimeDto() {
		return coindeskNewTimeDto;
	}

	public void setCoindeskNewTimeDto(CoindeskNewTimeDTO coindeskNewTimeDto) {
		this.coindeskNewTimeDto = coindeskNewTimeDto;
	}

	public CoindeskNewBpiDTO getCoindeskNewBpiDto() {
		return coindeskNewBpiDto;
	}

	public void setCoindeskNewBpiDto(CoindeskNewBpiDTO coindeskNewBpiDto) {
		this.coindeskNewBpiDto = coindeskNewBpiDto;
	}
	
	public CoindeskNewVO convertVo() {
		CoindeskNewVO vo = new CoindeskNewVO();
		vo.setCoindeskNewTimeVo(Util.toVo(this.coindeskNewTimeDto, new CoindeskNewTimeVO()));
		vo.setCoindeskNewBpiVo(this.coindeskNewBpiDto.convertVo());
		
		return vo;
	}

}
