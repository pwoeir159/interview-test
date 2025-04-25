package com.koda.interview_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.koda.interview_test.model.po.CurrencyInfoPO;

public interface CurrencyInfoRepository extends JpaRepository<CurrencyInfoPO, String>,
	JpaSpecificationExecutor<CurrencyInfoPO>{

}
