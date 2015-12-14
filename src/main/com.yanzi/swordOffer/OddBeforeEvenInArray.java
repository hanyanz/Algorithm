package com.yanzi.swordOffer;
/*输入一个数组，实现一个函数来调整该数组的顺序，使所有奇数在数组的前面部分，所有偶数在数组的后面部分
 * 如果能考虑代码的扩展性是一个很大的加分项，如这里把排序标准（是否为奇数）再松耦。
 * 如可实现 按奇偶和按是否是3的倍数分组
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
	//这里如果有的是JDK1.7的话是可以直接switch String 的
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
