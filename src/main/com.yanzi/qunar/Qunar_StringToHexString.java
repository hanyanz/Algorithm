package com.yanzi.qunar;
/*把一个十进制的字符串转化为16进制数,
 * 考虑先把字符串转化 为十进制整数，当超过整数表示范围时，处理为最大或最小整数
 *  然后把整数转化为16进制，采用除以16的方式
 *  这里要注意，最小整数的绝对值是-2147483648，超过了最大整数2147483647
 * */
import java.util.Stack;
public class Qunar_StringToHexString {
	public static void main(String[] args){
		Qunar_StringToHexString test = new Qunar_StringToHexString();
		String str = "8855344444";
		System.out.println(test.stringToHexString(str));
	}
	
	//把一个十进制字符串转化为十六进制整数
	public String stringToHexString(String str){
		if(str == null || str.length() == 0)
			return null;
		int strValue = stringToInt(str);
		System.out.println(strValue);
		return toHexString(strValue);
		
	}
	
	//把一个十进制字符串转化为整数，超过整数范围的当作整数的最大最小值看待
	 public int stringToInt (String str) {
	        if(str==null)
	        {
	            return 0;
	        }
	        str = str.trim();
	        if(str.length()==0)
	            return 0;
	        boolean isNeg = false;
	        int i = 0;
	        if(str.charAt(0)=='-' || str.charAt(0)=='+')
	        {
	            i++;
	            if(str.charAt(0)=='-')
	                isNeg = true;
	        }
	        int res = 0;
	        while(i < str.length()) {	
	            int digit = (int)(str.charAt(i)-'0');
	    //       System.out.print(digit+" ");
	           if(digit >= 0 && digit <= 9){
		            if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
		                return Integer.MIN_VALUE;
		            else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
		                return Integer.MAX_VALUE;
		            res = res*10+digit;
		            i++;
	          }
	           else break;
	        }
	        return isNeg?-res:res;
	   }
	
   //把一个10进制整数转化为16进制数
	public String toHexString(int num){
		boolean isNegative = false;
		Stack<String> hexValue = new Stack<String>();
		hexValue.ensureCapacity(16);
		if(num < 0){
			isNegative = true;
			if (num == Integer.MIN_VALUE){
				return "-80000000";
			}
			else
				num = Math.abs(num);
		}
		int quotient = num>>4;
		int remainder = num%16;
		hexValue.push(intToString(remainder));
		while(quotient > 0){
			remainder = quotient%16;
			quotient = quotient >> 4;			
			hexValue.push(intToString(remainder));
		}
		StringBuffer result = new StringBuffer();
		while( hexValue.size() != 0){
			result.append(hexValue.pop());
		}	
		return isNegative?("-"+result):result.toString();
	}
	
	//把数字转化为十六进制数表示
	public String intToString(int i){
		switch (i){
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "A";
		case 11:
			return "B";
		case 12:
			return "C";
		case 13:
			return "D";
		case 14:
			return "E";
		case 15:
			return "F";
		}
		return "error";
	}

}
