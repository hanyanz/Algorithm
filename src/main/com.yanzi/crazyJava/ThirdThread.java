package com.yanzi.crazyJava;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread implements Callable<Integer> {
        public Integer call(){
        	int i = 0;
        	for( ; i < 100; i++){
        		System.out.println(Thread.currentThread().getName()+ " " + i);
        	}
        	return i;
        }
        
        public static void main(String[] args){
        	ThirdThread rt = new ThirdThread();
        	FutureTask<Integer> task = new FutureTask<Integer>(rt);
        	for(int i = 0; i < 100; i++){
        		System.out.println(Thread.currentThread().getName()+ " "+i);
        		if(i == 20){
        			new Thread(task, "�з���ֵ�߳�").start();
        		}
        	}                                                                  
        	try{
        		System.out.println("���̷߳���ֵ��" + task.get());
        	}catch (Exception ex){
        		ex.printStackTrace();
        	}
        }
}
