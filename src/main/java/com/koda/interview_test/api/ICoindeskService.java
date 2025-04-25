package com.koda.interview_test.api;

import com.koda.interview_test.api.model.Coindesk;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICoindeskService {

	@GET(value = "blog/coindesk.json")
	Call<Coindesk> coindesk();
}
