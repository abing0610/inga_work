package com.inga.ticket;

import java.awt.Image;
import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.ImageIcon;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

public class TicketMain {

	private static String username = "inga0610";
	private static String password = "nishishei0610";
	private static Map<String, String> cookieData;
	
	public static void main(String[] args) {
		Map<String, String> cookie = new HashMap<String, String>(); 
		HttpClient httpc = gethttpclient();
		cookie = initTicketHttp();
		
		File file = TicketService.buildLoginCodeImage(cookie);
		ImageIcon icon = new ImageIcon(file.getAbsolutePath());
		icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));
		
		String str = TicketService.loginAysnSuggest(username, password , cookie);
		
		System.out.println("!!!!!!!!!!!!");
		
		System.out.println(str);
		
//		String loginRand = TicketService.getAsynSuggest(username, password, null, cookie);
//		System.out.println(cookie.get("JSESSIONID"));
//		System.out.println(cookie.get("BIGipServerotn"));
//		System.out.println(loginRand);
		
	}
	public static Map<String, String> initTicketHttp(){
		HttpClient httpClient = gethttpclient();
		try {
			cookieData = new HashMap<String, String>();
			HttpResponse response = TicketService.getHttpRequest(httpClient, "https://kyfw.12306.cn/otn/login/init", null, null);
			// 获取消息头的信息
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
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		
		
	}
	
	public static HttpClient gethttpclient(){
		try {
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(sslcontext);
			ClientConnectionManager ccm = new DefaultHttpClient().getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));
			HttpParams params = new BasicHttpParams();
			params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 8000);
			params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 8000);
			HttpClient httpclient = new DefaultHttpClient(ccm, params);
			httpclient.getParams().setParameter(HTTP.USER_AGENT,
					"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
			return httpclient;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	private static X509TrustManager tm = new X509TrustManager() {
		public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	};
}
