package com.yanzi.swordOffer;

import java.util.Scanner;

//ʵ��excel�е�26����  A1 B2 C3 ....Z26 AA27 AB28....
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
		//�ӵ�һλ��ʼ����
		for(int i = 0; i < str.length(); i++){
			char t = str.charAt(i);
			int index = dirct.indexOf(t)+1;
			result = 26*result + index;		
			//���ﶼ����Ҫ���ǷǷ������ˣ���Ϊ�Ƿ�����Ľ������0
		}
		return result;
	}
}
