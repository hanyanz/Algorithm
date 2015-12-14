package com.yanzi.newCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class bagPromble {
	public static void main(String[] args){
		int[] bagWeights = {1,2,3,4,5,6,7};
		int totalWeight = 12;
		ArrayList<Integer> result = getBags(bagWeights, totalWeight);
		if(result == null){
			System.out.println("no solution exits");
			return;
		}
		for(Integer i: result){
			System.out.print(i);
			System.out.print(" ");
		}
	}
	private static ArrayList<Integer> getBags(int[] bagWeights, int totalWeight){
		ArrayList<Integer> target = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Arrays.sort(bagWeights);
		int tempTotal = 0;
	
		for(int i = bagWeights.length-1; i > 0; i--){
			stack.push(bagWeights[i]);
			tempTotal += bagWeights[i];
			for(int j = i-1; j >= 0; j--){
				if(tempTotal == totalWeight){
					while(stack.size() > 0){
						target.add(stack.pop());
					}
					return target.size() == 0? null:target;
				}
				if(tempTotal > totalWeight){
					if(j == 0){
						stack.clear();
						tempTotal = 0;
					}
					if(stack.size() > 0){
						tempTotal = tempTotal - stack.peek();
						stack.pop();
						j++;  //这里应判断的是上一个结果与目标值的大小，pop一个数后，对数组遍历来说，并没有影响进度
					}
					continue;
				}
				else{
					if(j == 0){
						return null;
					}
					stack.push(bagWeights[j]);
					tempTotal += bagWeights[j];
				}			
			}
			
		}
		while(stack.size() > 0){
			target.add(stack.pop());
		}
		return target.size() == 0? null:target;
	}
	
}
