package com.koda.interview_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koda.interview_test.api.ICoindeskService;
import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.util.Util;

import retrofit2.Call;

@Service
public class CoindeskService {

	@Autowired
	private ICoindeskService iCoindeskService;
	
	public Coindesk getDataOrg() {
		Call<Coindesk> call = iCoindeskService.coindesk();
		Coindesk dataList = Util.callApi(call, "coindesk", Coindesk.class);
		return dataList;
	}
}
