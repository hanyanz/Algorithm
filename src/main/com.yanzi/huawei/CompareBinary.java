package com.yanzi.huawei;
/*�Ƚ��������Ķ�������1�ĸ����������ȣ����0���������ȣ�������ֵ���Ƿ����룬���-1
 * ��������λ����ķ�������⣬
 * ����һ������1��n��λ���㣬�ж�n��ĩλ�ǲ���1��Ȼ��1����1λ����n�����㣬ֱ���ж���n������λ�ϵ����ǲ���1
 * ������ѡ������-1����������������İ취����Ϊÿ��������ʹn���ұߵ�λ��Ϊ0�����Ե�������Ϊ0��ǰ�ظ��������裬�ɵõ�1��λ��*/
import java.util.Scanner;
public class CompareBinary {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		try{
			int first = fin.nextInt();
			int second = fin.nextInt();
			if(NumOf1(first) == NumOf1(second))
				System.out.println(0);
			else if(NumOf1(first) > NumOf1(second))
				System.out.println(first);
			else
				System.out.println(second);
		}catch (Exception e){
			System.out.println(-1);
		}
	}
	public static int NumOf1(int n){
		int count = 0;
		while(n != 0){
			n = n&(n-1);
			count++;
		}
		return count;
	}
}
