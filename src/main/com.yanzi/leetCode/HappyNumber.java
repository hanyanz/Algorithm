package com.yanzi.leetCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**A happy number is a number defined by the following process: Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits, and repeat the process until 
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers.
    Example: 19 is a happy number
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1 
    思路：用hashMap保存已出现过的数字
     * */
public class HappyNumber {
	public static void main(String[] args){
		HappyNumber test = new HappyNumber();
		Scanner fin = new Scanner(System.in);
		int positiveInt = fin.nextInt();
		if(positiveInt <= 0){
			System.out.println("the number is not positiveInt");
			return;
		}
		if(test.isHappy(positiveInt)){
			System.out.println(positiveInt + " is a happy number!");
			return;
		}else{
			System.out.println(positiveInt + " is not a happy number!");
		}
	}
	
	private boolean isHappy(int positiveInt){
		Set<Integer> resultSet = new HashSet<Integer>();
		int tempInt;
		int squar;
		while(true){
			if(positiveInt == 1 ){
				return true;
			}
			else if(resultSet.contains(positiveInt)){
				return false;
			}
			tempInt = positiveInt;
			resultSet.add(positiveInt);
			positiveInt = 0;
			while(tempInt != 0){
				squar = tempInt%10;
				positiveInt += squar*squar;
				tempInt = tempInt/10;
			}
		}
	}

}
