package com.yanzi.ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*p窗口，某系统中打开了N个窗口，每个窗口都是矩形，点击某个窗口时它会移动到
 * 最顶层   WindowClick 这个得了满分哦
 * */
public class WindowClick {
	  List<Window> windowList = new ArrayList<Window>();
         class Window{
        	 private int  xC1,xC2;
        	 private int yC1,yC2;
        	 private int count;
        	 public void setCount(int count){
        		 this.count = count;
        	 }
        	 public Window(int x1,int y1,int x2,int y2){
        		 xC1 = x1;
        		 xC2 = x2;
        		 yC1 = y1;
        		 yC2 = y2;
        	 }
         }
         public void addWindow(int count,int x1,int y1,int x2,int y2){
    		 Window con = new Window(x1,y1,x2,y2);
    		 con.setCount(count);
    		 windowList.add(0,con); //每一次的窗口加到List最前面
    	 }
         
         public void clickWindow(int x,int y){
        	int i = 1;
        	 for( Window s: windowList){
        		 if((x >= s.xC1)&&(x <= s.xC2)&&( y >= s.yC1)&&(y <= s.yC2)){       			
        			 windowList.remove(s);//再把窗口原来位置删除	
        			 windowList.add(0, s);//先置顶
        			 System.out.println(s.count);
        			 break;
        		 }
        		 else i++;
        		 
        	 }
        	 if(i > windowList.size())
        	    System.out.println("IGNORED");
         }
         
         public static void main(String[] args){
        	 WindowClick  test = new WindowClick();
        	 Scanner fin = new Scanner(System.in);
              String[] num = fin.nextLine().split(" ");
        	// int N = Integer.valueOf(num[0]).intValue();
              int N = Integer.valueOf(num[0]);
        	 int M = Integer.valueOf(num[1]);  
        //	 System.out.println(N+M);
        	 for(int i = 0 ; i < N; i++){
        		 String[] temp = fin.nextLine().split(" ");
        		 int[] tempwin = new int[4];
        		 for(int j = 0; j < 4; j++ ){
        			 tempwin[j] = Integer.valueOf(temp[j]).intValue();			 
        		 }
        		 test.addWindow(i+1,tempwin[0], tempwin[1], tempwin[2],tempwin[3]);
        		 
        	 }
        	 for(int i = 0; i < M; i++){
        		 String[] temp = fin.nextLine().split(" ");
        		 int[] tempwin = new int[2];
        		 for(int j = 0; j< 2; j++){
        		     tempwin[j] = Integer.valueOf(temp[j]).intValue();
        		 }
        		 test.clickWindow(tempwin[0],tempwin[1]);
        	 }
         }
         
}
