package com.inga.ticket.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONClass {
	
	public List<Map<String, Object>> jsonToMap(String data){
		System.out.println(data);
		if (data.indexOf("[") != 0) {
			data = "[" + data +"]";
		}
		System.out.println(data);
		JSONArray jsonArr = JSONArray.fromObject(data);
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Iterator<JSONObject> it = jsonArr.iterator();
        while(it.hasNext()){
            JSONObject json2 = it.next();
            list.add(parseJSON2Map(json2.toString()));
        }
        return list;
	}
	
	public static Map<String, Object> parseJSON2Map(String jsonStr){
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	

	public static void main(String[] args) {
		JSONClass jn = new JSONClass();
		String str = "[{\"validateMessagesShowId\":\"_validatorMessage\",\"status\":true,\"httpstatus\":200,\"data\":{\"result\":\"1\",\"msg\":\"randCodeRight\"},\"messages\":[],\"validateMessages\":{}}]";
		List<Map<String, Object>> list = jn.jsonToMap(str);
//		System.out.println(list);
		for(Map<String, Object> map : list){
//			System.out.println(map.get("data"));
//			List<Map<String, Object>> li = jn.jsonToMap(map.get("data").to);
			Map<String, String> maa =  (Map<String, String>) map.get("data");
			System.out.println(maa.get("result"));
		}
		
//		list.iterator();
		
	}
	
}
