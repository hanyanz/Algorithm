package com.yanzi.swordOffer;
/*һ��������ֻ����������ֻ����һ�εģ��������������������Σ��ҵ���������
 * ˼·�����ֻ��һ����ֻ����һ�εĻ��������е���ȫ�����͵õ���
 *      ������������������ȫ�������Ϊ�϶���������A\B��ͬ�����Եõ��Ľ��������һ��λ��1
 *      ���������һ��λΪ1��λ�ã���1����0���԰�����ֳ����������飬A��B�϶��ڲ�ͬ�����������棬
 *      Ȼ���ٷֱ����������������ɵõ� ���
 * */
public class TheTwoNumAppearedOnce {
      public static void main(String[] args){
    	  TheTwoNumAppearedOnce test = new TheTwoNumAppearedOnce();
    	  int[] arr = {2,4};
    	  test.FindAppearOnce(arr);
    	  
      }
      public void FindAppearOnce(int[] arr){
    	  if(arr.length == 0 || arr == null)
    		  return;
    	  int result = 0;
    	  for(int i = 0; i < arr.length; i++){
    		  result ^= arr[i];
    	  }
    	  //���û��ֻ����һ�ε���
    	  if(result == 0)
    		  return;
    	  int index = FindFirstBitIs1(result);
    	  
    	  int num1 = 0;
    	  int num2 = 0;
    	  for(int i = 0; i < arr.length; i++){
    		  if(isBit1(arr[i],index))
    			  num1 ^= arr[i];
    		  else
    			  num2 ^= arr[i];
    	  }
    	  System.out.println(num1 + " "+ num2);
    	  
      }
      //���ش��ұ������1λΪ1��λ��
      public int FindFirstBitIs1(int num){
    	  int index = 0;
    	  while(((num&1) == 0)&&(index < 32)){
    		  index++;
    		  num = num>>1;
    	  }
    	  return index;
      }
      public boolean isBit1(int num, int index){
    	  num = num>>index;
    	  return( !((num&1) == 0));
      }
}
