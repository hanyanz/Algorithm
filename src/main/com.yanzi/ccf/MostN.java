package com.yanzi.ccf;

import java.util.*;

public class MostN {
   public static void main (String[] args){
	   new MostN().run();
   }
   public void run(){
	   Scanner fin = new Scanner(System.in);
	   int N = fin.nextInt();
	   int[] count = new int[10001];
	   for(int i = 0; i < N; ++i){
		   ++count[fin.nextInt()];
	   }
	   int maxCount = -1;
	   int result = 0;
	   for(int i = 1; i <= 10000; ++i){
		   if (count[i] > maxCount){
			   maxCount = count[i];
			   result = i;
		   }
	   }
	   System.out.println(result);
   }
	
	
}
