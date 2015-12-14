package com.yanzi.swordOffer;

import java.util.Scanner;

//实现excel中的26进制  A1 B2 C3 ....Z26 AA27 AB28....
public class Digit26 {
	public static void main(String[] args){
		Digit26 test = new Digit26();
		Scanner fin = new Scanner(System.in);
		String str = fin.nextLine();
		System.out.println(test.digit26(str));
	}
	public int digit26(String str){
		String dirct = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int result = 0;
		//从第一位开始遍历
		for(int i = 0; i < str.length(); i++){
			char t = str.charAt(i);
			int index = dirct.indexOf(t)+1;
			result = 26*result + index;		
			//这里都不需要考虑非法输入了，因为非法输入的结果都是0
		}
		return result;
	}
}
