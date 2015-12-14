package com.yanzi.qunar;

//依据给定序列从大到小排列字符串

public class Qunar_StringCompare {
	
	public static void main(String[] args){
		String[] input = {"dog","deab","bof"};
		for(int i = 0; i < input.length; i++){
			for(int j = i+1; j < input.length; j++){
				int result = compareS(input[i], input[j]);
				if(result == -1){
					String temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		for(String s :input){
			System.out.print(s+" ");
		}
	}
	public static int compareS(String str1, String str2){
		int len = Math.min(str1.length(), str2.length());
		int result = 0;
		for(int i = 0 ; i < len ; i++){
			result = compareC(str1.charAt(i),str2.charAt(i));
			if(result == 1){
				break;
			}
			else if(result == -1){
				break;
			}
		}
		return result;
	}
	public static int compareC(char a,char b){
		char[] chart ={'d', 'g', 'e', 'c', 'f', 'b', 'o', 'a'};
		String ss = new String(chart);
		int first = ss.indexOf(a);
		int last = ss.indexOf(b);
		if(first < last){
			return 1;
		}
		else if(first == last){
			return 0;
		}
		else
			return -1;		
	}
	

}
