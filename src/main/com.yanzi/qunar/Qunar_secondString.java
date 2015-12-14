package com.yanzi.qunar;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


//一个字符串的第一个第二次出现的字符 

public class Qunar_secondString {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		String str = fin.nextLine();
		System.out.println(secondStr(str));
		
	}
	public static String secondStr(String str){
		Set<String> strOnce = new HashSet<String> ();
		String[] arrStr = str.split("");
		for(int i = 0; i < arrStr.length; i++){
			if(!strOnce.contains(arrStr[i])){
				strOnce.add(arrStr[i]);
			}
			else{
				return arrStr[i];
			}
		}
		return null;
	}
	

}
