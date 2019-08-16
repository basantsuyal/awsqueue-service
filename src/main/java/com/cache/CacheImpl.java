package com.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheImpl {

	@Value("${propertyValue}")
	private String propertyValue;

	private String testCacheValue = null;

	public void getCachedData() {
		{
			try {
				System.out.println("getCached Value : " + getCachedValue());
				Thread.sleep(1000 * 5);
				System.out.println("Going to sleep for 5 Secs.. to clear the cache");
				System.out.println("clear cached value with : " + evictCachedValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Cacheable(value = "propertyValue")
	public String getCachedValue() {
		if (null == testCacheValue) {
			return propertyValue;
		} else {
			testCacheValue = propertyValue;
		}
		return null;
	}

	@CacheEvict(value = "propertyValue", allEntries = true)
	public String evictCachedValue() {
		if (null == testCacheValue) {
			return testCacheValue;
		}
		return null;

	}
}
