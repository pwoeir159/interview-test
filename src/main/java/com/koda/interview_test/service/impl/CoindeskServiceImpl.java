package com.koda.interview_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koda.interview_test.api.ICoindeskService;
import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.service.CoindeskService;
import com.koda.interview_test.util.Util;

import retrofit2.Call;

@Service
public class CoindeskServiceImpl implements CoindeskService{

	@Autowired
	private ICoindeskService iCoindeskService;
	
	@Override
	public Coindesk getData() {
		Call<Coindesk> call = iCoindeskService.coindesk();
		Coindesk data = Util.callApi(call, "coindesk", Coindesk.class);
		return data;
	}
}
