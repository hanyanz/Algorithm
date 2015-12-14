package com.yanzi.swordOffer;

import java.util.Scanner;

/*打印从1到最大的位数
 * 注意：整型或长整型会不会溢出；用循环或递归的话结束的条件是什么；如果前面是0不要打印出来
 * 可以在字符串上模拟数字的加法解法，这里把问题转换成数字排列的解法，递归让代码更简洁*/
public class PrintFrom1ToMaxOfN {

	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();
		PrintFrom1ToMaxOfN test = new PrintFrom1ToMaxOfN();
		test.PrintToMaxOfN( n);	
		System.out.print("\n");
		test.Print1ToMaxOfNChars(n);
	}
	//用递归的方法（begin）
	void PrintToMaxOfN(int n){
		if(n <= 0)
			return;
		//创建一个字符数组来保存每个位上的值
		char[] num = new char[n];
		for(int i = 0; i < 10; i++){
		//先让最高位为0
			num[0] = (char) (i + '0');
			PrintToMaxOfNRecursively(num,n,0);
		}
	}
	void PrintToMaxOfNRecursively(char[] num, int n,int index){
		if(index == (n-1)){
			PrintNumber(num);
			return;
		}
		for(int i = 0; i < 10; i++){
			//让下一位先递增
			num[index+1] = (char)(i +'0');
			PrintToMaxOfNRecursively( num, n, index+1);
		}
	}
	//end of 递归方法
	
	
	//用字符串模拟（begin)
	void Print1ToMaxOfNChars(int n){
		if(n <= 0)
			return;
		char[] num = new char[n];
		//char默认初始化为‘u000’，所以这里要先初始化为‘0’
		for(int i = 0; i < n; i++)
			num[i] = '0';
		while(!Increment(num)){
			PrintNumber(num);
		}
		
	}
	boolean Increment(char[] num){
		boolean isOverflow = false;
		int takeOver = 0;//表示进位
		int length = num.length;
		for(int i = length-1; i >= 0; i--){
			int sum = num[i]-'0'+takeOver;
			if(i == length-1)
				sum++;
			if(sum >= 10){
				if(i == 0)
					//最高位大于9了，要进位则溢出
					isOverflow = true;
				else{
					sum -= 10;
					takeOver = 1;
					num[i] = (char)('0'+sum);
				}
			}
			else{
				num[i] = (char)('0'+sum);
				//每个数字加1后要打印一次
				break;				
			}
		}
		return isOverflow;
		
	}
	//用字符串模拟（end)
	
	
	//通用的打印方法
	void PrintNumber(char[] num){
		boolean isB0 = true;
		int length = num.length;
		for(int i = 0; i < length; i++){
			if(isB0 && num[i] != '0')
				isB0 = false;
			if(!isB0)
				System.out.print(num[i]);
			if((i == length-1)&& (isB0 == true))
				return;
		}
		System.out.print(" ");
	}
}
