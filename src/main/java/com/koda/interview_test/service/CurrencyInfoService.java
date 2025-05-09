package com.koda.interview_test.service;

import java.util.List;

import com.koda.interview_test.model.dto.CurrencyInfoDTO;

public interface CurrencyInfoService {

    public void postData(List<CurrencyInfoDTO> dtoList);
    
    public void deleteData(String keys);
    
    public void putData(List<CurrencyInfoDTO> dtoList);
    
    public List<CurrencyInfoDTO> getDataList(CurrencyInfoDTO dto);
    
    public CurrencyInfoDTO getData(CurrencyInfoDTO dto);
}
