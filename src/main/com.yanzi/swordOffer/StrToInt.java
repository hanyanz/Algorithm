package com.yanzi.swordOffer;


//考虑空值，NULL，正负，溢出，非法输入

public class StrToInt {
	public static void main(String[] args){
		String intStr = "-123333333333333333333";
		System.out.println(tranStrToInt(intStr));
	}
	
	public static int tranStrToInt(String intStr){
		if(intStr == null || intStr.equals("")){
			return 0;
		}
		boolean minus = false;
		int start = 0;
		if(intStr.startsWith("-")){
			minus = true;
			start++;
		}else if (intStr.startsWith("+")){
			start++;
		}
		
		return tranStrToIntCore(intStr,start,minus);
	}
	
	public static int tranStrToIntCore(String intStr, int start,boolean minus){
		long result = 0;
		for(int i = start; i < intStr.length(); i++){
			if(intStr.charAt(i) >= '0' && intStr.charAt(i) <= '9'){
				 result = result*10 + (intStr.charAt(i)-'0');
				 if(result >= Integer.MAX_VALUE && !minus){
					 result = Integer.MAX_VALUE;
					 break;
				 }
				 if(result > Integer.MAX_VALUE && minus){
					 result = Integer.MIN_VALUE;
					 break;
				 }
			}else{
				result = 0;
				break;
			}
		}
		if(result == Integer.MIN_VALUE){
			return (int)result;
		}
		if(minus == true && result != 0){
			result = -result;
		}
		return (int)result;
	}

}
