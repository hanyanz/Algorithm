package com.yanzi.swordOffer;
//��λ����ʵ�ּӼ��˳���

public class Arithmetic {
	public static void main(String[] args){
		int num1 = 0;
		int num2 = -24;
		System.out.println(Add(num1,num2));
		System.out.println(AddRecursion(num1,num2));
		System.out.println(Substruction(num1,num2));
	}
	//��ѭ�����ӷ�
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
	//�õݹ����ӷ�
	public static int AddRecursion(int num1,int num2){
		if(num2 == 0) return num1;
		int sum, carry;
		sum = num1 ^ num2;
		carry = (num1 & num2)<<1;
		return AddRecursion(sum,carry);
	}
	//����
	public static int Substruction(int num1,int num2){
		//�����1���õ�һ�������෴��
		int temp = Add(~num2,1);
		return Add(num1,temp);
	}
	
	//TODO �˳�����ʵ��
	/*�˷����ǽ�����д��(2^0)*k0 + (2^1)*k1 + (2 ^2)*k2 + ... + (2^31)*k31��
	 * ����kiΪ0��1��Ȼ������λ����ͼӷ��Ϳ����ˡ�*/
	
	
	

}
