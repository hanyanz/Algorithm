package com.yanzi.crazyJava;

import java.util.Arrays;

public class Num2Rmb {
	private String[] hanArr = {"��", "Ҽ", "��", "��", "��", "��","½","��", "��", "��" };
	private String[] unitArr = {"ʮ", "��", "ǧ","��"};

	/**������λС��*/
	private String[] divide(double num){
		long zheng = (long)num;
		long xiao = Math.round((num-zheng)*100);
		return new String[]{zheng +  "",String.valueOf(xiao)};
		
	}
	
	private String toHanStr(String numStr){
		String result = "";
		int numLen = numStr.length();
		for(int i = 0; i < numLen; i++){
			
			//'0'��ֵΪ48����������ֱ����int num = numStr.charAt(i)-48 Ҳ��
			int num = numStr.charAt(i)-'0';
			if (i != numLen-1&& num !=0){
				result += hanArr[num] + unitArr[numLen -2-i];
			}
			else{
				result += hanArr[num];
			}
		}
		return result;
	}
	
	public static void main( String[] args){
		Num2Rmb nr = new Num2Rmb();
		System.out.println(Arrays.toString(nr.divide(236711123.123)));
		System.out.println(nr.toHanStr("61109"));
	}

}
