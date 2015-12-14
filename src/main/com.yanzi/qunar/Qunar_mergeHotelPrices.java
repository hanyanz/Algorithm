package com.yanzi.qunar;
/*ȥ�Ķ�ʵϰ���Ե����⣺ʵ�־Ƶ�۸�ĺϲ�
��Ŀ������ʵ�����º���int[][] merge(int[][] dateRangePrice)��
������ĳ���Ƶ������ڶεļ۸�ÿ�����ڶΣ���ֹ���ڴ�����ʼ���ڣ�����ֹ����
�������1001���Ͷ�Ӧ�ļ۸�ʹ�ó���Ϊ3�������ʾ������[0, 100, 300]��ʾ�ӵ�һ�쿪ʼ��
����101��ļ۸�Ϊ300����Щ���ڿ����ظ����ظ��������Ժ����Ϊ׼��
��Ҫ��ϲ�����������
(1). ��������ļ۸������ͬ����ô���������ڶκϲ������
(2). �ϲ��Ľ��Ӧ������ʼ���ڴ�С��������
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
		
		//�������Ϊ�ظ������ڣ��Ժ������ڶ��ļ۸�Ϊ׼��������Ҫ������
		  sort(dateRangePrices);
		  int[] rangePrice = new int[1001];
		  Arrays.fill(rangePrice, -1);
		  
		  //Ԥ�����õ�ÿ��ľƵ�۸�
		  for(int i = 0; i < dateRangePrices.length; i++){
			  for(int j = dateRangePrices[i][0]; j <= dateRangePrices[i][1]; j++){
				  rangePrice[j] = dateRangePrices[i][2];
			  }
		  }
		  		 
		  /*���ﲻ��ֱ����int[] temp = new int[3]������ÿ��ѭ����ֵ����result.add(temp)
		   * ��Ϊ�����ǰ�temp�����üӵ�result���ˣ���tempֵ�ı��ʱ��result���еĶ���һ���ı�
		  */		  
		  //�ϲ��۸�����ڣ��õ���ͬʱ�εļ۸���Ϣ
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
