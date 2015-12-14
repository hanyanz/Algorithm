package com.yanzi.qunar;
/*��һ��ʮ���Ƶ��ַ���ת��Ϊ16������,
 * �����Ȱ��ַ���ת�� Ϊʮ����������������������ʾ��Χʱ������Ϊ������С����
 *  Ȼ�������ת��Ϊ16���ƣ����ó���16�ķ�ʽ
 *  ����Ҫע�⣬��С�����ľ���ֵ��-2147483648���������������2147483647
 * */
import java.util.Stack;
public class Qunar_StringToHexString {
	public static void main(String[] args){
		Qunar_StringToHexString test = new Qunar_StringToHexString();
		String str = "8855344444";
		System.out.println(test.stringToHexString(str));
	}
	
	//��һ��ʮ�����ַ���ת��Ϊʮ����������
	public String stringToHexString(String str){
		if(str == null || str.length() == 0)
			return null;
		int strValue = stringToInt(str);
		System.out.println(strValue);
		return toHexString(strValue);
		
	}
	
	//��һ��ʮ�����ַ���ת��Ϊ����������������Χ�ĵ��������������Сֵ����
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
	
   //��һ��10��������ת��Ϊ16������
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
	
	//������ת��Ϊʮ����������ʾ
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
