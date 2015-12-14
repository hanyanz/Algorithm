package com.yanzi.swordOffer;

import java.util.Scanner;

/*��ӡ��1������λ��
 * ע�⣺���ͻ����ͻ᲻���������ѭ����ݹ�Ļ�������������ʲô�����ǰ����0��Ҫ��ӡ����
 * �������ַ�����ģ�����ֵļӷ��ⷨ�����������ת�����������еĽⷨ���ݹ��ô�������*/
public class PrintFrom1ToMaxOfN {

	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();
		PrintFrom1ToMaxOfN test = new PrintFrom1ToMaxOfN();
		test.PrintToMaxOfN( n);	
		System.out.print("\n");
		test.Print1ToMaxOfNChars(n);
	}
	//�õݹ�ķ�����begin��
	void PrintToMaxOfN(int n){
		if(n <= 0)
			return;
		//����һ���ַ�����������ÿ��λ�ϵ�ֵ
		char[] num = new char[n];
		for(int i = 0; i < 10; i++){
		//�������λΪ0
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
			//����һλ�ȵ���
			num[index+1] = (char)(i +'0');
			PrintToMaxOfNRecursively( num, n, index+1);
		}
	}
	//end of �ݹ鷽��
	
	
	//���ַ���ģ�⣨begin)
	void Print1ToMaxOfNChars(int n){
		if(n <= 0)
			return;
		char[] num = new char[n];
		//charĬ�ϳ�ʼ��Ϊ��u000������������Ҫ�ȳ�ʼ��Ϊ��0��
		for(int i = 0; i < n; i++)
			num[i] = '0';
		while(!Increment(num)){
			PrintNumber(num);
		}
		
	}
	boolean Increment(char[] num){
		boolean isOverflow = false;
		int takeOver = 0;//��ʾ��λ
		int length = num.length;
		for(int i = length-1; i >= 0; i--){
			int sum = num[i]-'0'+takeOver;
			if(i == length-1)
				sum++;
			if(sum >= 10){
				if(i == 0)
					//���λ����9�ˣ�Ҫ��λ�����
					isOverflow = true;
				else{
					sum -= 10;
					takeOver = 1;
					num[i] = (char)('0'+sum);
				}
			}
			else{
				num[i] = (char)('0'+sum);
				//ÿ�����ּ�1��Ҫ��ӡһ��
				break;				
			}
		}
		return isOverflow;
		
	}
	//���ַ���ģ�⣨end)
	
	
	//ͨ�õĴ�ӡ����
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
