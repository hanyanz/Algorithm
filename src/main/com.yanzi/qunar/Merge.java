package com.yanzi.qunar;

/*
��Ŀ������ʵ�����º���int[][] merge(int[][] dateRangePrice)��
������ĳ���Ƶ������ڶεļ۸�ÿ�����ڶΣ���ֹ���ڴ�����ʼ���ڣ�����ֹ����
�������1001���Ͷ�Ӧ�ļ۸�ʹ�ó���Ϊ3�������ʾ������[0, 100, 300]��ʾ�ӵ�һ�쿪ʼ��
����101��ļ۸�Ϊ300����Щ���ڿ����ظ����ظ��������Ժ����Ϊ׼��
��Ҫ��ϲ�����������
(1). ��������ļ۸������ͬ����ô���������ڶκϲ������
(2). �ϲ��Ľ��Ӧ������ʼ���ڴ�С��������
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge{
	public static int[] rangePrices = new int[1001];//ͳ�Ƹ������ڵļ۸�
	public static List<Integer[]> merge(int[][] dateRangePrice){
		if (dateRangePrice == null || dateRangePrice.length <= 0) {
			return null;
		}
		
		Arrays.fill(rangePrices, -1);
		int N = dateRangePrice.length;

		//Ԥ����ͳ��ÿ��ļ۸�
		for (int i = 0; i < N; i++) {
			for (int j = dateRangePrice[i][0]; j <= dateRangePrice[i][1]; j++) {
				rangePrices[j] = dateRangePrice[i][2];
			}
		}
		
		List<Integer[]> result = new ArrayList<Integer[]>();
		int p1 = 0, p2 = 0, p3 = 0;
		int j = 0;
		//����ͳ�ƣ��ϲ����
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