package com.yanzi.huawei;
import java.util.Scanner;
public class DivideApple {
	public static void main(String[] args){
		Scanner fin =  new Scanner(System.in);
		int M = fin.nextInt();
		int N = fin.nextInt();
		System.out.println(process(M,N));
	}

	public static int process(int m, int n){
		if(m == 0 || n == 1)
			return 1;
		else if(m < n)
			return process(m,m);
		else
			return (process(m-n,n)+process(m,n-1));
	}
}
