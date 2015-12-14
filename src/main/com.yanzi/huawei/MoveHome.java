package com.yanzi.huawei;
/*这是华为第二轮比赛的笨笨熊搬家打包题目，给定纸盒的容积及物品数N，和每个物品的大小，
 * 追求纸盒最大使用率，求用的最少纸盒数
 * 网上说法一：最小加最大
 * 网上说法二： 最大加可加入的次最大
 * 我认为 这两种方法都是不对的，一个反例是： 10 3 1 1 1 ，结果应该是只需要一个纸盒，但上述两种方法都需要两个
 * 这个题目中，值得借鉴的是 先对数组排序这个做法。
 * 我的第一反应是用背包问题的递归方法，但是这样可能会由于数组的未排序而降低效率。
 * */
import java.util.Arrays;
import java.util.Scanner;
public class MoveHome {
  public static void main(String[] args){
	  Scanner fin = new Scanner(System.in);
	  int Vo = fin.nextInt();
	  int Num = fin.nextInt();
	  int[] bag = new int[Num];
	  boolean[] marked = new boolean[Num];
	  int count = 0;
	  //用来记录一个包是不是最后一个，如果是的话count也是要加1的  
	  int flag = 0;   
 	  for(int i = 0; i < Num; i++){
		  bag[i] = fin.nextInt();
		  marked[i] = false;
	  }
 	  Arrays.sort(bag);//sort the array firstly
 	  
 	  /*从最大的数开始，找到能跟它装到一个袋子里的所有物品（只要还未满，则继续找），
 	   * 直到所有物品都被打包
 	   * */
 	  for(int i = Num-1; i >= 0; i--){
 		 if(marked[i] == false){
	 		 int temp = bag[i];
	 		 marked[i] = true;
	 		 flag++;
	 		 // if there is only one thing that is not bagged, count should +1
	 		 if(flag == Num-1){
	 			 count++;
	 		 }
	 		 for(int j = i-1; j >=0; j--){
	 			 if(marked[j] == false){
	 				 temp += bag[j];
	 				 if(temp < Vo){
	 					 marked[j] = true;
	 					 flag++;
	 					 continue;
	 				 }
	 				 else if(temp == Vo){
	 					 marked[j] = true;
	 					 flag++;
	 					 count++;
	 					 break;
	 				 }
	 				 else{
	 					 count++;
	 					 break;
	 				 }
	 			 }
	 			//如果是已经打包过的物品，跳过
	 			 else
	 				 continue;	 			
	 		 }
 		 }
 		 //如果是已经打包过的物品，跳过
 		 else{

 			continue;
 		 }
 			 
 	  }//end the biggest for
 	  
 	  if(count == 0)
 		  count = 1;
	  System.out.println(count);
	  
  }
}
