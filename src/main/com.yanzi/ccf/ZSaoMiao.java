package com.yanzi.ccf;

import java.util.Scanner;

public class ZSaoMiao {
	static Scanner fin = new Scanner(System.in);
	static boolean flag1, flag2;
	static int n ;
	static int[][] arr;
	static int i, j;
	//��flag1��Ϊ���ƻ����Ƶı�־��Ϊ��ʱ���ƣ�Ϊ��ʱ����
	//��flag2��Ϊб�ϻ�б�µı�־��Ϊ��ʱб�ϣ�Ϊ��ʱб��
	public static void move(){
		if(flag1){
			System.out.print(arr[i][++j]+" ");
		}
		else{
			System.out.print(arr[++i][j]+" ");
		}
		flag1 = !flag1;		
	}
	public static void moveX(){
		while(flag2){
			System.out.print(arr[--i][++j]+" ");
			if(i == 0 || j == n-1){
				flag2 = !flag2;
				return;
			}
		}
		while(!flag2){
			System.out.print(arr[++i][--j]+" ");
			if(j == 0 || i == n-1){
				flag2 = !flag2;
				return;
			}
		}
		
	}
	public static void main1(String[] args){
		n = fin.nextInt();
		arr = new int[n][n];
		for(i = 0; i < n; i++){
			for(j = 0; j < n; j++){
				arr[i][j] = fin.nextInt();
			}
		}
		System.out.print(arr[0][0]+" ");
		if(n==1){
			return; 
		}
		else{
			i = 0;
			j = 0;
			flag1 = true;
			flag2 = false;
			while(true){
				move();
				if(i == n-1 && j == n-1){
					break;
				}
				moveX();
			 if(i == 0 && j == n-1){
					flag1 = false;
				}
			 else if(i == n-1 && j==0){
				 flag1 = true;
			 }
			}
		}
	}
	

}
