package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inga.ticket.ReserveTicketMain;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String str = "{\"validateMessagesShowId\":\"_validatorMessage\",\"status\":true,\"httpstatus\":200,\"data\":[{\"queryLeftNewDTO\":{\"train_no\":\"560000G28210\",\"station_train_code\":\"G283\",\"start_station_telecode\":\"HGH\",\"start_station_name\":\"杭州东\",\"end_station_telecode\":\"QDK\",\"end_station_name\":\"青岛\",\"from_station_telecode\":\"JNK\",\"from_station_name\":\"济南\",\"to_station_telecode\":\"WFK\",\"to_station_name\":\"潍坊\",\"start_time\":\"18:58\",\"arrive_time\":\"20:23\",\"day_difference\":\"0\",\"train_class_name\":\"\",\"lishi\":\"01:25\",\"canWebBuy\":\"Y\",\"lishiValue\":\"85\",\"yp_info\":\"O006450039M007950021P011450013\",\"control_train_day\":\"20991231\",\"start_train_date\":\"20150203\",\"seat_feature\":\"O3M3P3\",\"yp_ex\":\"O0M0P0\",\"train_seat_feature\":\"3\",\"seat_types\":\"OMP\",\"location_code\":\"H1\",\"from_station_no\":\"13\",\"to_station_no\":\"16\",\"control_day\":59,\"sale_time\":\"1400\",\"is_support_card\":\"0\",\"gg_num\":\"--\",\"gr_num\":\"--\",\"qt_num\":\"--\",\"rw_num\":\"--\",\"rz_num\":\"--\",\"tz_num\":\"13\",\"wz_num\":\"--\",\"yb_num\":\"--\",\"yw_num\":\"--\",\"yz_num\":\"--\",\"ze_num\":\"有\",\"zy_num\":\"有\",\"swz_num\":\"--\"},\"secretStr\":\"MjAxNS0wMi0wMyMwMCNHMjgzIzAxOjI1IzE4OjU4IzU2MDAwMEcyODIxMCNKTksjV0ZLIzIwOjIzI%2Ba1juWNlyPmvY3lnYojMTMjMTYjTzAwNjQ1MDAzOU0wMDc5NTAwMjFQMDExNDUwMDEzI0gxIzE0MjI5NTM2MzA4NjkjOEFGMUM3NDc1MTJCMjExQzlBM0NEMDlDMTI4MDA1MjQ1OUZCN0VDOTAxMDk0RTc2ODRGRDAyOTE%3D\",\"buttonTextInfo\":\"预订\"},{\"queryLeftNewDTO\":{\"train_no\":\"240000G19901\",\"station_train_code\":\"G199\",\"start_station_telecode\":\"VNP\",\"start_station_name\":\"北京南\",\"end_station_telecode\":\"QDK\",\"end_station_name\":\"青岛\",\"from_station_telecode\":\"JNK\",\"from_station_name\":\"济南\",\"to_station_telecode\":\"WFK\",\"to_station_name\":\"潍坊\",\"start_time\":\"19:36\",\"arrive_time\":\"21:00\",\"day_difference\":\"0\",\"train_class_name\":\"\",\"lishi\":\"01:24\",\"canWebBuy\":\"Y\",\"lishiValue\":\"84\",\"yp_info\":\"O006450070M0079500269019450014\",\"control_train_day\":\"20991231\",\"start_train_date\":\"20150203\",\"seat_feature\":\"O3M393\",\"yp_ex\":\"O0M090\",\"train_seat_feature\":\"3\",\"seat_types\":\"OM9\",\"location_code\":\"P4\",\"from_station_no\":\"04\",\"to_station_no\":\"07\",\"control_day\":59,\"sale_time\":\"1400\",\"is_support_card\":\"0\",\"gg_num\":\"--\",\"gr_num\":\"--\",\"qt_num\":\"--\",\"rw_num\":\"--\",\"rz_num\":\"--\",\"tz_num\":\"--\",\"wz_num\":\"--\",\"yb_num\":\"--\",\"yw_num\":\"--\",\"yz_num\":\"--\",\"ze_num\":\"有\",\"zy_num\":\"有\",\"swz_num\":\"14\"},\"secretStr\":\"MjAxNS0wMi0wMyMwMCNHMTk5IzAxOjI0IzE5OjM2IzI0MDAwMEcxOTkwMSNKTksjV0ZLIzIxOjAwI%2Ba1juWNlyPmvY3lnYojMDQjMDcjTzAwNjQ1MDA3ME0wMDc5NTAwMjY5MDE5NDUwMDE0I1A0IzE0MjI5NTM2MzA4NzAjOEE5OTcyQkFCRjA5MUUxN0ExQ0FFNEU0M0U2RDM4NUIxQTRBMkYwMEZENUU5NThDMUQ1NDU0MEI%3D\",\"buttonTextInfo\":\"预订\"},{\"queryLeftNewDTO\":{\"train_no\":\"47000D60170B\",\"station_train_code\":\"D6017\",\"start_station_telecode\":\"JNK\",\"start_station_name\":\"济南\",\"end_station_telecode\":\"QDK\",\"end_station_name\":\"青岛\",\"from_station_telecode\":\"JNK\",\"from_station_name\":\"济南\",\"to_station_telecode\":\"WFK\",\"to_station_name\":\"潍坊\",\"start_time\":\"19:54\",\"arrive_time\":\"21:14\",\"day_difference\":\"0\",\"train_class_name\":\"动车\",\"lishi\":\"01:20\",\"canWebBuy\":\"Y\",\"lishiValue\":\"80\",\"yp_info\":\"O006450491O006453084M007750037\",\"control_train_day\":\"20991231\",\"start_train_date\":\"20150203\",\"seat_feature\":\"O3W3M3\",\"yp_ex\":\"O0O0M0\",\"train_seat_feature\":\"3\",\"seat_types\":\"OOM\",\"location_code\":\"K2\",\"from_station_no\":\"01\",\"to_station_no\":\"03\",\"control_day\":59,\"sale_time\":\"1400\",\"is_support_card\":\"0\",\"gg_num\":\"--\",\"gr_num\":\"--\",\"qt_num\":\"--\",\"rw_num\":\"--\",\"rz_num\":\"--\",\"tz_num\":\"--\",\"wz_num\":\"有\",\"yb_num\":\"--\",\"yw_num\":\"--\",\"yz_num\":\"--\",\"ze_num\":\"有\",\"zy_num\":\"有\",\"swz_num\":\"--\"},\"secretStr\":\"MjAxNS0wMi0wMyMwMCNENjAxNyMwMToyMCMxOTo1NCM0NzAwMEQ2MDE3MEIjSk5LI1dGSyMyMToxNCPmtY7ljZcj5r2N5Z2KIzAxIzAzI08wMDY0NTA0OTFPMDA2NDUzMDg0TTAwNzc1MDAzNyNLMiMxNDIyOTUzNjMwODcwIzJDRkQ4ODcwOTMzQkM2NTFCRDhCQUFFOUVGMzlGOUJFMDk3MkE5NzgxNDRBNUM1N0M0MEI0RTAx\",\"buttonTextInfo\":\"预订\"},{\"queryLeftNewDTO\":{\"train_no\":\"12000G124610\",\"station_train_code\":\"G1247\",\"start_station_telecode\":\"SBT\",\"start_station_name\":\"沈阳北\",\"end_station_telecode\":\"QHK\",\"end_station_name\":\"青岛北\",\"from_station_telecode\":\"JNK\",\"from_station_name\":\"济南\",\"to_station_telecode\":\"WFK\",\"to_station_name\":\"潍坊\",\"start_time\":\"20:06\",\"arrive_time\":\"21:33\",\"day_difference\":\"0\",\"train_class_name\":\"\",\"lishi\":\"01:27\",\"canWebBuy\":\"Y\",\"lishiValue\":\"87\",\"yp_info\":\"O006450042M0079500129019450008\",\"control_train_day\":\"20991231\",\"start_train_date\":\"20150203\",\"seat_feature\":\"O3M393\",\"yp_ex\":\"O0M090\",\"train_seat_feature\":\"3\",\"seat_types\":\"OM9\",\"location_code\":\"T1\",\"from_station_no\":\"13\",\"to_station_no\":\"16\",\"control_day\":59,\"sale_time\":\"1400\",\"is_support_card\":\"0\",\"gg_num\":\"--\",\"gr_num\":\"--\",\"qt_num\":\"--\",\"rw_num\":\"--\",\"rz_num\":\"--\",\"tz_num\":\"--\",\"wz_num\":\"--\",\"yb_num\":\"--\",\"yw_num\":\"--\",\"yz_num\":\"--\",\"ze_num\":\"有\",\"zy_num\":\"12\",\"swz_num\":\"8\"},\"secretStr\":\"MjAxNS0wMi0wMyMwMCNHMTI0NyMwMToyNyMyMDowNiMxMjAwMEcxMjQ2MTAjSk5LI1dGSyMyMTozMyPmtY7ljZcj5r2N5Z2KIzEzIzE2I08wMDY0NTAwNDJNMDA3OTUwMDEyOTAxOTQ1MDAwOCNUMSMxNDIyOTUzNjMwODcwIzgxMjVBMzMzRTNCREM1QjdEODhCNTQ5QkY0MEQzNkYwRDI1RkRCRkIwMzRDQUQ1MkRGRTAxN0FC\",\"buttonTextInfo\":\"预订\"},{\"queryLeftNewDTO\":{\"train_no\":\"5l0000G23431\",\"station_train_code\":\"G235\",\"start_station_telecode\":\"AOH\",\"start_station_name\":\"上海虹桥\",\"end_station_telecode\":\"QDK\",\"end_station_name\":\"青岛\",\"from_station_telecode\":\"JNK\",\"from_station_name\":\"济南\",\"to_station_telecode\":\"WFK\",\"to_station_name\":\"潍坊\",\"start_time\":\"20:20\",\"arrive_time\":\"21:45\",\"day_difference\":\"0\",\"train_class_name\":\"\",\"lishi\":\"01:25\",\"canWebBuy\":\"Y\",\"lishiValue\":\"85\",\"yp_info\":\"O006450092M007950030P011450024\",\"control_train_day\":\"20991231\",\"start_train_date\":\"20150203\",\"seat_feature\":\"O3M3P3\",\"yp_ex\":\"O0M0P0\",\"train_seat_feature\":\"3\",\"seat_types\":\"OMP\",\"location_code\":\"H1\",\"from_station_no\":\"06\",\"to_station_no\":\"09\",\"control_day\":59,\"sale_time\":\"1400\",\"is_support_card\":\"0\",\"gg_num\":\"--\",\"gr_num\":\"--\",\"qt_num\":\"--\",\"rw_num\":\"--\",\"rz_num\":\"--\",\"tz_num\":\"有\",\"wz_num\":\"--\",\"yb_num\":\"--\",\"yw_num\":\"--\",\"yz_num\":\"--\",\"ze_num\":\"有\",\"zy_num\":\"有\",\"swz_num\":\"--\"},\"secretStr\":\"MjAxNS0wMi0wMyMwMCNHMjM1IzAxOjI1IzIwOjIwIzVsMDAwMEcyMzQzMSNKTksjV0ZLIzIxOjQ1I%2Ba1juWNlyPmvY3lnYojMDYjMDkjTzAwNjQ1MDA5Mk0wMDc5NTAwMzBQMDExNDUwMDI0I0gxIzE0MjI5NTM2MzA4NzAjOUQxNzgyMTg2MEFGNDJGNkRBREI4REM3OUMyMTZCNDY3OEJDNjUyNUFENEFGMzZFQkY4NUE5NEU%3D\",\"buttonTextInfo\":\"预订\"}],\"messages\":[],\"validateMessages\":{}}";
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		ReserveTicketMain reserve = new ReserveTicketMain();
		list = reserve.dealJsonData(str);
		for(Map<String, Object> map : list){
			List<Map<String, Object>> li = new ArrayList<Map<String,Object>>();
			li = (List<Map<String, Object>>) map.get("data");
			
			for (Map<String, Object> mso : li) {
				System.out.println(mso.get("queryLeftNewDTO"));
				System.out.println(mso.get("secretStr"));
				
				Map<String, String> strMap = (Map<String, String>) mso.get("queryLeftNewDTO");
				System.out.println(strMap.get("station_train_code"));
				
			}
			
		}
		
	}
}
