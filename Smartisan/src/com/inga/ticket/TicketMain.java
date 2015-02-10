package com.inga.ticket;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.xml.ws.Response;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.inga.ticket.comm.Constants;
import com.inga.ticket.comm.JSONClass;

public class TicketMain {

	private static String username = "";
	private static String password = "";
	private static Map<String, String> cookieData;
	private static final Pattern PATTERN_DYNAMIC_JS = Pattern.compile("/otn/dynamicJs/(\\w+)");
	private static final Pattern PATTERN_LOGIN_KEY = Pattern.compile("var key='(\\w+)'");
	private static String responseQueryTTTTT="";
	public static final String FROM_DATE="2015-02-21";
	public static final String TO_DATE="2015-02-09";
	
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ScriptException, NoSuchMethodException {
		Map<String, String> cookie = new HashMap<String, String>(); 
		HttpClient httpc = gethttpclient();
		//获取12306网站的cookie数据
		cookie = initTicketHttp();
		String jsurl = cookie.get("jsurl");
		HttpResponse re = TicketService.getHttpRequest(httpc, jsurl, null, cookie);
		
		//获取登录的随机码kkky
		String strScr = EntityUtils.toString(re.getEntity(), "GBK");
		int ri1 = strScr.indexOf("var key='");
		strScr = strScr.substring(ri1,strScr.length());
		int ri2 = strScr.indexOf("';");
		String kkky = strScr.substring(9,ri2);
		String vvvy = "1111";
		
		//获取登录的随机验证码vvvy
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		String mygc = "function kkv(){return encode32(bin216(Base32.encrypt('"+vvvy+"', '"+kkky+"')));}function bin216(s){var i,l,o=\"\",n;s+=\"\";b=\"\";for(i=0,l=s.length;i<l;i++){b=s.charCodeAt(i);n=b.toString(16);o+=n.length<2?\"0\"+n:n}return o};var Base32=new function(){var delta=0x9E3779B8;function longArrayToString(data,includeLength){var length=data.length;var n=(length-1)<<2;if(includeLength){var m=data[length-1];if((m<n-3)||(m>n))return null;n=m}for(var i=0;i<length;i++){data[i]=String.fromCharCode(data[i]&0xff,data[i]>>>8&0xff,data[i]>>>16&0xff,data[i]>>>24&0xff)}if(includeLength){return data.join('').substring(0,n)}else{return data.join('')}};function stringToLongArray(string,includeLength){var length=string.length;var result=[];for(var i=0;i<length;i+=4){result[i>>2]=string.charCodeAt(i)|string.charCodeAt(i+1)<<8|string.charCodeAt(i+2)<<16|string.charCodeAt(i+3)<<24}if(includeLength){result[result.length]=length}return result};this.encrypt=function(string,key){if(string==\"\"){return\"\"}var v=stringToLongArray(string,true);var k=stringToLongArray(key,false);if(k.length<4){k.length=4}var n=v.length-1;var z=v[n],y=v[0];var mx,e,p,q=Math.floor(6+52/(n+1)),sum=0;while(0<q--){sum=sum+delta&0xffffffff;e=sum>>>2&3;for(p=0;p<n;p++){y=v[p+1];mx=(z>>>5^y<<2)+(y>>>3^z<<4)^(sum^y)+(k[p&3^e]^z);z=v[p]=v[p]+mx&0xffffffff}y=v[0];mx=(z>>>5^y<<2)+(y>>>3^z<<4)^(sum^y)+(k[p&3^e]^z);z=v[n]=v[n]+mx&0xffffffff}return longArrayToString(v,false)}};var keyStr=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\";function encode32(input){input=escape(input);var output=\"\";var chr1,chr2,chr3=\"\";var enc1,enc2,enc3,enc4=\"\";var i=0;do{chr1=input.charCodeAt(i++);chr2=input.charCodeAt(i++);chr3=input.charCodeAt(i++);enc1=chr1>>2;enc2=((chr1&3)<<4)|(chr2>>4);enc3=((chr2&15)<<2)|(chr3>>6);enc4=chr3&63;if(isNaN(chr2)){enc3=enc4=64}else if(isNaN(chr3)){enc4=64}output=output+keyStr.charAt(enc1)+keyStr.charAt(enc2)+keyStr.charAt(enc3)+keyStr.charAt(enc4);chr1=chr2=chr3=\"\";enc1=enc2=enc3=enc4=\"\"}while(i<input.length);return output};";
		engine.eval(mygc);
		if (engine instanceof Invocable) {
			Invocable invoke = (Invocable) engine;
			String gcKeyValue = invoke.invokeFunction("kkv", null).toString();
			vvvy = gcKeyValue;
		}
		System.out.println(" ######    kkky  : " + kkky + "  : ################   vvvy   : " + vvvy);
		
		cookie.remove("jsurl");
		//把登录的验证码的图片下载到本地，需要自己查看验证码
		File file = TicketService.buildLoginCodeImage(cookie);
		ImageIcon icon = new ImageIcon(file.getAbsolutePath());
		icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));
	
		//读取在控制台输入的验证码
		String randCode;
		Scanner sc = new Scanner(System.in);
		randCode = sc.nextLine();
		randCode = randCode.toUpperCase();
		
		TicketMain tickMain = new TicketMain();
		//检查验证码
		String checkRandStr = tickMain.checkRandCode(cookie,randCode);
		JSONClass jn = new JSONClass();
		List<Map<String, Object>> list =jn.jsonToMap(checkRandStr);
		String result = "";
		for (Map<String, Object> map : list) {
			Map<String, String> maa =  (Map<String, String>) map.get("data");
			result = maa.get("result");
		}
		if (result.equals("1")) {
			System.out.println("验证码  ：  验证通过");
		}else{
			System.out.println("验证码  ： 验证没有通过");
			return;
		}
		
		//登录网站
		loginAsynTT(cookie, randCode,kkky,vvvy);
		//登录成功以后，需要用ajax传一下数据给12306网站
		HttpResponse hr = userLoginTT(cookie);
		
		//登录以后，类似于跳转到主页面的程序
