package com.yanzi.ccf;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//public class MenJinXT {
//	//public void run() {
//	public  static void main(String[] args){
//		Scanner fin = new Scanner(System.in);
//		int n = fin.nextInt();
//
//	   Map<Integer,Integer> count = new HashMap();
//		for(int i = 0; i < n; i++){
//			int record = fin.nextInt();
//			if(count.containsKey(record)){
//				int cont = count.get(record);
//				count.put(record, ++cont);
//				System.out.print(cont+" ");
//			}
//			else{
//			count.put(record,1);
//			System.out.print(1+" ");
//			}
//		}
//
//	}
//}
public class MenJinXT{

	  public static void main(String[] args){
	     Scanner fin = new Scanner(System.in);
	     int n = fin.nextInt();
	     Map<Integer,Integer> count = new HashMap<>();
	     for(int i = 0; i < n; i++){
			int record = fin.nextInt();
			if(count.containsKey(record)){
			    int cont = count.get(record);
			    count.put(record, ++cont);
			    System.out.print(cont+" ");}
			else{
			    count.put(record,1);
			    System.out.print(1+" ");}
		    }
	  }
	}