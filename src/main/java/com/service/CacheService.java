package com.service;

import org.springframework.stereotype.Service;

@Service("CacheService")
public interface CacheService {

	public void getCachedData();
}
