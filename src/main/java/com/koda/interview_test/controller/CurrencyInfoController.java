package com.koda.interview_test.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koda.interview_test.model.dto.CurrencyInfoDTO;
import com.koda.interview_test.model.vo.CurrencyInfoVO;
import com.koda.interview_test.service.CurrencyInfoService;
import com.koda.interview_test.model.ApiResponse;
import com.koda.interview_test.util.Util;

@RestController
@RequestMapping("/currency-info")
public class CurrencyInfoController {

	@Autowired
	private CurrencyInfoService currencyInfoService;
	
	@PostMapping
	public ResponseEntity<Object> postCurrencyInfo(@RequestBody List<CurrencyInfoVO> voList) {
		
		try {
			List<CurrencyInfoDTO> dtoList = voList.stream()
					.map(vo -> Util.toVo(vo, new CurrencyInfoDTO()))
					.collect(Collectors.toList());
			
			currencyInfoService.postData(dtoList);
			ApiResponse<Object> apiResponse = this.setOkResponse(voList);
			return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		} catch (Exception e) {
			ApiResponse<Object> apiResponse = this.setInternalServerResponse(e, voList);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
		}
	}
	
	@DeleteMapping("/{keys}")
	public ResponseEntity<Object> deleteCurrencyInfo(@PathVariable String keys) {
		
		try {
			currencyInfoService.deleteData(keys);
			ApiResponse<Object> apiResponse = this.setOkResponse(keys);
			return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		} catch (Exception e) {
			ApiResponse<Object> apiResponse = this.setInternalServerResponse(e, keys);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> putCurrencyInfo(@RequestBody List<CurrencyInfoVO> voList) {
		
		try {
			List<CurrencyInfoDTO> dtoList = voList.stream()
					.map(vo -> Util.toVo(vo, new CurrencyInfoDTO()))
					.collect(Collectors.toList());
			
			currencyInfoService.putData(dtoList);
			ApiResponse<Object> apiResponse = this.setOkResponse(voList);
			return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		} catch (Exception e) {
			ApiResponse<Object> apiResponse = this.setInternalServerResponse(e, voList);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> getListCurrencyInfo(
			@RequestParam(value = "currency_code",required = false) String currency_code,
			@RequestParam(value = "currency_name_zh",required = false) String currency_name_zh) {
		
		try {
			List<CurrencyInfoVO> voList = 
					currencyInfoService.getDataList(new CurrencyInfoDTO(currency_code, currency_name_zh)).stream()
					.map(dto -> Util.toVo(dto, new CurrencyInfoVO()))
					.collect(Collectors.toList());
			ApiResponse<Object> apiResponse = this.setOkResponse(voList);
			return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		} catch (Exception e) {
			ApiResponse<Object> apiResponse = this.setInternalServerResponse(e, new CurrencyInfoDTO(currency_code, currency_name_zh));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
		}
	}
	
	@GetMapping(value = "/{currency_code}")
	public ResponseEntity<Object> getCurrencyInfo(@PathVariable String currency_code) {
		
		try {
			CurrencyInfoVO vo = Util.toVo(currencyInfoService.getData(new CurrencyInfoDTO(currency_code, null)),
					new CurrencyInfoVO());
			ApiResponse<Object> apiResponse = this.setOkResponse(vo);
			return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
		} catch (Exception e) {
			ApiResponse<Object> apiResponse = this.setInternalServerResponse(e, new CurrencyInfoDTO(currency_code, null));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
		}
	}
	
//  ----------------------------------------------共用方法
    private ApiResponse<Object> setOkResponse(Object obj) {
        return new ApiResponse<Object>(
                Util.localDateTimeToString(LocalDateTime.now()),
                true,200,"ok",obj);
    }
    
    private ApiResponse<Object> setInternalServerResponse(Exception e, Object obj) {
        return new ApiResponse<Object>(
                Util.localDateTimeToString(LocalDateTime.now()),
                false, 500, e.getMessage(), obj);
    }
}
