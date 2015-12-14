package com.yanzi.leetCode;

import java.util.Scanner;

/**Reverse bits of a given 32 bits unsigned integer.
For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).
 * */
public class ReverseBits {
	public static void main(String[] args){
		ReverseBits test = new ReverseBits();
		Scanner fin = new Scanner(System.in);
		int numbInt = fin.nextInt();
		System.out.println(test.getReverseBits(numbInt));
	}
	private Integer getReverseBits(Integer numbInt){	
		//Integer.toBinaryString(numbInt)��ʡ�Կ�ͷ��0
		char[] charBinary = Integer.toBinaryString(numbInt).toCharArray(); 
		StringBuffer resultStr = new StringBuffer();
	   
		int left = 0;
		int right = charBinary.length-1;
		char temp ;
		while(left < right){
			temp = charBinary[left];
			charBinary[left] = charBinary[right];
			charBinary[right] = temp;
			left++;
			right--;
			
		}
		resultStr.append(charBinary);
		//�����������Ĳ�����������0��ͷ����ôInteger.toBinaryString(numbInt);ʱ��ʡ�Ե�ǰ���0��
		//�����ﲹ�ϣ������Ƿ�ת��Ķ������ַ����ĺ��沿��
		 if(charBinary.length < 32){
			 for(int i = 0 ; i < (32-charBinary.length); i++){
				 resultStr.append('0');
			 }			 
		 }
		//resultStr.toString()���00111001011110000010100101000000������ȥ����ͷ��0
		 //System.out.println(resultStr.toString());  
		 return(Integer.parseInt(resultStr.toString(), 2));
	}

}
