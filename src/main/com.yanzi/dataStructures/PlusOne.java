package com.yanzi.dataStructures;

public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 for(int i = digits.length-1; i >= 0 ; i--){
			 if(digits[i] == 9){
				 digits[i]= 0;
				 continue;
			 }else {
				 digits[i] += 1;
				 return digits;
			 }
		 }
		 //以下是处理能走完循环的情况，说明原数组全部数字都为9，加1后数组要扩张一位
		 int[] newDigits = new int[digits.length+1];
	        
	        newDigits[0] = 1;
	 //实际上这一步可以不要，因为能确定后面一定都是0 ,
	        //以下表示digits从0到 digits.length-1
	     System.arraycopy(digits, 0, newDigits, 1, digits.length-1);
	        
	        return newDigits;
	        
	    }
     public static void main (String[] args){
    	 PlusOne test = new PlusOne();
    	 int[] test2 = new int[]{9,9,9,9,9};
    	 int[] test1 = new int[]{9,9,7,9,9};
    	 int[] result1 = test.plusOne(test1);
    	 int[] result2 = test.plusOne(test2);
    	 for (int i : result1) {
 			System.out.print(i);
 		}
    	 System.out.println();
    	 for (int i : result2) {
  			System.out.print(i);
  		}
    	 
     }
}
