package com.yanzi.huawei;
/*�����Լ��
 * �ҵ����������������飬���Լ���϶�С�ڵ�����Сֵ�����ж�һ�����ǲ���һ��������ֵ�����Լ��ʱ��Ҳ�Ƿ�����һ��ֵ�����Ͼͽ���
 * �����кܶ���������շת�������ͷ�����������Լ�� MAX��
 * //maxgys��շת������������������Լ�� 
 *	int maxgys(int a,int b){
 *		while(a!=0&&b!=0) a<b?b-=a:a-=b;
 *		return a==0?b:a;}
 * ����max��������������ֵ�����Լ��
 * */
import java.util.Arrays;
import java.util.Scanner;

public class Divisor {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		int Num = fin.nextInt();
		int[] arr = new int[Num];
		for(int i  = 0; i < Num; i++){
			arr[i] = fin.nextInt();
		}
		Arrays.sort(arr);
		for(int i = arr[0]; i >= 1; i--){
			boolean result = isDivisor(arr,i);
			if(result == true){
				System.out.print(i);
				break;
			}
		}
	}
	
   public static boolean isDivisor(int[] arr,int i ){
	   for(int j = 0; j < arr.length; j++){
		   if(arr[j]%i != 0){
			   return false;
		   }
	   }
	   return true;
   }
}
