package com.yanzi.newCoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ToGray {

	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();
		getGrays(n);
	}
	public static void getGrays(int n){
		List<String> result = new LinkedList<String>();
		int[] binary = new int[n];
		
		result.add(getGrayCore(binary));
		
		while(isOverFlow(binary) == false){
			result.add(getGrayCore(binary));			
		}
		
		System.out.println(result);
	}
	//对数组加1并返回数组是否溢出
	private static boolean isOverFlow(int[] binary){
		if(binary == null)
			return false;
		int i = binary.length-1;
		while(i >= 0){
			if(binary[i] == 0){
				binary[i] = 1;
				break;
			}else {
				binary[i] = 0;
				i--;
				if(i == -1){
					return true;
				}
			}
		}
		return false;		
	}
	//对给定数组求格雷码
	private static String getGrayCore(int[] input){
		if(input == null || input.length == 0){
			return null;
		}
		int[] output = new int[input.length];
		int i = input.length-1;
		while(i > 0){
			output[i] = input[i]^input[i-1];
			i--;
		}
		output[0] = input[0];
		String result = Arrays.toString(output).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
		return result;
	}
}
