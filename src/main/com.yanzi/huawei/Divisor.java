package com.yanzi.huawei;
/*求最大公约数
 * 我的做法是先排序数组，最大公约数肯定小于等于最小值，在判断一个数是不是一个数组中值的最大公约数时，也是发现有一个值不符合就结束
 * 网上有很多做法是用辗转相减法求头两个数的最大公约数 MAX，
 * //maxgys用辗转相减法求两个数的最大公约数 
 *	int maxgys(int a,int b){
 *		while(a!=0&&b!=0) a<b?b-=a:a-=b;
 *		return a==0?b:a;}
 * 再用max依次与数组后面的值求最大公约数
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
