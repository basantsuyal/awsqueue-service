package com.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

@Component
public class AWSClient {

    @Value("${aws_access_key_id}")
    private String aws_access_key_id;

    @Value("${aws_secret_access_key}")
    private String aws_secret_access_key;

    @SuppressWarnings("deprecation")
    public AmazonSQS getAWSQueueClient() {
	BasicAWSCredentials credentials = new BasicAWSCredentials(aws_access_key_id, aws_secret_access_key);
	return new AmazonSQSClient(credentials);

    }
}
