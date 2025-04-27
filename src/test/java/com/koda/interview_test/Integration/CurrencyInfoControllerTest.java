package com.koda.interview_test.Integration;

import com.koda.interview_test.model.ApiResponse;
import com.koda.interview_test.model.vo.CurrencyInfoVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyInfoControllerTest {
	
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    @DisplayName("CurrencyInfo API CRUD 測試 - 創建、查詢、更新、刪除")
    void testCurrencyInfoCRUD() throws Exception {
        // Create
    	List<CurrencyInfoVO> voList = new ArrayList<>();
    	CurrencyInfoVO vo = new CurrencyInfoVO();
    	String currencyCode = "TWD";
    	vo.setCurrencyCode(currencyCode);
    	vo.setCurrencyNameZh("新臺幣");
    	vo.setDescription("New Taiwan Dollar");
    	voList.add(vo);
        String jsonRequest = objectMapper.writeValueAsString(voList);

        String createResponse = mockMvc.perform(post("/currency-info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("Create Response: " + createResponse);

        ApiResponse<List<CurrencyInfoVO>> apiResponse = objectMapper.readValue(createResponse, 
        		new TypeReference<ApiResponse<List<CurrencyInfoVO>>>() {});
        List<CurrencyInfoVO> dataList = apiResponse.getData();
        CurrencyInfoVO createdCurrency = dataList.get(0);
      
        // Read
        String readResponse = mockMvc.perform(get("/currency-info/"+currencyCode))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("ok"))
                .andExpect(jsonPath("$.data.currency_code").value("TWD"))
                .andExpect(jsonPath("$.data.description").value("New Taiwan Dollar"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("Read Response: " + readResponse);
        
        // Read All
        String readAllResponse = mockMvc.perform(get("/currency-info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("ok"))
                .andExpect(jsonPath("$.data").isNotEmpty())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("Read All Response: " + readAllResponse);

        // Update
        voList.clear();
        createdCurrency.setDescription("Taiwan Dollar");
        voList.add(createdCurrency);
        String updateRequest = objectMapper.writeValueAsString(voList);

        String updateResponse = mockMvc.perform(put("/currency-info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("ok"))
                .andExpect(jsonPath("$.data[0].description").value("Taiwan Dollar"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("Update Response: " + updateResponse);
        
        // Update All
        voList.clear();
        createdCurrency.setDescription("Taiwan Dollar");
        voList.add(createdCurrency);
        createdCurrency = new CurrencyInfoVO();
        createdCurrency.setCurrencyCode("USD");
        createdCurrency.setCurrencyNameZh("美元");
        voList.add(createdCurrency);
        String updateAllRequest = objectMapper.writeValueAsString(voList);

        String updateAllResponse = mockMvc.perform(put("/currency-info")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateAllRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("ok"))
                .andExpect(jsonPath("$.data[0].description").value("Taiwan Dollar"))
                .andExpect(jsonPath("$.data[1].currency_name_zh").value("美元"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println("Update All Response: " + updateAllResponse);
        
        // Delete
        mockMvc.perform(delete("/currency-info/" + currencyCode))
                .andExpect(status().isOk());

        // Confirm Delete
        mockMvc.perform(get("/currency-info/" + currencyCode))
                .andExpect(status().isInternalServerError());
    }
}
