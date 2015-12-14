package com.yanzi.huawei;
/*走道里有N盏灯，从1开始依次编号，全部是关的
 * 先按1的倍数拉一下，再按2的位数拉一下。。。。。按N的位数拉下开关，求最后亮着的灯数
 * 思路：编号为n的灯，被拉下的总次数为奇数，则最后灯是亮着的
 * */

import java.util.Scanner;
public class LampNum {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		int N = fin.nextInt();
		int result = 0;
		for(int i = 1; i <= N; i++){
			if(countNum(i)%2 == 1){
				result++;
			}
		}
		System.out.println(result);
	}
    public static int countNum(int n){
    	int count = 0;
    	for(int i = 1; i <= n/2; i++){
    		if(n % i == 0)
    			count++;
    	}
    	return count+1;
    }
}
