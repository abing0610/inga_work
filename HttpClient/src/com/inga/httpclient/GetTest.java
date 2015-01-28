package com.inga.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class GetTest {
	
	//fastloginfield=email&username=1500811059@qq.com&password=&quickforward=yes&handlekey=ls
	private static Map<String, String> cookie = null; 
	private static final String FAST_LOGIN_FIELD = "fastloginfield";
	private static final String USER_NAME = "username";
	private static final String PASSWORD = "password";
	private static final String QUICK_FORWARD = "quickforward";
	private static final String HANDLE_KEY = "handlekey";
	//subject=test&message=work&formhash=4aa70927&usesig=1&posttime=1422430046
	private static final String SUBJECT="subject";
	private static final String MESSAGE = "message";
	private static final String FORMHASH = "formhash";
	private static final String USESIG = "usesig";
	private static final String POSTTIME = "posttime";
	
	public static HttpClient getClient(){
		HttpClient httpClient =new DefaultHttpClient();
		return httpClient;
	}
	
	/*
	 * 第一次获取页面中的信心，获取cookie文件
	 * 
	 */
	public static Map<String, String> initCookieMap() throws ClientProtocolException, IOException{
		Map<String, String> cookieData = new HashMap<String, String>();
		HttpClient httpClient = getClient();
		HttpGet get = new HttpGet("http://bbs.smartisan.cn/forum.php");
		get.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		
		HttpResponse response = httpClient.execute(get);
		
		Header[] headers = response.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			if (headers[i].getName().equals("Set-Cookie")) {
				String cookie = headers[i].getValue();
				String cookieName = cookie.split("=")[0];
				String cookieValue = cookie.split("=")[1].split(";")[0];
				cookieData.put(cookieName, cookieValue);
			}
		}
		
		return cookieData;
	}
	
	/*
	 * 登录网站
	 * 
	 */
	private static HttpResponse loginIndex() throws ParseException, IOException{
		HttpClient httpClient = getClient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair(FAST_LOGIN_FIELD, "email"));
		para.add(new BasicNameValuePair(USER_NAME, "1500811059@qq.com"));
		para.add(new BasicNameValuePair(PASSWORD, ""));
		para.add(new BasicNameValuePair(QUICK_FORWARD, "yes"));
		para.add(new BasicNameValuePair(HANDLE_KEY, "ls"));
		
		HttpPost post = new HttpPost("http://bbs.smartisan.cn/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1");
		post.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		
		UrlEncodedFormEntity uef = new UrlEncodedFormEntity(para, HTTP.UTF_8);
		post.setEntity(uef);
		
		HttpResponse response = httpClient.execute(post);
		
		return response;
	}
	
	/*
	 * 登录网站信息
	 * 查看是否登录成功
	 */
	private static HttpResponse getForumPHP(Map<String, String> cookieData) throws ClientProtocolException, IOException{
		HttpClient httpClient = getClient();
		HttpGet get = new HttpGet("http://bbs.smartisan.cn/forum.php");
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
	/*
	 * 发表帖子
	 */
	private static HttpResponse postMessageForum(Map<String, String> cookieData,String formH) throws ClientProtocolException, IOException{
		HttpClient httpClient = getClient();
		////subject=test&message=work&formhash=4aa70927&usesig=1&posttime=1422430046
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair(SUBJECT, "inga Hello!"));
		para.add(new BasicNameValuePair(MESSAGE, "hahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"));
		para.add(new BasicNameValuePair(FORMHASH, formH));
		para.add(new BasicNameValuePair(USESIG, "1"));
//		para.add(new BasicNameValuePair(POSTTIME, "1422432547"));
		
		HttpPost post = new HttpPost("http://bbs.smartisan.cn/forum.php?mod=post&action=newthread&fid=2&topicsubmit=yes&infloat=yes&handlekey=fastnewpost&inajax=1");
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
		
		UrlEncodedFormEntity uef = new UrlEncodedFormEntity(para, HTTP.UTF_8);
		post.setEntity(uef);
		
		HttpResponse response = httpClient.execute(post);
		
		return response;
	}
	
	/*
	 * 跳转页面
	 */
	private static HttpResponse humpToOtherPage(Map<String, String> cookieData) throws ClientProtocolException, IOException{
		
		HttpClient httpClient = getClient();
		HttpGet get = new HttpGet("http://bbs.smartisan.cn/forum.php");
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
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Map<String, String> cookieData = new HashMap<String, String>();
		HttpResponse resp = loginIndex();
		HttpEntity en = resp.getEntity();
		String responseHTML = EntityUtils.toString(en).trim();
		System.out.println(responseHTML);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		Header[] headers = resp.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			if (headers[i].getName().equals("Set-Cookie")) {
				String cookie = headers[i].getValue();
				String cookieName = cookie.split("=")[0];
				String cookieValue = cookie.split("=")[1].split(";")[0];
				cookieData.put(cookieName, cookieValue);
			}
		}
		
		
		HttpResponse respForumIndex =   getForumPHP(cookieData);
		HttpEntity entity = respForumIndex.getEntity();
		String respForum = EntityUtils.toString(entity).trim();
		System.out.println(respForum);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		//跳转到此页面
		HttpResponse rp = humpToOtherPage(cookieData);
		HttpEntity enrp = rp.getEntity();
		String rpHtml = EntityUtils.toString(enrp).trim();
		System.out.println(rpHtml);
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//发表帖子
		//  /forum.php?mod=post&action=newthread&fid=2&topicsubmit=yes&infloat=yes&handlekey=fastnewpost&inajax=1
		String formH = rpHtml.substring(rpHtml.indexOf("formhash") + 9, rpHtml.indexOf("formhash") + 17);
		
		System.out.println(formH);
		
		HttpResponse res = postMessageForum(cookieData,formH);
		
		HttpEntity entity2 = res.getEntity();
		String postStr = EntityUtils.toString(entity2).trim();
		System.out.println(postStr);
		
		
		
		
	}

}
