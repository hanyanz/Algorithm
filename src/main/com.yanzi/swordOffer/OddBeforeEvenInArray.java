package com.yanzi.swordOffer;
/*����һ�����飬ʵ��һ�������������������˳��ʹ���������������ǰ�沿�֣�����ż��������ĺ��沿��
 * ����ܿ��Ǵ������չ����һ���ܴ�ļӷ��������������׼���Ƿ�Ϊ�����������
 * ���ʵ�� ����ż�Ͱ��Ƿ���3�ı�������
 * */
public class OddBeforeEvenInArray {

	public static void main(String[] args){
		int[] arr1 = {1,2,3,4,5,6,7,9};
		int[] arr2 = {1,2,3,4,5,6,7,9};
		OddBeforeEvenInArray test = new OddBeforeEvenInArray();
		test.moveArray(arr1,"isOdd");
		test.moveArray(arr2,"isMultipleOf3");
		for(int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i]+" ");
		System.out.println("");
		for(int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i]+" ");
	}
	public void moveArray(int[] arr,String str){
		int left = 0;
		int right = arr.length-1;
		while(right > left){
			if(fun(str,arr[left])){
				left++;
				continue;
			}
			if(!fun(str,arr[right])){
				right--;
				continue;
			}
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	public boolean fun(String str,int num){
	//��������е���JDK1.7�Ļ��ǿ���ֱ��switch String ��
		if(str.equals("isOdd"))
			return isOdd(num);
		else 
			return isMultipleOf3(num);
	}
	public  boolean isOdd(int num){
		return(num%2 == 1);
	}
	public boolean isMultipleOf3(int num){
		return (num%3 == 0);
	}
}
