package com.inga.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;

import com.inga.httpclient.GetTest;

public class RequestHttpService {

	public HttpResponse getHttpRequest(String url,Map<String, String> cookieData) throws ClientProtocolException, IOException{
		
		HttpClient httpClient  = GetTest.getClient();
		HttpGet get = new HttpGet(url);
		get.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		
		if (cookieData != null) {
			boolean first = true;
			StringBuilder cookie = new StringBuilder();
			for (Map.Entry<String, String> me : cookieData.entrySet()) {
				if (first) {
					first = false;
				} else {
					cookie.append(";");
				}
				cookie.append(me.getKey() + "=" + me.getValue());
			}
			get.setHeader("Cookie", cookie.toString());
		}
		
		HttpResponse response = httpClient.execute(get);
		
		return response;
	}
	
	public HttpResponse postHttpRequest(String url,Map<String, String> cookieData,List<NameValuePair> para) throws ClientProtocolException, IOException{
		HttpClient httpClient  = GetTest.getClient();
		
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		if (cookieData != null) {
			boolean first = true;
			StringBuilder cookie = new StringBuilder();
			for (Map.Entry<String, String> me : cookieData.entrySet()) {
				if (first) {
					first = false;
				} else {
					cookie.append(";");
				}
				cookie.append(me.getKey() + "=" + me.getValue());
			}
			post.setHeader("Cookie", cookie.toString());
		}
		if (para != null) {
			UrlEncodedFormEntity uef = new UrlEncodedFormEntity(para, HTTP.UTF_8);
			post.setEntity(uef);
		}
		
		HttpResponse response = httpClient.execute(post);
		
		return response;
	}
}
