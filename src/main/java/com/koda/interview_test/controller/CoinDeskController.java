package com.koda.interview_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.service.impl.CoinDeskServiceImpl;

@RestController
@RequestMapping(value = "coin_desk")
public class CoinDeskController {
	
	@Autowired
	private CoinDeskServiceImpl coinDeskService;

	@RequestMapping(value = "/data_org",method = RequestMethod.GET)
	public Coindesk getDataOrg() {
		
		return coinDeskService.getDataOrg();
	}
}
