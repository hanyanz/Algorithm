package com.yanzi.ccf;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JiHeJinJia {
	
	public static void main(String[] args) {
		Scanner fin = new Scanner(System.in);
		String[] input;
		Record[] array = new Record[5000];  
		Set<Float> po = new HashSet<Float> ();
		float pri=0;//用于记录成交价格
		int deals=0;//用于记录成交量
		int i = 0;
		
		
		while( fin.hasNextLine()){
			input = fin.nextLine().split(" ");
			if(input[0].equals("buy")||input[0].equals("sell")){
				Record record = new Record();
				record.name = input[0];
				record.price = Float.valueOf(input[1]);
				record.num = Integer.valueOf(input[2]);
				array[i++] = record;
				po.add(record.price);		
			}
			else if(input[0].equals("cancel")){
				  int j = Integer.valueOf(input[1]);  
				  if(j-1 < i){
				   array[j-1]=null;
				   i++;
				  }	
				  else  continue;
			}
			else{
				break;
			}
			
		}
		
		for(Float st:po){
			int tembuy = 0;
			int temsell = 0;
			int tem;
			for(int j = 0; j < i; j++){	
				if(array[j] != null){
					if(array[j].name.equals("buy") && (array[j].price >= st)){
						tembuy += array[j].num;
					}
					if(array[j].name.equals("sell")&&(array[j].price <= st)){
						temsell += array[j].num;
					}					
				 }				
			}
			tem = Math.min(tembuy, temsell);
			if(tem > deals){
				deals = tem;
				pri = st;
			}
			
		}
		System.out.print(String.format("%.2f", pri) +" "+deals);
	}
	
	static class Record{
		String name;
		float price;
		int num;
	}

}
