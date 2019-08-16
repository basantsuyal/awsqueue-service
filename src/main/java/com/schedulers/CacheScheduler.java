package com.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cache.CacheImpl;

@Service
public class CacheScheduler {
	
	@Autowired
	CacheImpl cacheServiceImpl;

	//@Scheduled(cron = "0 * * * * ?")
	public void runFirstScheduler() {
		System.out.println("***************************************");
		System.out.println("Initiating CacheService!");
		cacheServiceImpl.getCachedData();
		System.out.println("***************************************");
	}
}
