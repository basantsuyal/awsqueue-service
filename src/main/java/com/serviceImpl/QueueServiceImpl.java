package com.serviceImpl;

import java.util.List;
import java.util.Map.Entry;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.clients.AWSClient;
import com.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {

    @Value("${AWS_QUEUE_URL}")
    private String AWS_QUEUE_URL;

    @Autowired
    AWSClient awsClient;

    Logger logger = Logger.getLogger(QueueServiceImpl.class);

    @Override
    public void readqueueMessages() {
	ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(AWS_QUEUE_URL);
	List<Message> messages = awsClient.getAWSQueueClient().receiveMessage(receiveMessageRequest).getMessages();

	for (Message message : messages) {
	    System.out.println("  Message");
	    System.out.println("    MessageId:     " + message.getMessageId());
	    System.out.println("    ReceiptHandle: " + message.getReceiptHandle());
	    System.out.println("    MD5OfBody:     " + message.getMD5OfBody());
	    System.out.println("    Body:          " + message.getBody());
	    for (Entry<String, String> entry : message.getAttributes().entrySet()) {
		System.out.println("  Attribute");
		System.out.println("    Name:  " + entry.getKey());
		System.out.println("    Value: " + entry.getValue());
	    }
	}

    }

}
