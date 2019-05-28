package com.concretepage.aspects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

		//implementing RESTful service with Apache HTTP Client
public class RESTWithApacheHTTPClient {
	public static void main(String args[]) {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			HttpGet getRequest= new HttpGet("http://localhost:9999/spring-app/person/details");
			getRequest.addHeader("accept","application/json");
			HttpResponse response = httpClient.execute(getRequest);
			
			if(response.getStatusLine().getStatusCode() !=200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			
			BufferedReader br= new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("\n=======output=======\n");
			while((output=br.readLine())!=null) {
				System.out.println(output);
			}
		}
		
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
