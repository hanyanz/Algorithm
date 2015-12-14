package com.yanzi.ccf;

import java.util.*;


//201409-2


public class ShuDui {
	public static void main(String[] args) {
	     new ShuDui().run();
	}
	
	public void run() {
		Scanner fin = new Scanner(System.in);
		int n = fin.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n ; i++)
			arr[i] = fin.nextInt();
		
		int count = 0;
		for(int p = 0; p < n; p++){
			for(int q = p+1; q < n; q++){
				int s = arr[p]-arr[q];
				if(Math.abs(s)== 1)
					count++;
			}
		}
	System.out.print(count)	;
	}

}
