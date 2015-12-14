package com.yanzi.leetCode;
//先转化为正数好统一处理
//这里判断数字是否越界是有技巧的 if(res > (Integer.MAX_VALUE- num%10)/10)
//怎么样得到一个数的个、十、百...位上的数
//一个整数对10求余和除10的区别：一个是在求未位数字，一个是截除未位数字
public class ReverseInteger {
	public static void main(String[] args){
		ReverseInteger test = new ReverseInteger();
		System.out.print(test.reverse(-1245));
	}
	public int reverse(int x){
		if(x == Integer.MIN_VALUE)
			return 0;
		int num = Math.abs(x);
		int res = 0;
		while(num != 0){
			if(res > (Integer.MAX_VALUE- num%10)/10)
				return 0;
			res = res*10 + num%10;
			num /= 10;
		}
		return x>0?res:-res;
	}
}
