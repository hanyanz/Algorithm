package com.yanzi.huawei;
/*���ǻ�Ϊ�ڶ��ֱ����ı����ܰ�Ҵ����Ŀ������ֽ�е��ݻ�����Ʒ��N����ÿ����Ʒ�Ĵ�С��
 * ׷��ֽ�����ʹ���ʣ����õ�����ֽ����
 * ����˵��һ����С�����
 * ����˵������ ���ӿɼ���Ĵ����
 * ����Ϊ �����ַ������ǲ��Եģ�һ�������ǣ� 10 3 1 1 1 �����Ӧ����ֻ��Ҫһ��ֽ�У����������ַ�������Ҫ����
 * �����Ŀ�У�ֵ�ý������ �ȶ������������������
 * �ҵĵ�һ��Ӧ���ñ�������ĵݹ鷽���������������ܻ����������δ���������Ч�ʡ�
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
	  //������¼һ�����ǲ������һ��������ǵĻ�countҲ��Ҫ��1��  
	  int flag = 0;   
 	  for(int i = 0; i < Num; i++){
		  bag[i] = fin.nextInt();
		  marked[i] = false;
	  }
 	  Arrays.sort(bag);//sort the array firstly
 	  
 	  /*����������ʼ���ҵ��ܸ���װ��һ���������������Ʒ��ֻҪ��δ����������ң���
 	   * ֱ��������Ʒ�������
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
	 			//������Ѿ����������Ʒ������
	 			 else
	 				 continue;	 			
	 		 }
 		 }
 		 //������Ѿ����������Ʒ������
 		 else{

 			continue;
 		 }
 			 
 	  }//end the biggest for
 	  
 	  if(count == 0)
 		  count = 1;
	  System.out.println(count);
	  
  }
}
