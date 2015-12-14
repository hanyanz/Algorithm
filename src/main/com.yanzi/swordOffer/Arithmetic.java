package com.yanzi.swordOffer;
//用位运算实现加减乘除法

public class Arithmetic {
	public static void main(String[] args){
		int num1 = 0;
		int num2 = -24;
		System.out.println(Add(num1,num2));
		System.out.println(AddRecursion(num1,num2));
		System.out.println(Substruction(num1,num2));
	}
	//用循环做加法
	public static int Add(int num1,int num2){
		int sum = 0;
		int carry = 0;
		do{
			sum = num1 ^ num2;
			carry = (num1 & num2)<<1;
			num1 = sum;
			num2 = carry;			
		}while(num2 != 0);
		return num1;
	}
	//用递归做加法
	public static int AddRecursion(int num1,int num2){
		if(num2 == 0) return num1;
		int sum, carry;
		sum = num1 ^ num2;
		carry = (num1 & num2)<<1;
		return AddRecursion(sum,carry);
	}
	//减法
	public static int Substruction(int num1,int num2){
		//补码加1，得到一个数的相反数
		int temp = Add(~num2,1);
		return Add(num1,temp);
	}
	
	//TODO 乘除法的实现
	/*乘法就是将乘数写成(2^0)*k0 + (2^1)*k1 + (2 ^2)*k2 + ... + (2^31)*k31，
	 * 其中ki为0或1，然后利用位运算和加法就可以了。*/
	
	
	

}
