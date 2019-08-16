package com.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.clients.AsyncHttpClientImpl;

@Service
public class RunHttpAsyncClient {

	@Autowired
	AsyncHttpClientImpl asyncHttpClientImpl;
	
	
	//@Scheduled(cron = "0 * * * * ?")
	public void runFirstScheduler() {
		System.out.println("***************************************");
		System.out.println("Initiating HttpAsyncClient");
		asyncHttpClientImpl.testAsyncHttpClient();
		System.out.println("***************************************");
	}

}
