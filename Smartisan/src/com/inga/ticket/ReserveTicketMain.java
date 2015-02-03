package com.inga.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.inga.ticket.comm.Constants;
import com.inga.ticket.comm.JSONClass;

public class ReserveTicketMain {

	public HttpResponse toIndexReserverPage(Map<String, String> cookie){
		
		HttpClient htp = TicketMain.gethttpclient();
		HttpResponse resp = TicketService.getHttpRequest(htp, Constants.LEFT_TICKET_INIT, null, cookie);
		
		return resp;
	}
	
	/**
	 * /otn/leftTicket/log?leftTicketDTO.train_date=2015-02-03&leftTicketDTO.from_station=JNK&leftTicketDTO.to_station=WFK&purpose_codes=ADULT
	 * 
	 * @param cookie (Map<String,String>)
	 * 
	 * @return resp(HttpResponse)
	 * 
	 */
	public HttpResponse leftTickeLog(Map<String, String> cookie){
		HttpClient htp = TicketMain.gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair(Constants.Q_TRAIN_DATE, "2015-02-03"));
		para.add(new BasicNameValuePair(Constants.Q_FROM_STATION, "JNK"));
		para.add(new BasicNameValuePair(Constants.Q_TO_STATION, "WFK"));
		para.add(new BasicNameValuePair(Constants.Q_PURPOSE_CODES, "ADULT"));
		
		HttpResponse resp = TicketService.getHttpRequest(htp, Constants.LEFT_TICKET_LOG, para, cookie);
		
		return resp;
	}
	
	/**
	 * /otn/leftTicket/log?leftTicketDTO.train_date=2015-02-03&leftTicketDTO.from_station=JNK&leftTicketDTO.to_station=WFK&purpose_codes=ADULT
	 * 
	 * @param cookie (Map<String,String>)
	 * 
	 * @return resp(HttpResponse)
	 * 
	 */
	public HttpResponse leftTickeQueryT(Map<String, String> cookie){
		HttpClient htp = TicketMain.gethttpclient();
		List<NameValuePair> para = new ArrayList<NameValuePair>();
		para.add(new BasicNameValuePair(Constants.Q_TRAIN_DATE, "2015-02-03"));
		para.add(new BasicNameValuePair(Constants.Q_FROM_STATION, "JNK"));
		para.add(new BasicNameValuePair(Constants.Q_TO_STATION, "WFK"));
		para.add(new BasicNameValuePair(Constants.Q_PURPOSE_CODES, "ADULT"));
		
		HttpResponse resp = TicketService.getHttpRequest(htp, Constants.LEFT_TICKET_QUERYT, para, cookie);
		
		return resp;
	}
	
	/**
	 * 处理json数据
	 * 
	 */
	
	public List<Map<String, Object>> dealJsonData(String respJson){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		JSONClass jc = new JSONClass();
		list = jc.jsonToMap(respJson);
		
		
		return list;
	}
	
	
}
