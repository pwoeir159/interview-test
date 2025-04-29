package com.koda.interview_test.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.koda.interview_test.api.model.CoindeskBpi;
import com.koda.interview_test.api.model.CoindeskBpiEur;
import com.koda.interview_test.api.model.CoindeskBpiGbp;
import com.koda.interview_test.api.model.CoindeskBpiUsd;
import com.koda.interview_test.api.model.CoindeskTime;
import com.koda.interview_test.model.dto.CoindeskNewBpiDTO;
import com.koda.interview_test.model.dto.CoindeskNewTimeDTO;
import com.koda.interview_test.service.impl.CoindeskNewServiceImpl;

public class CoindeskNewServiceImplTest {
	
    private CoindeskNewServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CoindeskNewServiceImpl();
    }
	
	@Test
	void testSetNewTimeAndformat() {
		CoindeskTime coindeskTime = new CoindeskTime();
		CoindeskNewTimeDTO coindeskNewTimeDto;
		coindeskTime.setUpdated("Sep 2, 2024 07:07:20 UTC");
		coindeskTime.setUpdatedISO("2024-09-02T07:07:20+00:00");
		coindeskTime.setUpdateduk("Sep 2, 2024 at 08:07 BST");
		coindeskNewTimeDto = service.setNewTimeAndformat(coindeskTime);
		System.out.println("CoindeskNewTimeDTO:" + coindeskNewTimeDto.toString());
		assertThat(coindeskNewTimeDto.getUpdated()).isEqualTo("2024/09/02 07:07:20");
		assertThat(coindeskNewTimeDto.getUpdatedISO()).isEqualTo("2024/09/02 07:07:20");
		assertThat(coindeskNewTimeDto.getUpdateduk()).isEqualTo("2024/09/02 08:07:00");
	}
	
	@Test
	void testSetNewBpi() {
		CoindeskBpi coindeskBpi = new CoindeskBpi();
		coindeskBpi.setUsd(new CoindeskBpiUsd("USD", "&#36;", "57,756.298", "United States Dollar", 57756.2984));
		coindeskBpi.setGbp(new CoindeskBpiGbp("GBP", "&pound;", "43,984.02", "British Pound Sterling", 43984.0203));
		coindeskBpi.setEur(new CoindeskBpiEur("EUR", "&euro;", "52,243.287", "Euro", 52243.2865));
		
		CoindeskNewBpiDTO coindeskNewBpiDto = service.setNewBpi(coindeskBpi);
		System.out.println("CoindeskNewBpiDTO:" + coindeskNewBpiDto.toString());
		assertThat(coindeskNewBpiDto.getCoindeskNewBpiUsdDto().getCurrencyCode()).isEqualTo("USD");
		assertThat(coindeskNewBpiDto.getCoindeskNewBpiGbpDto().getCurrencyCodeZh()).isEqualTo("英鎊");
		assertThat(coindeskNewBpiDto.getCoindeskNewBpiEurDto().getRate()).isEqualTo("52,243.287");
		
	}
}
