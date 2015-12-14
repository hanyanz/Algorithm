package com.yanzi.huawei;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class TLVDecode{
   public static void main(String[] args){
	Scanner fin = new Scanner(System.in);
	String input  = fin.nextLine();
	fin.close();
	int i = 0;
	Map<Integer,String> result = new TreeMap<Integer,String>();
	while( i < input.length()-12){
		int tagT = Integer.valueOf(input.substring(i,i+8),16);
		int lengthT = Integer.valueOf(input.substring(i+8,i+12),16);
		if( input.length()-i-12 >= lengthT*2){
			String info =  input.substring(i,i+12+lengthT*2);
			result.put(tagT,info);			
		}
		else{
		 System.out.println("msgerr");
		 break;
		}
		i = i+12+lengthT*2;
	}

	 Iterator<Integer> it = result.keySet().iterator();  
     while (it.hasNext()) {  
         //it.next()得到的是key，tm.get(key)得到obj  
         System.out.print(result.get(it.next()));  
     }  
 }  
	 
}