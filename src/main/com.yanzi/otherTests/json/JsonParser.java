package com.yanzi.otherTests.json;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class JsonParser {
	
	public static void main(String[] args){
		 String jsonStr = "[{\"code\":\"I1_5200\",\"name\":\"�ƶ��ɷ�\",\"type\":\"4\",\"categories\":[{\"code\":\"I1_5200_014201\",\"name\":\"�����ƶ���ֵ\"}]},{\"code\":\"I1_5200\",\"name\":\"��ͨ�ɷ�\",\"type\":\"5\",\"categories\":[{\"code\":\"J0_5200_0270\",\"name\":\"������ͨ�����̻ؽɿ�\"},{\"code\":\"I1_5200_024201\",\"name\":\"������ͨ��ֵ\"}]},{\"code\":\"I1_5200\",\"name\":\"���Žɷ�\",\"type\":\"6\",\"categories\":[{\"code\":\"I1_5200_034201\",\"name\":\"�������ų�ֵ\"}]},{\"code\":\"D4_5200\",\"name\":\"ˮ�ѽ���\",\"type\":\"1\",\"categories\":[{\"code\":\"D4_5200_0000\",\"name\":\"����ʡ�人��ˮ�Ѽ���\"},{\"code\":\"D4_5200_0003\",\"name\":\"�̵鹩ˮ\"}]},{\"code\":\"D1_5200\",\"name\":\"��ѽ���\",\"type\":\"2\",\"categories\":[{\"code\":\"D1_5200_0000\",\"name\":\"����ʡ����\"},{\"code\":\"D1_5200_5210\",\"name\":\"������ѡ��人��\"}]},{\"code\":\"G1_5200\",\"name\":\"ETC�ɷ�\",\"type\":\"39\",\"categories\":[{\"code\":\"G1_5200_0000\",\"name\":\"����ETC�ɷѣ�������ɫ����ɫ��\"},{\"code\":\"G1_5200_0001\",\"name\":\"����ETC�ɷѣ�������ɫ����ɫ��\"},{\"code\":\"G1_5200_0002\",\"name\":\"����ETC�ɷѣ�������ɫ����ɫ��\"},{\"code\":\"G1_5200_0003\",\"name\":\"����ETC�ɷѣ�������ɫ����ɫ��\"}]},{\"code\":\"S0_5200\",\"name\":\"˰��\",\"type\":\"20\",\"categories\":[{\"code\":\"S0_5200_ACP01\",\"name\":\"������˰\"}]},{\"code\":\"G1_5200\",\"name\":\"��ͨ����\",\"type\":\"26\",\"categories\":[{\"code\":\"G1_5200_0004\",\"name\":\"������ͨ����ɷ�\"}]},{\"code\":\"I1_5200\",\"name\":\"�̻����\",\"type\":\"44\",\"categories\":[{\"code\":\"I1_5200_0600\",\"name\":\"�����Ź̻���\"}]},{\"code\":\"S2_5200\",\"name\":\"ҽ�Ƴ�ֵ\",\"type\":\"47\",\"categories\":[{\"code\":\"S2_5200_0000\",\"name\":\"������֮·�˻���ֵ��\"}]}]";

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
