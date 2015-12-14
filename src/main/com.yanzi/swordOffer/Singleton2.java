package com.yanzi.swordOffer;

public class Singleton2 {
	//volatile变量保证写后可见
	private volatile static Singleton2 uniqueInstance;
	
	//私有构造方法，外部无法访问
	private Singleton2(){}
	
	//无实例，则先锁定再创建，有则直接返回
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
