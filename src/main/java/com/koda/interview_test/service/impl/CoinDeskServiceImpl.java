package com.koda.interview_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koda.interview_test.api.ICoinDeskService;
import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.util.Util;

import retrofit2.Call;

@Service
public class CoinDeskServiceImpl {

	@Autowired
	private ICoinDeskService iCoinDeskService;
	
	public Coindesk getDataOrg() {
		Call<Coindesk> call = iCoinDeskService.coindesk();
		Coindesk dataList = Util.callApi(call, "coindesk", Coindesk.class);
		return dataList;
	}
}
