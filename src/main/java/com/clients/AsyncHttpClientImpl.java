package com.clients;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.springframework.stereotype.Service;

@Service
public class AsyncHttpClientImpl {

	public void testAsyncHttpClient() {
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		try {
			// Start the client
			httpclient.start();
			// Execute request
			final HttpGet request1 = new HttpGet("http://www.google.com");
			Future<HttpResponse> future = httpclient.execute(request1, null);
			// and wait until response is received
			HttpResponse response1 = future.get();
			System.out.println(request1.getRequestLine() + "->" + response1.getStatusLine());

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
