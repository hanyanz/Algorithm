package com.yanzi.newCoder;

import java.util.Scanner;

public class IsCharOfStringInOtherString {

	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		String str1 = fin.next();
		String str2 = fin.next();
		isInOtherString(str1,str2);
	}
	public static void isInOtherString(String str1, String str2){
		if(str1 == null || str2 == null)
			return;
		
		int[] result = new int[26];
		int i = 0;
		while( i < str1.length()){
			result[str1.charAt(i)-'a']++;
			i++;
		}
		i = 0;
		StringBuilder inStr1 = new StringBuilder();
		StringBuilder notInStr1 = new StringBuilder();
		while(i < str2.length()){
			if(result[str2.charAt(i)-'a'] == 0){
				notInStr1.append(str2.charAt(i));
			}else{
				inStr1.append(str2.charAt(i));
			}
			i++;
		}
		System.out.println("chars in str1 are:"+ inStr1.toString());
		System.out.println("chars not in str1 are:"+ notInStr1.toString());
	}
}
