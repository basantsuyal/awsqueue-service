package com.service;

import org.springframework.stereotype.Service;

@Service("QueueService")
public interface QueueService {
    
    public void readqueueMessages();

}
