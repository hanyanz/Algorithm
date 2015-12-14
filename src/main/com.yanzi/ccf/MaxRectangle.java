package com.yanzi.ccf;

import java.util.Scanner;

//思想是以不同的高作为矩形的长，那么比这个条形矮舍弃，
//比这个条形高的可以跟这个参考高度一起拼成一个矩形，增大面积
public class MaxRectangle {
	public static void main(String[] args) {
        new MaxRectangle().run();
     }

    public void run() {
   	 Scanner fin = new Scanner(System.in);
   	 int N = fin.nextInt();
   	 int[] height= new int [N];
   	 for(int i = 0; i < N;++i)
   		 height[i] = fin.nextInt();
   	 
   	 int result = 0;
   	 for(int i = 0; i < N;++i){
   		 int width = 1;
   		 for(int j = i-1; j >= 0; --j){
   			 if(height[j] < height[i])break;
   			 ++width;
   		 }
   		 for(int j = i+1; j < N; ++j){
   			 if(height[j] < height[i])break;
   			 ++width;
   		 }
   		 int area = width *height[i];
   		 result = Math.max(result,area);
   	 }
   		System.out.print(result); 
   	 
    }

}
