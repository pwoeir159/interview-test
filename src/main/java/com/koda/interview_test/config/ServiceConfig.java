package com.koda.interview_test.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "koda.interview-test")
@Configuration
public class ServiceConfig {

	private String apiKengp3RootUrl;

	public String getApiKengp3RootUrl() {
		return apiKengp3RootUrl;
	}

	public void setApiKengp3RootUrl(String apiKengp3RootUrl) {
		this.apiKengp3RootUrl = apiKengp3RootUrl;
	}
}
