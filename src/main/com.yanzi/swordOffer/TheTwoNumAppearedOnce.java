package com.yanzi.swordOffer;
/*一个数组中只有两个数是只出现一次的，其它的数都出现了两次，找到这两个数
 * 思路：如果只有一个数只出现一次的话，数组中的数全部异或就得到了
 *      基于上述，数组中数全部异或，因为肯定有两个数A\B不同，所以得到的结果至少有一个位是1
 *      用异或结果第一个位为1的位置，是1还是0可以把数组分成两个子数组，A和B肯定在不同的子数组里面，
 *      然后再分别对两个子数组异或便可得到 结果
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
    	  //如果没有只出现一次的数
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
      //返回从右边数起第1位为1的位置
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
