package com.koda.interview_test.service;

import org.springframework.stereotype.Service;

import com.koda.interview_test.api.model.CoindeskBpi;
import com.koda.interview_test.api.model.CoindeskTime;
import com.koda.interview_test.model.dto.CoindeskNewBpiDTO;
import com.koda.interview_test.model.dto.CoindeskNewDTO;
import com.koda.interview_test.model.dto.CoindeskNewTimeDTO;

@Service
public interface CoindeskNewService {

	public CoindeskNewDTO getData();
	
	public CoindeskNewTimeDTO setNewTimeAndformat(CoindeskTime coindeskTime);
	
	public CoindeskNewBpiDTO setNewBpi(CoindeskBpi coindeskBpi);
}
