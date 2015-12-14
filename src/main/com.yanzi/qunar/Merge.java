package com.yanzi.qunar;

/*
题目描述：实现以下函数int[][] merge(int[][] dateRangePrice)，
输入是某个酒店多个日期段的价格，每个日期段（终止日期大于起始日期，且终止日期
不会大于1001）和对应的价格使用长度为3的数组表示，例如[0, 100, 300]表示从第一天开始，
到第101天的价格为300，这些日期可能重复，重复的日期以后面的为准，
按要求合并并输出结果：
(1). 相邻两天的价格如果相同，那么这两个日期段合并并输出
(2). 合并的结果应该以起始日期从小到大排序
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge{
	public static int[] rangePrices = new int[1001];//统计各个日期的价格
	public static List<Integer[]> merge(int[][] dateRangePrice){
		if (dateRangePrice == null || dateRangePrice.length <= 0) {
			return null;
		}
		
		Arrays.fill(rangePrices, -1);
		int N = dateRangePrice.length;

		//预处理：统计每天的价格
		for (int i = 0; i < N; i++) {
			for (int j = dateRangePrice[i][0]; j <= dateRangePrice[i][1]; j++) {
				rangePrices[j] = dateRangePrice[i][2];
			}
		}
		
		List<Integer[]> result = new ArrayList<Integer[]>();
		int p1 = 0, p2 = 0, p3 = 0;
		int j = 0;
		//根据统计，合并结果
		while (j < 1001) {
			while (rangePrices[j] == -1) {
				j++;
				if (j == 1001) {
					break;
				}
			}
			if (j == 1001) {
				break;
			}
			p1 = j;
			p3 = rangePrices[j];
			while (rangePrices[j] == p3) {
				j++;
			}
			p2 = j - 1;
			Integer[] tmp = {p1, p2, p3};
			result.add(tmp);
			j = p2 + 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] arrays = { {10, 40 ,250},{1, 20, 300}, {41, 60, 250}};
		List<Integer[]> p = merge(arrays);
		for (Integer[] t : p) {
			for (int i = 0; i < t.length; i++) {
				System.out.print(t[i] + " ");
			}
			System.out.println();
		}
	}
}