package com.inga.ticket;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.inga.ticket.comm.Constants;

public class OrderPageThread {

	/**
	 *  // cancel_flag=2&bed_level_order_num=000000000000000000000000000000
	 * 	&passengerTicketStr=O%2C0%2C1%2C%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C18766415887%2CN
	 *	&oldPassengerStr=%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C1_
	 *	&tour_flag=dc&randCode=kxbe&MTAwNjI3=OWYxZjUyZWY4NTQwMWU5OQ%3D%3D
	 *	&_json_att=&REPEAT_SUBMIT_TOKEN=ed9020294afebf24e286ad9c1d0a7ee7
	 *
	 *
		//url   checkOrderInfo
		/otn/confirmPassenger/checkOrderInfo HTTP/1.1
		 * 
		 * 
		
	 */
	public static void dealMain(Map<String, String> cookie){
		
		String rand_code = getOrderRandCode(cookie);
		
		HttpClient hc = TicketMain.gethttpclient();
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair(Constants.CANCEL_FLAG, "2"));
		parameters.add(new BasicNameValuePair(Constants.BED_LEVEL_ORDER_NUM, "000000000000000000000000000000"));
		parameters.add(new BasicNameValuePair(Constants.PASSSENGER_TICKET_STR, ""));
		parameters.add(new BasicNameValuePair(Constants.TOUR_FLAG, "dc"));
		parameters.add(new BasicNameValuePair(Constants.RAND_CODE, rand_code));
		//MTAwNjI3=OWYxZjUyZWY4NTQwMWU5OQ%3D%3D
		parameters.add(new BasicNameValuePair("", ""));
		parameters.add(new BasicNameValuePair(Constants.JSON_ATT, ""));
		
		
		HttpResponse responseHTML = TicketService.postHttpRequest(hc, Constants.LOGIN_AYSN_SUGGEST_URL, parameters, cookie);
		
		
		
		
		
		
		
		
		
		
	}
	
	/**
	 * 
	 * //train_date=Sat+Feb+21+2015+00%3A00%3A00+GMT%2B0800+(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&train_no=240000G47500&stationTrainCode=G475&seatType=O&fromStationTelecode=JNK&toStationTelecode=WFK&leftTicket=O006450002M0079500019019450000&purpose_codes=00&_json_att=&REPEAT_SUBMIT_TOKEN=ed9020294afebf24e286ad9c1d0a7ee7
		//url   getQueueCount
		 * /otn/confirmPassenger/getQueueCount HTTP/1.1
		 * 
	 */
	
	public static String getOrderRandCode(Map<String, String> cookie){
		
		return null;
	}
}
