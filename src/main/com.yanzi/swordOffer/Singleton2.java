package com.yanzi.swordOffer;

public class Singleton2 {
	//volatile������֤д��ɼ�
	private volatile static Singleton2 uniqueInstance;
	
	//˽�й��췽�����ⲿ�޷�����
	private Singleton2(){}
	
	//��ʵ�������������ٴ���������ֱ�ӷ���
	public  Singleton2 getInstace(){
		if(uniqueInstance == null){
			synchronized(Singleton2.class){
				if(uniqueInstance == null){
					uniqueInstance = new Singleton2();
				}
			}
		}
		return uniqueInstance;
	}
}
