package com.koda.interview_test.Integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CoindeskControllerTest {

	@Autowired
    private MockMvc mockMvc;  // 模擬 HTTP 請求的神器！
	
	@Test
    @DisplayName("取得 Coindesk 資料 - 成功")
    void testGetCoindeskData_success() throws Exception {
		String getResponse = mockMvc.perform(get("/coindesk"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.time").exists())
               .andExpect(jsonPath("$.disclaimer").exists())
               .andExpect(jsonPath("$.chartName").exists())
               .andExpect(jsonPath("$.bpi").exists())
               .andReturn()
               .getResponse()
               .getContentAsString();
        
        System.out.println("Get Response: " + getResponse);
    }
}
