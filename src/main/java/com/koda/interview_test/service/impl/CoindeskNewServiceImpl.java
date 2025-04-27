package com.koda.interview_test.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.api.model.CoindeskBpiEur;
import com.koda.interview_test.api.model.CoindeskBpiGbp;
import com.koda.interview_test.api.model.CoindeskBpiUsd;
import com.koda.interview_test.model.dto.CoindeskNewBpiDTO;
import com.koda.interview_test.model.dto.CoindeskNewDTO;
import com.koda.interview_test.model.dto.CurrencyInfoDTO;
import com.koda.interview_test.service.CoindeskNewService;
import com.koda.interview_test.service.CoindeskService;
import com.koda.interview_test.service.CurrencyInfoService;

@Service
public class CoindeskNewServiceImpl implements CoindeskNewService{
	
	@Autowired
	private CoindeskService coindeskService;
	
	@Autowired
	private CurrencyInfoService currencyInfoService;

	@Override
	public CoindeskNewDTO getData() {

		//取得原始資料
		Coindesk coindesk = coindeskService.getData();
		CoindeskBpiUsd bpiUsd = coindesk.getBpi().getUsd();
		CoindeskBpiGbp bpiGbp = coindesk.getBpi().getGbp();
		CoindeskBpiEur bpiEur = coindesk.getBpi().getEur();
		String datatimeStr = coindesk.getTime().getUpdatedISO().replace("-", "/").replace("T", " ").replace("+00:00", "");

		//取得幣值資料
		CurrencyInfoDTO currencyInfoDto = new CurrencyInfoDTO();
		String currencyCodeStr = bpiUsd.getCode() + "," + bpiGbp.getCode() + "," + bpiEur.getCode();
		currencyInfoDto.setCurrencyCode(currencyCodeStr);
		List<CurrencyInfoDTO> currencyInfoDtoList = currencyInfoService.getDataList(currencyInfoDto);
		
		
		
		//組成新的資料
		List<CoindeskNewBpiDTO> newBpiDtoList = new ArrayList<>();
		currencyInfoDtoList.forEach(item -> {
			if("USD".equals(item.getCurrencyCode())) {
				newBpiDtoList.add(new CoindeskNewBpiDTO(bpiUsd.getCode(),item.getCurrencyNameZh(),bpiUsd.getRate()));
			}
			
			if("GBP".equals(item.getCurrencyCode())) {
				newBpiDtoList.add(new CoindeskNewBpiDTO(bpiGbp.getCode(),item.getCurrencyNameZh(),bpiGbp.getRate()));
			}
			
			if("EUR".equals(item.getCurrencyCode())) {
				newBpiDtoList.add(new CoindeskNewBpiDTO(bpiEur.getCode(),item.getCurrencyNameZh(),bpiEur.getRate()));
			}
		});


		CoindeskNewDTO coindeskNewDto = new CoindeskNewDTO();
		coindeskNewDto.setCoindeskNewBpiDtoList(newBpiDtoList);
		coindeskNewDto.setDatatime(datatimeStr);
		return coindeskNewDto;
	}

}
