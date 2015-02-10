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
	// secretStr=aa&train_date=2015-02-21&back_train_date=2015-02-04&tour_flag=dc&purpose_codes=ADULT&query_from_station_name=¼ÃÄÏ&query_to_station_name=Î«·»&undefined
	public static final String 	SECRET_STR = "secretStr"; 
	public static final String TRAIN_DATE = "train_date";
	public static final String BACK_TRAIN_DATE = "back_train_date";
	public static final String TOUR_FLAG = "tour_flag";
	public static final String QUERY_FROM_STATION_NAME = "query_from_station_name";
	public static final String QUERY_TO_STATION_NAME = "query_to_station_name";
	
	//cancel_flag=2&bed_level_order_num=000000000000000000000000000000
	//&passengerTicketStr=O%2C0%2C1%2C%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C18766415887%2CN
	//&oldPassengerStr=%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C1_&
	//tour_flag=dc&randCode=kxbe
	//&MTAwNjI3=OWYxZjUyZWY4NTQwMWU5OQ%3D%3D&_json_att=&REPEAT_SUBMIT_TOKEN=ed9020294afebf24e286ad9c1d0a7ee7
	public static final String 	CANCEL_FLAG="cancel_flag";
	public static final String BED_LEVEL_ORDER_NUM="bed_level_order_num";
	public static final String PASSSENGER_TICKET_STR ="passengerTicketStr";
	public static final String OLD_PASSWNGER_STR="oldPassengerStr";
	//train_date=Sat+Feb+21+2015+00%3A00%3A00+GMT%2B0800+(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)
	//&train_no=240000G47500&stationTrainCode=G475&seatType=O&fromStationTelecode=JNK&toStationTelecode=WFK
	//&leftTicket=O006450002M0079500019019450000&purpose_codes=00&_json_att=&REPEAT_SUBMIT_TOKEN=ed9020294afebf24e286ad9c1d0a7ee7
	public static final String STATION_TRAIN_CODE="stationTrainCode";
	public static final String SEAT_TYPE="seatType";
	public static final String FROM_STATION_TELECODE="fromStationTelecode";
	public static final String TO_STATION_TELECODE="toStationTelecode";
	public static final String LEFT_TICKET="leftTicket";
	public static final String JSON_ATT="_json_att";
	
	
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
	// /otn/dynamicJs/qkfcxrk 
	public static final String DYNAMIC_ORDER_KEY = "https://kyfw.12306.cn/otn/dynamicJs/";
	//	/otn/leftTicket/submitOrderRequest	
	public static final String SUBMIT_ORDER_REQUEST = "https://kyfw.12306.cn/otn/leftTicket/submitOrderRequest";
	// /otn/confirmPassenger/initDc 
	public static final String CONFIRM_PASSENGER_INITDC = "https://kyfw.12306.cn/otn/confirmPassenger/initDc";
	//	/otn/login/checkUser	
	public static final String CHECK_USER = "https://kyfw.12306.cn/otn/login/checkUser";
	//	/otn/confirmPassenger/getPassengerDTOs	
	public static final String 	GET_PASSENGER_DTOS = "https://kyfw.12306.cn/otn/confirmPassenger/getPassengerDTOs";
	
	
}
