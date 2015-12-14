package com.yanzi.otherTests;

import java.util.concurrent.locks.*;
class  Resource
{
	Lock lock = new ReentrantLock();//��
	Condition condition_pro = lock.newCondition();//������condition
	Condition condition_con = lock.newCondition();//������condition

	int[] items = new int[100];//��������С
	int count = 0;//��ǰ����������Ʒ��Ŀ
	int putPtr = 0;//������ָ��
	int takePtr = 0;//������ָ��
	
	//������
	public void put(int x)throws InterruptedException
	{
		lock.lock();//����
		try{
			//������������ˣ��������߽��̵ȴ�
			while(count == items.length)
				condition_pro.await();
			//�򻺳�����д������
			items[putPtr] = x;
			System.out.println("putting");
			if(++ putPtr == items.length) putPtr = 0;
			++ count;
			//���������߽�������ȡ����
			condition_con.signal();
		}finally{
			lock.unlock();
		}
	}
	public int take()throws InterruptedException
	{
		lock.lock();//����
		try{
			//��������û�����ݿɶ�����ȴ�
			while(count == 0)
				condition_con.await();
			//��ȡ����������
			int x = items[takePtr];
			if(++ takePtr == items.length) takePtr = 0;
			-- count;
			//���������߽���������Ʒ
			condition_pro.signal();
			System.out.println("taking"+x);
			return x;
		}
		finally{
			lock.unlock();
		}
	}
	
}
class Consumer implements Runnable
{
	Resource res;
	Consumer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try{
					int x = res.take();
				    System.out.println("������Ʒ........"+x);
				}
				catch(InterruptedException e)
				{

				}
		}
	}
}
class Producer implements Runnable
{
	private int x = 0;
	Resource res;
	Producer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("������Ʒ....."+x);
				res.put(x++);
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}
public class ProdcerConsumerDemo
{
	public static void main(String[] args) 
	{
		Resource obj = new Resource();
        
		Thread t1 = new Thread(new Producer(obj));
		Thread t2 = new Thread(new Producer(obj));
		Thread t3 = new Thread(new Consumer(obj));
		Thread t4 = new Thread(new Consumer(obj));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}