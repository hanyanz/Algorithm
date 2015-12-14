package com.yanzi.leetCode;
//String to Integer
/*������Ŀ����ص㲢���������Ȿ������Ҫע��corner case�Ĵ���
 * ����һ�������㣬һ���������������⣬��һ��������Խ�����⡣
 * ˼·�Ƚϼ򵥣�������ȥ������Ŀո��ַ���Ȼ������ţ�ע�������Ŷ��п��ܣ�Ҳ�п���û�з��ţ���
 * ��������˳������֣��������������������
 * ��1���쳣�ַ����֣�����C���Եı�׼�ǰ��쳣�ַ���ĺ���ȫ����ȥ������ǰ��Ĳ�����Ϊ�������
 * ��2������Խ�磨������ӽ�������������3���ַ���������
 *   2��31�η�Ϊ 2147483648���������ͷ�ΧΪ  -2147483647  ~ 2147483648
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
