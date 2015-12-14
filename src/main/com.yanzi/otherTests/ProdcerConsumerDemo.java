package com.yanzi.otherTests;

import java.util.concurrent.locks.*;
class  Resource
{
	Lock lock = new ReentrantLock();//锁
	Condition condition_pro = lock.newCondition();//生产者condition
	Condition condition_con = lock.newCondition();//消费者condition

	int[] items = new int[100];//缓冲区大小
	int count = 0;//当前缓冲区的商品数目
	int putPtr = 0;//生产者指针
	int takePtr = 0;//消费者指针
	
	//生产者
	public void put(int x)throws InterruptedException
	{
		lock.lock();//加锁
		try{
			//如果缓冲区满了，则生产者进程等待
			while(count == items.length)
				condition_pro.await();
			//向缓冲区中写入数据
			items[putPtr] = x;
			System.out.println("putting");
			if(++ putPtr == items.length) putPtr = 0;
			++ count;
			//唤醒消费者进程来读取数据
			condition_con.signal();
		}finally{
			lock.unlock();
		}
	}
	public int take()throws InterruptedException
	{
		lock.lock();//加锁
		try{
			//缓冲区中没有数据可读，则等待
			while(count == 0)
				condition_con.await();
			//读取缓冲区数据
			int x = items[takePtr];
			if(++ takePtr == items.length) takePtr = 0;
			-- count;
			//唤醒生产者进程生产产品
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
				    System.out.println("消费商品........"+x);
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
				System.out.println("生产商品....."+x);
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