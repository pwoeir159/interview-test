package com.koda.interview_test.service.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.api.model.CoindeskBpi;
import com.koda.interview_test.api.model.CoindeskBpiEur;
import com.koda.interview_test.api.model.CoindeskBpiGbp;
import com.koda.interview_test.api.model.CoindeskBpiUsd;
import com.koda.interview_test.api.model.CoindeskTime;
import com.koda.interview_test.model.dto.CoindeskNewBpiDTO;
import com.koda.interview_test.model.dto.CoindeskNewBpiEurDTO;
import com.koda.interview_test.model.dto.CoindeskNewBpiGbpDTO;
import com.koda.interview_test.model.dto.CoindeskNewBpiUsdDTO;
import com.koda.interview_test.model.dto.CoindeskNewDTO;
import com.koda.interview_test.model.dto.CoindeskNewTimeDTO;
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

		CoindeskNewDTO coindeskNewDto = new CoindeskNewDTO();
		coindeskNewDto.setCoindeskNewTimeDto(this.setNewTimeAndformat(coindesk.getTime()));
		coindeskNewDto.setCoindeskNewBpiDto(this.setNewBpi(coindesk.getBpi()));
		return coindeskNewDto;
	}

	@Override
	public CoindeskNewTimeDTO setNewTimeAndformat(CoindeskTime coindeskTime) {
		
        if (coindeskTime == null) {
            return new CoindeskNewTimeDTO();
        }
        
        // 定義三種解析格式
        DateTimeFormatter updatedFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm:ss z", Locale.ENGLISH);
        DateTimeFormatter updatedISOFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        DateTimeFormatter updatedukFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy 'at' HH:mm z", Locale.ENGLISH);

        // 最後要輸出的格式
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        ZonedDateTime zonedDateTime;
        //updated 格式
        zonedDateTime = ZonedDateTime.parse(coindeskTime.getUpdated(), updatedFormatter);
        String updated = outputFormatter.format(zonedDateTime);
        
        //ISO 格式
        zonedDateTime = ZonedDateTime.parse(coindeskTime.getUpdatedISO(), updatedISOFormatter);
        String updatedISO = outputFormatter.format(zonedDateTime);

        //updateduk 格式
        zonedDateTime = ZonedDateTime.parse(coindeskTime.getUpdateduk(), updatedukFormatter);
        String updateduk = outputFormatter.format(zonedDateTime);

        return new CoindeskNewTimeDTO(updated, updatedISO, updateduk);
    }
	
	@Override
	public CoindeskNewBpiDTO setNewBpi(CoindeskBpi coindeskBpi){
		
        if (coindeskBpi == null) {
            return new CoindeskNewBpiDTO();
        }
		
		//取得原始資料
		CoindeskBpiUsd bpiUsd = coindeskBpi.getUsd();
		CoindeskBpiGbp bpiGbp = coindeskBpi.getGbp();
		CoindeskBpiEur bpiEur = coindeskBpi.getEur();

		//取得幣值資料
		CurrencyInfoDTO currencyInfoDto = new CurrencyInfoDTO();
		String currencyCodeStr = bpiUsd.getCode() + "," + bpiGbp.getCode() + "," + bpiEur.getCode();
		currencyInfoDto.setCurrencyCode(currencyCodeStr);
		List<CurrencyInfoDTO> currencyInfoDtoList = currencyInfoService.getDataList(currencyInfoDto);
		
		//組成新的資料
		CoindeskNewBpiDTO coindeskNewBpiDto = new CoindeskNewBpiDTO();
		currencyInfoDtoList.forEach(item -> {
			if("USD".equals(item.getCurrencyCode())) {
				CoindeskNewBpiUsdDTO bpiDto = new CoindeskNewBpiUsdDTO();
				bpiDto.setCurrencyCode(bpiUsd.getCode());
				bpiDto.setCurrencyCodeZh(item.getCurrencyNameZh());
				bpiDto.setRate(bpiUsd.getRate());
				coindeskNewBpiDto.setCoindeskNewBpiUsdDto(bpiDto);
			}
			
			if("GBP".equals(item.getCurrencyCode())) {
				CoindeskNewBpiGbpDTO bpiDto = new CoindeskNewBpiGbpDTO();
				bpiDto.setCurrencyCode(bpiGbp.getCode());
				bpiDto.setCurrencyCodeZh(item.getCurrencyNameZh());
				bpiDto.setRate(bpiGbp.getRate());
				coindeskNewBpiDto.setCoindeskNewBpiGbpDto(bpiDto);
			}
			
			if("EUR".equals(item.getCurrencyCode())) {
				CoindeskNewBpiEurDTO bpiDto = new CoindeskNewBpiEurDTO();
				bpiDto.setCurrencyCode(bpiEur.getCode());
				bpiDto.setCurrencyCodeZh(item.getCurrencyNameZh());
				bpiDto.setRate(bpiEur.getRate());
				coindeskNewBpiDto.setCoindeskNewBpiEurDto(bpiDto);
			}
		});
		
		return coindeskNewBpiDto;
	}

}
