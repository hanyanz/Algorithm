package com.yanzi.ccf;

//the result is not right

import java.util.Scanner;

public class Paint {
	public static void main(String[] args) {
        new  Paint().run();
     }

    public void run() {
   	 Scanner fin = new Scanner(System.in);
    	int rows = fin.nextInt();
    	int [][] arr = new int[rows][4];
    	int count = 0;
    	
    	for(int i = 1; i <= rows; ++i){
    		for(int j = 1; j <= 4; ++j)
    			arr[i-1][j-1] = fin.nextInt();
    	}
    	 for(int i = 0; i < rows; i++){
    		 for(int j = 0; j < 4; j++)
    			 System.out.print(arr[i][j]+" "); 
    	 }
    	 
    	 boolean[][] area = new boolean[100][100];
    	 for(int i = 0; i < rows; i++){
           int rowStart = arr[i][0]+1; int rowEnd = arr[i][2];
           int colStart = arr[i][1]+1; int colEnd = arr[i][3];
    		 for(int p =  rowStart; p < rowEnd; p++){
    			 for(int q =  colStart;q < colEnd; q++)
    				 area[p][q] = true;
    		 }
    	 }
    	 
    	 for(int i = 0; i < 100; i++){
    		 for(int j = 0; j < 100; j++){
    			 System.out.print( area[i][j]+" ");
    			 if(area[i][j] == true)
    				 count++;
    		 }
    		 System.out.print( "\n ");
    	 }
    	 System.out.print(count);
      
    
    }
   
}
