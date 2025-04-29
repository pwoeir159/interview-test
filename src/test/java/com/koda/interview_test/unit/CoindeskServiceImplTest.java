package com.koda.interview_test.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.koda.interview_test.api.ICoindeskService;
import com.koda.interview_test.api.model.Coindesk;
import com.koda.interview_test.util.Util;

import retrofit2.Call;

@SpringBootTest
public class CoindeskServiceImplTest {

	@Autowired
	private ICoindeskService iCoindeskService;
	
	@Test
	@DisplayName("call https://kengp3.github.io/blog/coindesk.json - should success and not null")
	void call_coindesk_success() {
		Call<Coindesk> call = iCoindeskService.coindesk();
		Coindesk data = Util.callApi(call, "coindesk", Coindesk.class);
		assertThat(data).isNotNull();
	}
}
