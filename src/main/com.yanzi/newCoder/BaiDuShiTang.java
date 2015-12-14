package com.yanzi.newCoder;

import java.util.Scanner;

public class BaiDuShiTang {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		
		//测试数据组数
		int testCount = fin.nextInt();
		int[] consumerInfo = new int[3];
		String[] consumerStr = new String[3];
		String[][] shiTangStr = new String[consumerInfo[0]][];
		int[][] shiTangInfo = new int[consumerInfo[0]][];
		
		for(int i = 0; i < testCount; i++){
			//可消费的食堂数目，金额上下限
			consumerStr = fin.nextLine().split(" ");
			for(int j = 0; j < 3; j++){
				consumerInfo[j] = Integer.valueOf(consumerStr[j]);
			}
			
			//consumerInfo[0]为食堂数目
			for(int k = 0; k < consumerInfo[0]; i++){
				//得到每个食堂的食物数目及对应的价格、享受度
				shiTangStr[k] = fin.nextLine().split(" ");
				for(int m = 0; m < shiTangStr[k].length; m++){
					shiTangInfo[k][m] = Integer.valueOf(shiTangStr[k][m]);
				}
			}
			System.out.println(getMaxValue(consumerInfo, shiTangInfo));
		}		
	}
	
	//得到每组测试数据的最大享受度
	public static int getMaxValue(int[] consumerInfo, int[][] shiTangInfo){
		if( consumerInfo == null || shiTangInfo == null ||consumerInfo.length != 3 || shiTangInfo.length != consumerInfo[0]){
			return 0;
		}
		int max = 0;
		int eachMax = 0;
		for(int i = 0; i < shiTangInfo.length; i++){
			if(shiTangInfo[i][0]*2 +1 == shiTangInfo.length){
				eachMax = getEachMax(consumerInfo, shiTangInfo[i]);
			}
			if(eachMax > max){
				max = eachMax;
			}
			
		}
		return max;
	}
	
	//得到每个食堂的最大享受度
	public static int getEachMax(int[] consumerInfo, int[] eachShiTangInfo){
		int allPrice = 0;
		int eachMax = 0;
		for(int i = 0; i < eachShiTangInfo.length/2;i++){
			allPrice += eachShiTangInfo[2*i+1];
		}
		if(allPrice < consumerInfo[1]){
			return 0;
		}
		else if(allPrice < consumerInfo[2]){
			for(int i = 1; i <= eachShiTangInfo.length/2;i++){
				eachMax += eachShiTangInfo[2*i];
			}
			return eachMax;
		}else{
			//计算钱不够买所有食物的时候怎么选择食物，用背包思想来求解，参考bagPromble
			
		}
		return 0;
	}

}
/*加班了一个通宵的度度熊，神经有点恍惚，想到依然未能解决的Bug，眼泪禁不住霹雳哗啦往下掉……他抬头看了看帝都灰蒙蒙的天空，一咬牙，一跺脚，
 * 大叫一声——劳资今天要吃点好的！ 已知本厂有n个食堂，第i（i属于[1,n])个食堂有m[i]种食物，每种食物有一个价钱c，享受度v，
 * 度度熊希望去一个食堂就餐，花费[bot,top]范围内的钱数（也可以拍桌子走人，哪里都不吃了），选择若干种食物，使得自己所能获得的享受度最大。
 * （注意，度度熊还有一个挑食的特点，同一种食物他最多只会点一份。） 
 * 现在告诉你所有食堂食物的信息，希望你进行选择搭配，使得度度熊可以得到最大的享受度，并输出这个享受度的值。
 
输入描述:
第一行是一个正整数T（1<=T<=20),表示有T组测试数据。
对于每组数据——
第一行是三个数n，bot，top，n代表食堂数1<=n<=10），bot是这次吃饭的最低消费，top是这次吃饭的最高消费（0<=bot，top<=10000）
接下来依次是n个食堂的信息，对于第i个食堂
第一行是一个数m[i]（o<=m[i]<=100)，代表第i个食堂的食物数
第二行有2*m[i]个数，分别是c[i][1]，v[i][1]，c[i][2]，v[i][2]，……c[i][m[i]]，v[i][m[i]]
c[i][j]表示第i个餐厅第j种食物的价钱，v[i][j]代表第i个餐厅第j种食物给度度熊带来的享受度。


输出描述:
对于每组数据，请输出一行，每行一个正整数。表示度度熊所能获得的最大享受度。
数据结果保证不会超过2^31-1.

输入例子:
2
2 10 20
5 1 1 2 1 5 1 10 1 20 1
5 1 2 2 2 5 2 10 2 20 2
2 10 10
1 5 1
1 5 1

输出例子:
8
0
*/