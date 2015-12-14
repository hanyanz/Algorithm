package com.yanzi.swordOffer;

import java.util.Arrays;
import java.util.Scanner;

/*ͳ��һ�����������������г��ֵĴ���
 * �����õ��˶��ַ����ֱ��ҵ������������е�һ�κ����һ�γ��ֵ�λ��
 * */
public class CountInArray {

	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		String[] input = fin.nextLine().split(" ");
		int[] arr = new int[input.length];
		for(int i = 0; i < input.length; i++){
			arr[i] = Integer.valueOf(input[i]);
		}
//������һ�飬ʹ�������������Բ�������������ģ�
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
			//��֤���������ҵõ����ֵ�һ�κ����һ�γ��ֵ�λ�ã���Ȼ�϶����޽����
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
