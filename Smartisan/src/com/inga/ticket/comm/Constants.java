package com.inga.ticket.comm;

public class Constants {
	
	public static final String LOGIN_USERNAME = "loginUserDTO.user_name";
	public static final String LOGIN_RANDCODE = "randCode";
	public static final String LOGIN_PASSWORD = "userDTO.password";
	public static final String RAND = "rand";
	//randCode
	public static final String RAND_CODE = "randCode";
	//randCode_validate
	public static final String RAND_CODE_VALIDATE = "randCode_validate";
	//myversion
	public static final String MY_VERSION="myversion";
	//undefined
	public static final String UN_DEFINE="undefined";
	//leftTicketDTO.train_date=2015-02-03&leftTicketDTO.from_station=JNK&leftTicketDTO.to_station=WFK&purpose_codes=ADULT
	public static final String Q_TRAIN_DATE="leftTicketDTO.train_date";
	public static final String Q_FROM_STATION="leftTicketDTO.from_station";
	public static final String Q_TO_STATION="leftTicketDTO.to_station";
	public static final String Q_PURPOSE_CODES="purpose_codes";
			
	
	
	public static final String RAND_CODE_URL = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand";
	public static final String USER_LOGIN_URL = "https://kyfw.12306.cn/otn/login/userLogin";
	//loginAysnSuggest
	public static final String LOGIN_AYSN_SUGGEST_URL = "https://kyfw.12306.cn/otn/login/loginAysnSuggest";
	//login/init
	public static final String LOGIN_INIT_URL = "https://kyfw.12306.cn/otn/login/init";
	//checkRandCodeAnsyn
	public static final String CHECK_RAND_CODE_ANSYN = "https://kyfw.12306.cn/otn/passcodeNew/checkRandCodeAnsyn";
	//leftTicket init 
	public static final String LEFT_TICKET_INIT = "https://kyfw.12306.cn/otn/leftTicket/init";
	//leftTicket/log
	public static final String LEFT_TICKET_LOG = "https://kyfw.12306.cn/otn/leftTicket/log";
	//leftTicket/queryT
	public static final String LEFT_TICKET_QUERYT = "https://kyfw.12306.cn/otn/leftTicket/queryT";
}
