package com.koda.interview_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koda.interview_test.model.vo.CoindeskNewVO;
import com.koda.interview_test.service.CoindeskNewService;

@RestController
@RequestMapping(value = "/coindesk_new")
public class CoindeskNewController {
	
	@Autowired
	private CoindeskNewService coindeskNewService;

	@GetMapping
	public CoindeskNewVO getData() {
		return coindeskNewService.getData().convertVo();
	}
}
