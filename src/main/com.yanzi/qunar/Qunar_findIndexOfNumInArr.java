package com.yanzi.qunar;
/*ȥ�Ķ�ʵϰ���Ե�һ�⣺��һ����������ת�ĵ��������в���һ��ָ������
 * Ҫ������ת���ǲ��ǻ��ǵ����ģ�
 * ��������û���ظ�����ֵ��
 * */
public class Qunar_findIndexOfNumInArr {
	public static void main(String[] args){
		Qunar_findIndexOfNumInArr test = new Qunar_findIndexOfNumInArr();
		int[] arr1 = {2,2,2,3,4,5,2,2,2,2,2,2};
		int[] arr2 = null;
		int target = 1;
		System.out.println(test.indexOf(arr2, target));
	}
	public int indexOf(int[] array, int target){
		if(array == null || array.length == 0 ){
			return -1;
		}
		
		int left = 0;
		int right = array.length-1;
		int mid = (left+right)/2;
		while(array[left] == array[right] && array[left] == array[mid]){
			left ++;
			right --;
			mid = (left+right)/2;
			continue;
		}
		//��ȫ���任��һ����������
		while(array[left] > array[right]){
			if(array[mid] == target)
				return mid;
		    if(array[mid] < target && array[mid] > array[left]){
				left = mid;
				mid = (left+right)/2;
				continue;
			}
		    if(array[mid] > target && array[mid] < array[right]){
		    	right = mid;
		    	mid = (left+right)/2;
		    	continue;
		    }
		    left++;
		    right--;
		    mid = (left+right)/2;
		    continue;
		}
		//�����������µĲ���
		while(right > left){
			
			if(array[mid] == target){
				return mid;
			}
			else if(array[mid]>target){
				right = mid-1;
				mid = (left+right)/2;
				continue;
			}
			else{
				left = mid+1;
				mid = (left+right)/2;
				continue;
			}			
		}
		return -1;
	}//end of indexOf()

}
