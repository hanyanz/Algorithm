package com.yanzi.huawei;
/*�ߵ�����Nյ�ƣ���1��ʼ���α�ţ�ȫ���ǹص�
 * �Ȱ�1�ı�����һ�£��ٰ�2��λ����һ�¡�����������N��λ�����¿��أ���������ŵĵ���
 * ˼·�����Ϊn�ĵƣ������µ��ܴ���Ϊ�����������������ŵ�
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
