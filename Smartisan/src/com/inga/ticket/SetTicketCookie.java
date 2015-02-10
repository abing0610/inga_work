package com.inga.ticket;

import java.util.HashMap;
import java.util.Map;

public class SetTicketCookie {

	public static  Map<String, String> getCookie(Map<String, String> cookie) {
		cookie.put("_jc_save_fromStation", getUnicode4Cookie("¼ÃÄÏ", "JNK"));
		cookie.put("_jc_save_toStation", getUnicode4Cookie("Î«·»", "WFK"));
		cookie.put("_jc_save_fromDate", TicketMain.FROM_DATE);
		cookie.put("_jc_save_toDate", TicketMain.TO_DATE);
		cookie.put("_jc_save_wfdc_flag", "dc");
		cookie.put("_jc_save_showZtkyts", "true");
        
        return cookie;
    }
	
	public static String getUnicode4Cookie(String cityName, String cityCode) {
        String result = "";
        for (int i = 0; i < cityName.length(); i++) {
            int chr1 = (char)cityName.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) {// ºº×Ö·¶Î§ \u4e00-\u9fa5 (ÖÐÎÄ)
                result += "%u" + Integer.toHexString(chr1).toUpperCase();
            }
            else {
                result += cityName.charAt(i);
            }
        }
        result += "%2C" + cityCode;
        return result;
    }
	
	public static void main(String[] args) {
		String s = getUnicode4Cookie("Î«·»", "WFK");
		System.out.println(s);
	}
}
