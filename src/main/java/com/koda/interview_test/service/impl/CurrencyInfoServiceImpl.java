package com.koda.interview_test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.koda.interview_test.model.dto.CurrencyInfoDTO;
import com.koda.interview_test.model.po.CurrencyInfoPO;
import com.koda.interview_test.repository.CurrencyInfoRepository;
import com.koda.interview_test.service.CurrencyInfoService;
import com.koda.interview_test.util.Util;

@Service
public class CurrencyInfoServiceImpl implements CurrencyInfoService{
	
	private static final Logger logger = LoggerFactory.getLogger(CurrencyInfoServiceImpl.class);
	
	@Autowired
	private CurrencyInfoRepository repository;

	@Override
	public void postData(List<CurrencyInfoDTO> dtoList) {
		
		Optional<CurrencyInfoPO> optional;
		CurrencyInfoPO po;
		for(CurrencyInfoDTO dto : dtoList) {
			optional = repository.findById(dto.getCurrencyCode());
			
			if (optional.isPresent()) {
		        logger.error("failed bad request currency_code={} already exists.", dto.getCurrencyCode());
		        throw new RuntimeException("CurrencyCode already exists: " + dto.getCurrencyCode());
		    }
			
			po = Util.toVo(dto, new CurrencyInfoPO());
			repository.save(po);
		}
	}

	@Override
	public void deleteData(String keys) {
		Optional<CurrencyInfoPO> optional;
		for(String key : keys.split(",")) {
			optional = repository.findById(key);
			if (optional.isEmpty()) {
		        logger.error("failed bad request currency_code={} not found.", key);
		        throw new RuntimeException("CurrencyCode not found: " + key);
		    }
			repository.deleteById(key);
		}
	}

	@Override
	public void putData(List<CurrencyInfoDTO> dtoList) {
		
		Optional<CurrencyInfoPO> optional;
		CurrencyInfoPO po;
		
		for(CurrencyInfoDTO dto : dtoList) {
			
			optional = repository.findById(dto.getCurrencyCode());
			
			if (optional.isEmpty()) {
		        logger.error("failed bad request currency_code={} not found.", dto.getCurrencyCode());
		        throw new RuntimeException("CurrencyCode not found: " + dto.getCurrencyCode());
		    }
			
			po = optional.get();
			
			if (dto.getCurrencyNameZh() != null) {
			    po.setCurrencyNameZh(dto.getCurrencyNameZh());
			}
			
			if (dto.getDescription() != null) {
			    po.setDescription(dto.getDescription());
			}
			
			
			repository.save(po);
		}
	}

	@Override
	public List<CurrencyInfoDTO> getDataList(CurrencyInfoDTO dto) {
		
		List<CurrencyInfoPO> poList = this.getPoList(dto);
		if(poList == null || poList.isEmpty()) {
			new ArrayList<CurrencyInfoDTO>();
		}
		
		List<CurrencyInfoDTO> dtoList = poList.stream()
				.map(po -> Util.toVo(po, new CurrencyInfoDTO()))
				.collect(Collectors.toList());
		
		return dtoList;
	}

	@Override
	public CurrencyInfoDTO getData(CurrencyInfoDTO dto) {
		List<CurrencyInfoDTO> dtoList = this.getDataList(dto);
		if(!dtoList.isEmpty()) {
			return dtoList.get(0);
		}
		return null;
	}
	
	private List<CurrencyInfoPO> getPoList(CurrencyInfoDTO dto){
		
		Map<String,Object> paramNameMap = new HashMap<String,Object>();
		paramNameMap.put("currencyCode", dto.getCurrencyCode());
        paramNameMap.put("currencyNameZh", dto.getCurrencyNameZh());
        
        Specification<CurrencyInfoPO> spec = Util.addSpec(paramNameMap, null);
        Sort sort = Sort.by(Sort.Direction.DESC, "currencyCode");
        
        return repository.findAll(spec, sort);
	}

}
