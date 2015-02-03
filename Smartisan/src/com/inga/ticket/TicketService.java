package com.inga.ticket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inga.ticket.comm.Constants;

public class TicketService {
	
	private static final Logger logger = LoggerFactory.getLogger(TicketService.class);
	
	public static String loginAysnSuggest(String loginUser, String loginPasswd, Map<String, String> cookieData) {
		HttpClient httpClient = TicketMain.gethttpclient();
		try {
			String responseHTML = postHttpRequestAsString(httpClient, "https://kyfw.12306.cn/otn/passcodeNew/checkRandCodeAnsyn", null,
					cookieData);
			
			System.out.println(responseHTML);
			
			//{"loginRand":"628","randError":"Y"}
			return StringUtils.substringBetween(responseHTML, "{\"loginRand\":\"", "\",\"randError\":\"Y\"}");
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	public static  File buildLoginCodeImage(Map<String, String> cookieData){
		
		HttpClient httpClient = TicketMain.gethttpclient();
		File file = new File(System.getProperty("user.dir") + File.separator + cookieData.get("JSESSIONID")
				+ ".login.jpg");
		try {
//			String url = "https://dynamic.12306.cn/otsweb/passCodeNewAction.do?module=login&rand=sjrand";
//			String url = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand";
			HttpResponse response = getHttpRequest(httpClient, Constants.RAND_CODE_URL, null, cookieData);
			HttpEntity entity = response.getEntity();
			InputStream instream = entity.getContent();
			OutputStream out = new FileOutputStream(file);
			byte[] tmp = new byte[1];
			while ((instream.read(tmp)) != -1) {
				out.write(tmp);
			}
			out.close();
			instream.close();
			return file;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	public static String getAsynSuggest(String loginUser, String loginPasswd, String loginCode,
			Map<String, String> cookieData){
		HttpClient httpClient = TicketMain.gethttpclient();
		
		String responseHTML = postHttpRequestAsString(httpClient, "https://kyfw.12306.cn/otn/login/loginAysnSuggest", null,
				cookieData);
		System.out.println(responseHTML);
		return StringUtils.substringBetween(responseHTML, "{\"loginRand\":\"", "\",\"randError\":\"Y\"}");
	}
	
	/**
	 * 返回POST请求响应字符串
	 * @param httpClient
	 * @param url
	 * @param parameters
	 * @param cookieData
	 * @return
	 */
	public static synchronized String postHttpRequestAsString(HttpClient httpClient, String url, List<NameValuePair> parameters,
			Map<String, String> cookieData) {
		try {
			HttpResponse response = postHttpRequest(httpClient, url, parameters, cookieData);
			HttpEntity entity = response.getEntity();
			String responseHTML = EntityUtils.toString(entity).trim();
			String message = null;
			if (responseHTML.length() > 300) {
				message = " + Response HTML(0-300):\n" + responseHTML.substring(0, 100);
			} else {
				message = " + Response HTML:\n" + responseHTML;
			}
			return responseHTML;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	/**
	 * POST请求
	 * @param httpclient
	 * @param url
	 * @param parameters
	 * @param cookieData
	 * @return
	 */
	public static synchronized HttpResponse postHttpRequest(HttpClient httpclient, String url, List<NameValuePair> parameters,
			Map<String, String> cookieData) {
		try {
			logger.debug("------------------------------------------------------------------------");
			logger.debug("POST URL: " + url);

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
			if (parameters != null) {
				UrlEncodedFormEntity uef = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
				post.setEntity(uef);
			}
			if (logger.isDebugEnabled()) {
				if (parameters != null) {
					logger.debug(" + Request parameters: ");

					for (NameValuePair param : parameters) {
						logger.debug("   - " + param.getName() + " : " + param.getValue());
					}
				}
				logger.debug(" + Request headers: ");
				for (Header header : post.getAllHeaders()) {
					logger.debug("   - " + header.getName() + " : " + header.getValue());
				}
			}
			HttpResponse response = httpclient.execute(post);
			if (logger.isDebugEnabled()) {
				logger.debug(" + Response headers: ");
				for (Header header : response.getAllHeaders()) {
					logger.debug("   - " + header.getName() + " : " + header.getValue());
				}
			}
			logger.debug("***********************************************************************");
			return response;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static synchronized HttpResponse  getHttpRequest(HttpClient httpClient, String url, List<NameValuePair> parameters,
			Map<String, String> cookieData) {
		// 创建GET请求
		try {
			logger.debug("------------------------------------------------------------------------");
			if (parameters != null && parameters.size() > 0) {
				String paramURL = URLEncodedUtils.format(parameters, HTTP.UTF_8);
				if (url.indexOf("?") > -1) {
					url = url + "&" + paramURL;
				} else {
					url = url + "?" + paramURL;
				}
			}

			logger.debug("GET URL: " + url);

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

			if (logger.isDebugEnabled()) {

				if (parameters != null) {
					logger.debug(" + Request parameters: ");

					for (NameValuePair param : parameters) {
						logger.debug("   - " + param.getName() + " : " + param.getValue());
					}
				}
				logger.debug(" + Request headers: ");
				for (Header header : get.getAllHeaders()) {
					logger.debug("   - " + header.getName() + " : " + header.getValue());
				}

			}

			HttpResponse response = httpClient.execute(get);
			if (logger.isDebugEnabled()) {
				logger.debug(" + Response headers: ");
				for (Header header : response.getAllHeaders()) {
					logger.debug("   - " + header.getName() + " : " + header.getValue());
				}
			}
			logger.debug("***********************************************************************");
			return response;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} 
	}

}
