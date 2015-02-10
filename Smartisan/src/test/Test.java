package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inga.ticket.ReserveTicketMain;
import com.inga.ticket.TicketMain;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		//cancel_flag=2&bed_level_order_num=000000000000000000000000000000&passengerTicketStr=O%2C0%2C1%2C%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C18766415887%2CN&
		//oldPassengerStr=%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C1_&tour_flag=dc&randCode=kxbe&MTAwNjI3=OWYxZjUyZWY4NTQwMWU5OQ%3D%3D&_json_att=&REPEAT_SUBMIT_TOKEN=ed9020294afebf24e286ad9c1d0a7ee7
		// 转换之后，转换为中文
//		String value = java.net.URLDecoder.decode(\\"%E7%8E%8B%E5%85%B5%E5%85%B5%2C1%2C370784199108137616%2C1_\\",\\"UTF-8\\");
//		System.out.println(value);
		String str = "{\"validateMessagesShowId\":\"_validatorMessage\",\"status\":false,\"httpstatus\":200,\"messages\":[\"网络繁忙，请您重试。如正在使用第三方购票软件或插件，请卸载后重试。\"],\"validateMessages\":{}}";
		
		System.out.println(str.length());
		
		//传参数之前中文转码
//		java.net.URLEncoder.encode(\\"xxxx\\",“utf-8\\")
		
//		String responseQueryT = \"{\\"validateMessagesShowId\\":\\"_validatorMessage\\",\\"status\\":true,\\"httpstatus\\":200,\\"messages\\":[],\\"validateMessages\\":{}}\";
//		System.out.println(responseQueryT.length());
		//		ReserveTicketMain res = new ReserveTicketMain();
//		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
//		listMap = (List<Map<String, Object>>) res.dealJsonData(responseQueryT);
//		
//		String secretSTR = TicketMain.getSecretStr(listMap);
//		System.out.println(secretSTR);
		
	}
}
