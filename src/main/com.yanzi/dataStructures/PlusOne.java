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
		 //�����Ǵ���������ѭ���������˵��ԭ����ȫ�����ֶ�Ϊ9����1������Ҫ����һλ
		 int[] newDigits = new int[digits.length+1];
	        
	        newDigits[0] = 1;
	 //ʵ������һ�����Բ�Ҫ����Ϊ��ȷ������һ������0 ,
	        //���±�ʾdigits��0�� digits.length-1
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