//		cookie = initMyTT(cookie);
		initMyTT(cookie);
		
		cookie = SetTicketCookie.getCookie(cookie);
		
		ReserveTicketMain res = new ReserveTicketMain();
		//预订车票
		HttpResponse respTickInit = res.toIndexReserverPage(cookie);
		HttpEntity enTickInit = respTickInit.getEntity();
		String responseHTMLTickInit = EntityUtils.toString(enTickInit).trim();
		System.out.println(responseHTMLTickInit);
		String dynalJS = responseHTMLTickInit.substring(responseHTMLTickInit.indexOf("<script src=\"/otn/dynamicJs/")+28, responseHTMLTickInit.indexOf("<script src=\"/otn/dynamicJs/")+35);
		System.out.println(dynalJS);
		
		String responseQueryT = dealQueryOrder(cookie, res);
		
		//{"validateMessagesShowId":"_validatorMessage","status":true,"httpstatus":200,"messages":[],"validateMessages":{}}
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		//处理listMap的东西 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println( "responseQueryT  : " + responseQueryT);
		listMap = dealListMap(res, responseQueryT);
		
		
		String secretSTR = "";
		//查看车次否能够预订，显示能够预订的车次
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		secretSTR = getSecretStr(listMap);
		if (!secretSTR.equals("") && !secretSTR.equalsIgnoreCase(null)) {
			//取得订单的key
			String orderKey = "";
			String orderKeyValue = "";
			orderKey = getOrderKey(cookie,dynalJS);
			
			orderKeyValue = getOrderKeyValue(orderKey);
			
			System.out.println("---------------orderKey : " + orderKey + "  ---   orderKeyValue : " + orderKeyValue +"---------");
			
			// checkUser
			checkUser(cookie);
						
			//选定车次，跳转到预订页面 submitOrderRequest
			jumpToOrderTicket(orderKey,orderKeyValue,secretSTR,cookie);
			
			//	confirmPassenger/initD
			initOrderPage(cookie);
			
			//getPasssengerDTOs
			getPasssengerDTOs(cookie);
			
//			OrderPageThread.dealMain(cookie);
			
		}
		
	}

	private static List<Map<String, Object>> dealListMap(ReserveTicketMain res,
			String responseQueryT) throws InterruptedException {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		listMap = (List<Map<String, Object>>) res.dealJsonData(responseQueryT);
		
		for(Map<String, Object> map : listMap){
			if (map.get("data") ==  null || map.get("data").equals(null)) {
				dealListMap(res, responseQueryT);
			}
		}
		
		
		return listMap;
	}
	
	public static String checkUser(Map<String,String> cookie) throws ParseException, IOException{
		HttpClient htp = gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair("_json_att", ""));
		
		HttpResponse respTickssss = TicketService.postHttpRequest(htp, Constants.CHECK_USER, para, cookie);
		HttpEntity en = respTickssss.getEntity();
		String str = EntityUtils.toString(en).trim();
		
		System.out.println(str);
		
		return str;
	}
	
	public static String getPasssengerDTOs(Map<String,String> cookie) throws ParseException, IOException{
		HttpClient htp = gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair("_json_att", ""));
		
		HttpResponse respTickssss = TicketService.postHttpRequest(htp, Constants.GET_PASSENGER_DTOS, para, cookie);
		HttpEntity en = respTickssss.getEntity();
		String str = EntityUtils.toString(en).trim();
		
		Header[] a = respTickssss.getAllHeaders();
		System.out.println(str);
		
		return str;
	}

	public static synchronized String dealQueryOrder(Map<String, String> cookie,
			ReserveTicketMain res) throws IOException, InterruptedException {
		// /otn/leftTicket/log?leftTicketDTO.train_date=2015-02-03&leftTicketDTO.from_station=JNK&leftTicketDTO.to_station=WFK&purpose_codes=ADULT 
		HttpResponse resLog = res.leftTickeLog(cookie);
		HttpEntity enLog = resLog.getEntity();
		String resLOG = EntityUtils.toString(enLog).trim();
		Header[] aa = resLog.getAllHeaders();
		TimeUnit.MILLISECONDS.sleep(100);
		//	/otn/leftTicket/queryT?leftTicketDTO.train_date=2015-02-03&leftTicketDTO.from_station=JNK&leftTicketDTO.to_station=WFK&purpose_codes=ADULT	
		HttpResponse respQueryT = res.leftTickeQueryT(cookie);
		HttpEntity enQueryT = respQueryT.getEntity();
		responseQueryTTTTT= EntityUtils.toString(enQueryT).trim();
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		if (responseQueryTTTTT.indexOf("data") > 0) {
			System.out.println( "data  :  " +  responseQueryTTTTT);
			return responseQueryTTTTT;
		}else {
			dealQueryOrder(cookie, res);
		}
		
		System.out.println( "last  :  " +  responseQueryTTTTT);
		return responseQueryTTTTT;
	}
	
	public static String initOrderPage(Map<String, String> cookie) throws ParseException, IOException{
		HttpClient htp = gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair("_json_att", ""));
		cookie.put("current_captcha_type", "C");
		
		HttpResponse respTickssss = TicketService.postHttpRequest(htp, Constants.CONFIRM_PASSENGER_INITDC, para, cookie);
		HttpEntity en = respTickssss.getEntity();
		String respHtml = EntityUtils.toString(en).trim();
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(respHtml);
		return respHtml;
	}

	public static String submitStr ="";
	//NDIwMzcw=ODEyMDQ1M2ZkZDVmYzg1Nw%3D%3D&myversion=undefined&secretStr=sss&train_date=2015-02-21&back_train_date=2015-02-04&tour_flag=dc&purpose_codes=ADULT&query_from_station_name=济南&query_to_station_name=潍坊&undefined
	public static String jumpToOrderTicket(String orderKey,String orderKeyValue,String secretSTR,Map<String, String> cookie) throws ParseException, IOException{
		HttpClient htp = gethttpclient();
		cookie.put("current_captcha_type", "C");
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair(orderKey, orderKeyValue));
		para.add(new BasicNameValuePair(Constants.MY_VERSION, Constants.UN_DEFINE));
		para.add(new BasicNameValuePair(Constants.SECRET_STR, secretSTR));
		para.add(new BasicNameValuePair(Constants.TRAIN_DATE, FROM_DATE));
		para.add(new BasicNameValuePair(Constants.BACK_TRAIN_DATE, TO_DATE));
		para.add(new BasicNameValuePair(Constants.TOUR_FLAG, "dc"));
		para.add(new BasicNameValuePair(Constants.Q_PURPOSE_CODES, "ADULT"));
		para.add(new BasicNameValuePair(Constants.QUERY_FROM_STATION_NAME, "济南"));
		para.add(new BasicNameValuePair(Constants.QUERY_TO_STATION_NAME, "潍坊"));
		para.add(new BasicNameValuePair(Constants.UN_DEFINE, ""));
		HttpResponse respTickssss = TicketService.postHttpRequest(htp, Constants.SUBMIT_ORDER_REQUEST, para, cookie);
		HttpEntity en = respTickssss.getEntity();
		submitStr = EntityUtils.toString(en).trim();
		System.out.println(submitStr);
