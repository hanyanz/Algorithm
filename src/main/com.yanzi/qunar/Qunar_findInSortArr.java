package com.yanzi.qunar;
/*����һ�����������һ������
 * ���������з��������������ڷ���Ӧ�ò��������
 * ���������������Ϊ������
 * �����㷨���������д����ظ�ֵ�������Ҳ�����õ�
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
    	//���ж�num����arr���������Сֵ��Χ��
    	if(num <= arr[left]){
    		return 0;
    	}
    	if(num >= arr[right-1]){
    		return right;
    	}
    	//num��arr���������Сֵ��Χ�ڣ�Ҫô�ҵ���Ҫô�����������rightֵ
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
