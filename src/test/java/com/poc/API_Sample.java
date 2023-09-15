package com.poc;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class API_Sample {

	
	public String[] sendRequest(String sUrl) {
		String results[]=null;
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = RequestBody.create(mediaType, "");
				Request request = new Request.Builder()
				  .url(sUrl)
				  .method("GET", body)
				  .build();
				try {
					Response response = client.newCall(request).execute();
					results[0] = ""+response.code();
					results[1] = response.toString();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				return results;
	}
	
	public static void main(String[] args) {
		
		API_Sample ap = new API_Sample();
		String whatEver[] = null;
		whatEver = ap.sendRequest("https://gorest.co.in/public/v2/users");
		
	}

}
