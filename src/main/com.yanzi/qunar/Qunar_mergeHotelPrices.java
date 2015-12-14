package com.yanzi.qunar;
/*去哪儿实习笔试第三题：实现酒店价格的合并
题目描述：实现以下函数int[][] merge(int[][] dateRangePrice)，
输入是某个酒店多个日期段的价格，每个日期段（终止日期大于起始日期，且终止日期
不会大于1001）和对应的价格使用长度为3的数组表示，例如[0, 100, 300]表示从第一天开始，
到第101天的价格为300，这些日期可能重复，重复的日期以后面的为准，
按要求合并并输出结果：
(1). 相邻两天的价格如果相同，那么这两个日期段合并并输出
(2). 合并的结果应该以起始日期从小到大排序
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Qunar_mergeHotelPrices {
	public static void main(String[] args){
		int[][] dateRangePrices1 = {{0,100,300},{40,50,350}};
		int[][] dateRangePrices2 = {{41,60,250},{1,80,300},{10,40,250}};
		for(int[] ss:merge(dateRangePrices2)){
			for(int i = 0; i < 3; i++){
				System.out.print(ss[i]+" ");
			}
			System.out.println();
		}
	}
	
	public static List<int[]> merge(int[][] dateRangePrices){	
		
		//这里理解为重复的日期，以后面日期定的价格为准，所以需要先排序
		  sort(dateRangePrices);
		  int[] rangePrice = new int[1001];
		  Arrays.fill(rangePrice, -1);
		  
		  //预处理，得到每天的酒店价格
		  for(int i = 0; i < dateRangePrices.length; i++){
			  for(int j = dateRangePrices[i][0]; j <= dateRangePrices[i][1]; j++){
				  rangePrice[j] = dateRangePrices[i][2];
			  }
		  }
		  		 
		  /*这里不能直接用int[] temp = new int[3]来保存每次循环的值，再result.add(temp)
		   * 因为这样是把temp的引用加到result中了，当temp值改变的时候，result所有的对象都一样改变
		  */		  
		  //合并价格和日期，得到不同时段的价格信息
		  List<int[]> result = new ArrayList<int[]>();
		  int p0 = -1;
		  int p1 = -1;
		  int p2 = -1;
		  for(int i = 0; i < 1001; i++){
			  while(rangePrice[i] == -1){
				  i++;
				  if(i == 1001)
					  break;
			  }
			  if(i >= 1001){
				  break;
			  }
			  p0 = i;
			  p2 = rangePrice[i];
			  while(p2 == rangePrice[i]){
				  i++;
			  }
			  p1 = --i;
			  
			  int[] temp = {p0, p1, p2};
			  result.add(temp);
		  }
		  return result;			 
	}
	
   public static int[][] sort(int[][] dateRangePrices){
	   for(int i = 0; i < dateRangePrices.length; i++){
		     for(int j = i+1; j < dateRangePrices.length; j++ ){
		    	 int[] temp = new int[3];
		    	 if(dateRangePrices[i][0] > dateRangePrices[j][0]){
		    		 temp = dateRangePrices[i];
		    		 dateRangePrices[i] = dateRangePrices[j];
		    		 dateRangePrices[j] = temp;		    		 
		    	 }
		     }
	   }
	   return  dateRangePrices;
   }
}
