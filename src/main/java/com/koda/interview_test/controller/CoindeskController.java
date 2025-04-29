package com.koda.interview_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.service.impl.CoindeskServiceImpl;

@RestController
@RequestMapping(value = "/coindesk")
public class CoindeskController {
	
	@Autowired
	private CoindeskServiceImpl coindeskService;

	@GetMapping
	public Coindesk getData() {
		return coindeskService.getData();
	}
}
