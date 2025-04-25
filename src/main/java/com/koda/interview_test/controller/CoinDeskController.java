package com.koda.interview_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.service.CoinDeskService;

@RestController
@RequestMapping(value = "coin_desk")
public class CoinDeskController {
	
	@Autowired
	private CoinDeskService coinDeskService;

	@GetMapping(value = "/data_org")
	public Coindesk getDataOrg() {
		return coinDeskService.getDataOrg();
	}
}
