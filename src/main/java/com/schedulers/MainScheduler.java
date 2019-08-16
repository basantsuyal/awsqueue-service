package com.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MainScheduler {

	//@Scheduled(cron = "0 * * * * ?")
	public void runFirstScheduler() {
		System.out.println("***************************************");
		System.out.println("This is my first Git project!");
		System.out.println("***************************************");
	}
}
