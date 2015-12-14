package com.yanzi.huawei;
/*比较两个数的二进制中1的个数，如果相等，输出0，如果不相等，输出大的值。非法输入，输出-1
 * 这里运用位运算的方法来求解，
 * 其中一种是用1与n做位运算，判断n最末位是不是1，然后1左移1位再与n做运算，直到判断了n的所有位上的数是不是1
 * 本例中选用整数-1与整数本身与运算的办法，因为每次运算能使n最右边的位变为0，所以到整数变为0以前重复上述步骤，可得到1的位数*/
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
