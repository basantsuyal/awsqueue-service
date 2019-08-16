package com.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.QueueService;

@Component
public class AWSQueueScheduler {

    @Autowired
    QueueService queueService;

	@Scheduled(cron = "0 * * * * ?")
	public void runAWSQueueScheduler() {
		System.out.println("***************************************");
		System.out.println("Start reading messages from AWS queue!");
		queueService.readqueueMessages();
		System.out.println("***************************************");
	}

}
