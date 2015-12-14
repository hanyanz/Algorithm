package com.yanzi.leetCode;
//String to Integer
/*这种题的考察重点并不在于问题本身，而是要注意corner case的处理，
 * 整数一般有两点，一个是正负符号问题，另一个是整数越界问题。
 * 思路比较简单，就是先去掉多余的空格字符，然后读符号（注意正负号都有可能，也有可能没有符号），
 * 接下来按顺序读数字，结束条件有三种情况：
 * （1）异常字符出现（按照C语言的标准是把异常字符起的后面全部截去，保留前面的部分作为结果）；
 * （2）数字越界（返回最接近的整数）；（3）字符串结束。
 *   2的31次方为 2147483648，所以整型范围为  -2147483647  ~ 2147483648
 */
public class Atoi {
	public static void main(String[] args){
		Atoi test = new Atoi();
		System.out.print(test.solution(" -2147483688"));
	}
 
    public int solution (String str) {
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
}
