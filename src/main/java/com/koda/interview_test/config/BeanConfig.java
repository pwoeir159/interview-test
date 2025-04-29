package com.koda.interview_test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.koda.interview_test.api.ICoindeskService;
import com.koda.interview_test.util.RetrofitFactory;


@Configuration
public class BeanConfig {
    
    @Autowired
    private ServiceConfig serviceConfig;
    
    @Bean
    public ICoindeskService iFloodService() {
        return RetrofitFactory.createService(ICoindeskService.class, serviceConfig.getApiKengp3RootUrl());   
    } 
	
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		return threadPoolTaskScheduler;	
	} 

}
