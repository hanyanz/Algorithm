package com.yanzi.newCoder;

import java.util.Scanner;

public class BaiDuShiTang {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		
		//������������
		int testCount = fin.nextInt();
		int[] consumerInfo = new int[3];
		String[] consumerStr = new String[3];
		String[][] shiTangStr = new String[consumerInfo[0]][];
		int[][] shiTangInfo = new int[consumerInfo[0]][];
		
		for(int i = 0; i < testCount; i++){
			//�����ѵ�ʳ����Ŀ�����������
			consumerStr = fin.nextLine().split(" ");
			for(int j = 0; j < 3; j++){
				consumerInfo[j] = Integer.valueOf(consumerStr[j]);
			}
			
			//consumerInfo[0]Ϊʳ����Ŀ
			for(int k = 0; k < consumerInfo[0]; i++){
				//�õ�ÿ��ʳ�õ�ʳ����Ŀ����Ӧ�ļ۸����ܶ�
				shiTangStr[k] = fin.nextLine().split(" ");
				for(int m = 0; m < shiTangStr[k].length; m++){
					shiTangInfo[k][m] = Integer.valueOf(shiTangStr[k][m]);
				}
			}
			System.out.println(getMaxValue(consumerInfo, shiTangInfo));
		}		
	}
	
	//�õ�ÿ��������ݵ�������ܶ�
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
	
	//�õ�ÿ��ʳ�õ�������ܶ�
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
			//����Ǯ����������ʳ���ʱ����ôѡ��ʳ��ñ���˼������⣬�ο�bagPromble
			
		}
		return 0;
	}

}
/*�Ӱ���һ��ͨ���Ķȶ��ܣ����е��㱣��뵽��Ȼδ�ܽ����Bug���������ס�����������µ�������̧ͷ���˿��۶������ɵ���գ�һҧ����һ��ţ�
 * ���һ���������ʽ���Ҫ�Ե�õģ� ��֪������n��ʳ�ã���i��i����[1,n])��ʳ����m[i]��ʳ�ÿ��ʳ����һ����Ǯc�����ܶ�v��
 * �ȶ���ϣ��ȥһ��ʳ�þͲͣ�����[bot,top]��Χ�ڵ�Ǯ����Ҳ�������������ˣ����ﶼ�����ˣ���ѡ��������ʳ�ʹ���Լ����ܻ�õ����ܶ����
 * ��ע�⣬�ȶ��ܻ���һ����ʳ���ص㣬ͬһ��ʳ�������ֻ���һ�ݡ��� 
 * ���ڸ���������ʳ��ʳ�����Ϣ��ϣ�������ѡ����䣬ʹ�öȶ��ܿ��Եõ��������ܶȣ������������ܶȵ�ֵ��
 
��������:
��һ����һ��������T��1<=T<=20),��ʾ��T��������ݡ�
����ÿ�����ݡ���
��һ����������n��bot��top��n����ʳ����1<=n<=10����bot����γԷ���������ѣ�top����γԷ���������ѣ�0<=bot��top<=10000��
������������n��ʳ�õ���Ϣ�����ڵ�i��ʳ��
��һ����һ����m[i]��o<=m[i]<=100)�������i��ʳ�õ�ʳ����
�ڶ�����2*m[i]�������ֱ���c[i][1]��v[i][1]��c[i][2]��v[i][2]������c[i][m[i]]��v[i][m[i]]
c[i][j]��ʾ��i��������j��ʳ��ļ�Ǯ��v[i][j]�����i��������j��ʳ����ȶ��ܴ��������ܶȡ�


�������:
����ÿ�����ݣ������һ�У�ÿ��һ������������ʾ�ȶ������ܻ�õ�������ܶȡ�
���ݽ����֤���ᳬ��2^31-1.

��������:
2
2 10 20
5 1 1 2 1 5 1 10 1 20 1
5 1 2 2 2 5 2 10 2 20 2
2 10 10
1 5 1
1 5 1

�������:
8
0
*/