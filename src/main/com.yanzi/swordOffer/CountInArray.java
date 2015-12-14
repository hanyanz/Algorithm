package com.yanzi.swordOffer;

import java.util.Arrays;
import java.util.Scanner;

/*统计一个数字在排序数组中出现的次数
 * 这里用到了二分法，分别找到数字在数组中第一次和最后一次出现的位置
 * */
public class CountInArray {

	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		String[] input = fin.nextLine().split(" ");
		int[] arr = new int[input.length];
		for(int i = 0; i < input.length; i++){
			arr[i] = Integer.valueOf(input[i]);
		}
//加上这一块，使得输入的数组可以不用是排序数组的，
		 Arrays.sort(arr);
		int k = fin.nextInt();	     
		System.out.println(GetNumberOfK(arr,k));
		
	}
	public static int GetNumberOfK(int[] arr, int k ){
		int number = 0;
		if(arr != null && arr.length > 0){
			int first = GetFirst(arr, k, 0, arr.length-1);
			int last = GetLast(arr,k,0,arr.length-1);
			System.out.println(first+" "+last);
			//保证在数组中找得到数字第一次和最后一次出现的位置，不然肯定是无结果的
			if(first > -1 && last > -1)
				number = last-first+1;
		}
		return number;
	}
	public static int GetFirst(int[] arr, int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		int data = arr[mid];
		if(data == k){
			if((mid > 0 && arr[mid-1]!= k)||mid == 0)
				return mid;
			else
				end = mid-1;
		}
		else if(data > k)
			end = mid-1;
		else
			start = mid+1;
		return GetFirst(arr, k ,start, end);
	}
	public static int GetLast(int[] arr, int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start+end)/2;
		int data = arr[mid];
		if(data == k){
			int length = arr.length-1;
			if((mid < length && arr[mid+1]!= k)|| mid == length)
				return mid;
			else
				start = mid+1;
		}
		else if(data > k)
			end = mid-1;
		else
			start = mid+1;
		return GetLast(arr,k,start,end);
	}
}
