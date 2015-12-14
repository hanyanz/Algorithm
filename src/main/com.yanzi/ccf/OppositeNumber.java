package com.yanzi.ccf;

import java.util.*;

public class OppositeNumber {
 public static void main(String[] args){
	   new OppositeNumber().run();
	   
   }
   public void run(){
	   Scanner fin = new Scanner(System.in);
	     int N = fin.nextInt();
	     int data;
	     Set<Integer> set = new HashSet<Integer>();
	    for(int i = 0; i < N; i++){
	           data = Math.abs(fin.nextInt());
	        set.add(data);
	    }
	    int result = N-set.size();
	    System.out.println(result);
	  }
   }
 
	

