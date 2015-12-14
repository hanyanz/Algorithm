package com.yanzi.qunar;
/*输入一个有序数组和一个数，
 * 若在数组中返回索引，若不在返回应该插入的索引
 * 这里假设有序数组为递增的
 * 以下算法对于数组中存在重复值的情况下也是适用的
 * */
public class Qunar_findInSortArr {
	public static void main(String[] args){
		Qunar_findInSortArr test = new Qunar_findInSortArr();
		int[] arr = {};
		System.out.println(test.findInSortArr(arr,3));
		
	}
    public int findInSortArr(int[] arr, int num){
    	if(arr == null || arr.length == 0){
    		return -1;
    	}
    	int left = 0;
    	int right = arr.length;
    	int mid = (left+right)/2;
    	//先判断num不在arr数据最大最小值范围内
    	if(num <= arr[left]){
    		return 0;
    	}
    	if(num >= arr[right-1]){
    		return right;
    	}
    	//num在arr数据最大最小值范围内，要么找到，要么返回搜索后的right值
    	while(mid > left){
    		if(arr[mid] == num){
    			return mid;
    		}
    		else if(arr[mid] > num){
    			right = mid;
    			mid = (left+right)/2;
    		}
    		else{
    			left = mid;
    			mid = (left+right)/2;
    		}
    	}	
    		return right;   	
    }//end of findInSortArr();
    
  
}
