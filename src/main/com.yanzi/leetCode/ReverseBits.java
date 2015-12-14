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
		//Integer.toBinaryString(numbInt)会省略开头的0
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
		//如果方法传入的参数二进制以0开头，那么Integer.toBinaryString(numbInt);时会省略掉前面的0，
		//在这里补上，正好是反转后的二进制字符串的后面部分
		 if(charBinary.length < 32){
			 for(int i = 0 ; i < (32-charBinary.length); i++){
				 resultStr.append('0');
			 }			 
		 }
		//resultStr.toString()输出00111001011110000010100101000000，不会去掉开头的0
		 //System.out.println(resultStr.toString());  
		 return(Integer.parseInt(resultStr.toString(), 2));
	}

}
