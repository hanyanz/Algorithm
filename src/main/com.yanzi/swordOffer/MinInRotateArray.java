package com.yanzi.swordOffer;

import java.util.Scanner;

/*旋转数组的最小数字:输入是一个递增排序的一个旋转，输出数组的最小元素
 * 这道题要考虑特例： 1数组长度为0 ；2 旋转后正好还是一个递增排序 ；
 * 3 数组中某几个值是一样的，特别是首尾的数相同，但中间有较小的数
 * 
 * 这里考查的实际上就是对二分查找的灵活运用*/
public class MinInRotateArray {
	public static void main(String[] args){
		MinInRotateArray test = new MinInRotateArray();
		test.run();
	}
	public void run(){
		Scanner fin = new Scanner(System.in);
		String[] str = fin.nextLine().split(" ");
		int[] arr = new int[str.length];
		for(int i = 0; i < str.length; i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		int i =  findMin(arr);
        if(i != Integer.MAX_VALUE)
        	System.out.println(i);
	}
	public  int findMin(int[] arr){	
		if(arr.length == 0){
			System.out.println("Invalid parameters");
			return Integer.MAX_VALUE;
		}
		
		if(arr[0] < arr[arr.length-1])
			return arr[0];
		
		int start = 0;
		int end = arr.length -1;
		int mid = (start+end)/2;
		while(arr[start]>= arr[end]){		
			if(end-start == 1){
				mid = end;
				break;
			}
		     mid = (start+end)/2;
			if(arr[start] == arr[end] && arr[start] == arr[mid]){
					return MinInOrder(arr,start,end);
			}
			if(arr[start] <= arr[mid])
				start = mid;
			else if(arr[end] >= arr[mid])
			     end = mid;
		}
		return arr[mid];
	}
	
	 int MinInOrder(int[] arr, int start,int end){
		 int result = arr[start];
		 for(int i = start+1; i < end; i++){
			 if(result > arr[i])
				 result = arr[i];
		 }
		 return result;
	 }
	}
		

