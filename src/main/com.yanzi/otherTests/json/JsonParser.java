package com.yanzi.otherTests.json;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class JsonParser {
	
	public static void main(String[] args){
		 String jsonStr = "[{\"code\":\"I1_5200\",\"name\":\"移动缴费\",\"type\":\"4\",\"categories\":[{\"code\":\"I1_5200_014201\",\"name\":\"湖北移动充值\"}]},{\"code\":\"I1_5200\",\"name\":\"联通缴费\",\"type\":\"5\",\"categories\":[{\"code\":\"J0_5200_0270\",\"name\":\"湖北联通代理商回缴款\"},{\"code\":\"I1_5200_024201\",\"name\":\"湖北联通充值\"}]},{\"code\":\"I1_5200\",\"name\":\"电信缴费\",\"type\":\"6\",\"categories\":[{\"code\":\"I1_5200_034201\",\"name\":\"湖北电信充值\"}]},{\"code\":\"D4_5200\",\"name\":\"水费缴纳\",\"type\":\"1\",\"categories\":[{\"code\":\"D4_5200_0000\",\"name\":\"湖北省武汉市水费集团\"},{\"code\":\"D4_5200_0003\",\"name\":\"蔡甸供水\"}]},{\"code\":\"D1_5200\",\"name\":\"电费缴纳\",\"type\":\"2\",\"categories\":[{\"code\":\"D1_5200_0000\",\"name\":\"湖北省电力\"},{\"code\":\"D1_5200_5210\",\"name\":\"湖北电费【武汉】\"}]},{\"code\":\"G1_5200\",\"name\":\"ETC缴费\",\"type\":\"39\",\"categories\":[{\"code\":\"G1_5200_0000\",\"name\":\"湖北ETC缴费（车牌颜色：蓝色）\"},{\"code\":\"G1_5200_0001\",\"name\":\"湖北ETC缴费（车牌颜色：黄色）\"},{\"code\":\"G1_5200_0002\",\"name\":\"湖北ETC缴费（车牌颜色：黑色）\"},{\"code\":\"G1_5200_0003\",\"name\":\"湖北ETC缴费（车牌颜色：白色）\"}]},{\"code\":\"S0_5200\",\"name\":\"税费\",\"type\":\"20\",\"categories\":[{\"code\":\"S0_5200_ACP01\",\"name\":\"湖北地税\"}]},{\"code\":\"G1_5200\",\"name\":\"交通罚款\",\"type\":\"26\",\"categories\":[{\"code\":\"G1_5200_0004\",\"name\":\"湖北交通罚款缴费\"}]},{\"code\":\"I1_5200\",\"name\":\"固话宽带\",\"type\":\"44\",\"categories\":[{\"code\":\"I1_5200_0600\",\"name\":\"【电信固话】\"}]},{\"code\":\"S2_5200\",\"name\":\"医疗充值\",\"type\":\"47\",\"categories\":[{\"code\":\"S2_5200_0000\",\"name\":\"【健康之路账户充值】\"}]}]";

		 ArrayList<String> result = new ArrayList<String>();
		 
		 JSONArray jsonArray = JSONObject.parseArray(jsonStr);
		    
		 for(int i = 0; i < jsonArray.size(); i++){
			 JSONObject jb = jsonArray.getJSONObject(i);
			 if(jb.getInteger("type") == 2){
				 JSONArray categorites = jb.getJSONArray("categories");
				 result.add(categorites.toJSONString());
			 }
		    	
		 }
		 for(String i : result){
			 System.out.println(i);
		 }
		
		
	}

   
}
