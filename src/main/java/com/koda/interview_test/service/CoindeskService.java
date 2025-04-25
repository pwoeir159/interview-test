package com.koda.interview_test.service;

import org.springframework.stereotype.Service;

import com.koda.interview_test.api.model.Coindesk;

@Service
public interface CoindeskService {

	public Coindesk getData();
}