//		if (submitStr.length()==149 || submitStr.length() == 0) {
//			jumpToOrderTicket(orderKey, orderKeyValue, secretSTR, cookie);
//			
//			HttpResponse respTick = TicketService.postHttpRequest(htp, Constants.SUBMIT_ORDER_REQUEST, para, cookie);
//			HttpEntity e11n = respTick.getEntity();
//			submitStr = EntityUtils.toString(e11n).trim();
//		}
		return submitStr;
	}
	
	public static String getOrderKeyValue(String key){
        
		String result = "";
         //javascript方式
        String func = "function bin216(s){var i,l,o='',n;s+='';b='';for(i=0,l=s.length;i<l;i++){b=s.charCodeAt(i);n=b.toString(16);o+=n.length<2?'0'+n:n}return o};var Base32=new function(){var delta=2654435768;function longArrayToString(data,includeLength){var length=data.length;var n=(length-1)<<2;if(includeLength){var m=data[length-1];if((m<n-3)||(m>n))return null;n=m}for(var i=0;i<length;i++){data[i]=String.fromCharCode(data[i]&255,data[i]>>>8&255,data[i]>>>16&255,data[i]>>>24&255)}if(includeLength){return data.join('').substring(0,n)}else{return data.join('')}};function stringToLongArray(string,includeLength){var length=string.length;var result=[];for(var i=0;i<length;i+=4){result[i>>2]=string.charCodeAt(i)|string.charCodeAt(i+1)<<8|string.charCodeAt(i+2)<<16|string.charCodeAt(i+3)<<24}if(includeLength){result[result.length]=length}return result};this.encrypt=function(string,key){if(string==''){return''}var v=stringToLongArray(string,true);var k=stringToLongArray(key,false);if(k.length<4){k.length=4}var n=v.length-1;var z=v[n],y=v[0];var mx,e,p,q=Math.floor(6+52/(n+1)),sum=0;while(0<q--){sum=sum+delta&4294967295;e=sum>>>2&3;for(p=0;p<n;p++){y=v[p+1];mx=(z>>>5^y<<2)+(y>>>3^z<<4)^(sum^y)+(k[p&3^e]^z);z=v[p]=v[p]+mx&4294967295}y=v[0];mx=(z>>>5^y<<2)+(y>>>3^z<<4)^(sum^y)+(k[p&3^e]^z);z=v[n]=v[n]+mx&4294967295}return longArrayToString(v,false)}};var keyStr='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';function encode32(input){input=escape(input);var output='';var chr1,chr2,chr3='';var enc1,enc2,enc3,enc4='';var i=0;do{chr1=input.charCodeAt(i++);chr2=input.charCodeAt(i++);chr3=input.charCodeAt(i++);enc1=chr1>>2;enc2=((chr1&3)<<4)|(chr2>>4);enc3=((chr2&15)<<2)|(chr3>>6);enc4=chr3&63;if(isNaN(chr2)){enc3=enc4=64}else if(isNaN(chr3)){enc4=64}output=output+keyStr.charAt(enc1)+keyStr.charAt(enc2)+keyStr.charAt(enc3)+keyStr.charAt(enc4);chr1=chr2=chr3='';enc1=enc2=enc3=enc4=''}while(i<input.length);return output};function getEncryptCode(key,value){return encode32(bin216(Base32.encrypt(value, key)));}";
        
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByExtension("js");
        try {
            se.eval(func);
            result = (String) se.eval("eval(\"getEncryptCode('"+key+"', '1111')\")");
            System.out.println(result);
        }
        catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
	
	private static String getOrderKey(Map<String, String> cookie,String dynalJS) throws ParseException, IOException{
		//  /otn/dynamicJs/qkfcxrk HTTP/1.1
		HttpClient htp = gethttpclient();
		String uu = Constants.DYNAMIC_ORDER_KEY + dynalJS;
		HttpResponse resp = TicketService.getHttpRequest(htp, uu , null, cookie);
		System.out.println(resp);
		HttpEntity entity = resp.getEntity();
		String str = EntityUtils.toString(entity).trim();
		String key = "";
		key = str.substring(str.indexOf("gc(){var key='")+14, str.indexOf("gc(){var key='") + 22);
		return key;
	}
	
	/**
	 * 根据返回的值处理，返回指定车次的secretStr
	 * @param listMap
	 * @return secretSTR
	 */
	@SuppressWarnings("unchecked")
	public static String getSecretStr(List<Map<String, Object>> listMap) {
		String secretSTR = "";
		for(Map<String, Object> map : listMap){
			List<Map<String, Object>> li = new ArrayList<Map<String,Object>>();
			li =  (List<Map<String, Object>>) map.get("data");
			System.out.println(li);
			if (li.size() > 0) {
				for (Map<String, Object> mso : li) {
					System.out.println(mso.get("queryLeftNewDTO"));
					System.out.println(mso.get("secretStr"));
					Map<String, String> strMap = (Map<String, String>) mso.get("queryLeftNewDTO");
					System.out.println(strMap.get("station_train_code"));
					
					if(strMap.get("canWebBuy").equals("Y")){
						String train_code = strMap.get("station_train_code").trim();
						if (train_code.equals("G457")) {
							secretSTR = mso.get("secretStr").toString();
							break;
						}
					}
				}
			}
		}
		
		return secretSTR;
	}
	
	/**
	 * 登录的时候，验证验证码是否正确
	 * 
	 * 
	 */
	public String checkRandCode(Map<String, String> cookie,String rand) throws ParseException, IOException{
		
		HttpClient htp = gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair(Constants.RAND, "sjrand"));
		para.add(new BasicNameValuePair(Constants.RAND_CODE, rand));
		HttpResponse respTickssss = TicketService.postHttpRequest(htp, Constants.CHECK_RAND_CODE_ANSYN, para, cookie);
		HttpEntity en = respTickssss.getEntity();
		String responseHTML = EntityUtils.toString(en).trim();
		
		return responseHTML.toString();
	}
	
	/**
	 * 登录成功以后，类似于跳转的东西，登录以后跳转到我们看到的主页面，查看是否有自己的用户名显示
	 * 
	 */
	private static Map<String, String> initMyTT(Map<String, String> cookie) throws ParseException, IOException {
		
		HttpClient httpc11 = gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair("_json_att", ""));
		HttpResponse respTickssss = TicketService.getHttpRequest(httpc11, "https://kyfw.12306.cn/otn/index/initMy12306", para, cookie);
		Map<String, String> mapp = new HashMap<String, String>();
		Header[] headers = respTickssss.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			if (headers[i].getName().equals("Set-Cookie")) {
				String cookie22 = headers[i].getValue();
				String cookieName = cookie22.split("=")[0];
				String cookieValue = cookie22.split("=")[1].split(";")[0];
				mapp.put(cookieName, cookieValue);
			}
		}
		return mapp;
	}
	/**
	 * 登录成功以后需要userLogin，测试一下是否成功
	 * 需要用ajax连接一下是否成功，按照12306登录网站的步骤
	 * 登录成功以后，下一步就是用ajax验证userLogin一下
	 * 
	 */
	private static HttpResponse userLoginTT(Map<String, String> cookie) {
		
		HttpClient httpc11 = gethttpclient();
		List<NameValuePair> parameters2 = new ArrayList<NameValuePair>();
		parameters2.add(new BasicNameValuePair("_json_att", ""));
		HttpResponse respTick = TicketService.postHttpRequest(httpc11, Constants.USER_LOGIN_URL, parameters2, cookie);
		
		System.out.println(respTick.toString());
		
		return respTick;
		
	}
	
	/**
	 * 登录12306网站 需要一下参数
	 * @param username(用户名)
	 * @param password(密码)
	 * @param randcode(验证码)
	 * @param randCode_validate
	 * @param kkky(随机验证码)
	 * @param vvvy(随机验证码，需要用js进行获取)
	 * 
	 */
	private static void loginAsynTT(Map<String, String> cookie, String randCode,String kkky,String vvvy) {
		HttpClient httpc11 = gethttpclient();
		
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair(Constants.LOGIN_USERNAME, username));
		parameters.add(new BasicNameValuePair(Constants.LOGIN_PASSWORD, password));
		parameters.add(new BasicNameValuePair(Constants.LOGIN_RANDCODE, randCode));
		parameters.add(new BasicNameValuePair(Constants.RAND_CODE_VALIDATE, ""));
		parameters.add(new BasicNameValuePair(kkky, vvvy));
		parameters.add(new BasicNameValuePair(Constants.MY_VERSION, Constants.UN_DEFINE));
		
		HttpResponse responseHTML = TicketService.postHttpRequest(httpc11, Constants.LOGIN_AYSN_SUGGEST_URL, parameters, cookie);
		System.out.println(responseHTML.toString());
	}
	
	/**
	 *第一次浏览12306网站，需要进行初始化cookie数据
	 * 
	 */
	public static Map<String, String> initTicketHttp() throws ClientProtocolException, IOException{
		HttpClient httpClient = gethttpclient();
		try {
			cookieData = new HashMap<String, String>();
			HttpResponse response = TicketService.getHttpRequest(httpClient, "https://kyfw.12306.cn/otn/login/init", null, null);
			String responseText = EntityUtils.toString(response.getEntity(), "GBK");
			int rindex = responseText.indexOf("otn/dynamicJs");
			String rtxt = responseText.substring(rindex,responseText.length());
			int r33 = rtxt.indexOf("\"");
			String jsurl = "https://kyfw.12306.cn/"+rtxt.substring(0, r33);
			
			cookieData.put("jsurl", jsurl);
			
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
	
	/**
	 * 初始化httpclient,登录https使用，使用的是ssl协议
	 * 
	 */
	public static HttpClient gethttpclient(){
		try {
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(sslcontext);
			ClientConnectionManager ccm = new DefaultHttpClient().getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));
			HttpParams params = new BasicHttpParams();
			params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 80000);
			params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 80000);
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
	
	/**
     * 处理gzip,deflate返回流
     * 
     * @param is
     * @return
     * @throws IOException
     */
    private static String zipInputStream(InputStream is) throws IOException {
        GZIPInputStream gzip = new GZIPInputStream(is);
        BufferedReader in = new BufferedReader(new InputStreamReader(gzip, "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null)
            buffer.append(line + "\n");
        return buffer.toString();
    }
    
    /**
     * 处理返回文件流
     * 
     * @param is
     * @return
     * @throws IOException
     */
    private static String readInputStream(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = in.readLine()) != null)
            buffer.append(line + "\n");
        return buffer.toString();
    }
	
}
