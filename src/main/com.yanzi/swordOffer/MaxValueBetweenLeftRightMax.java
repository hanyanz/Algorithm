package com.yanzi.swordOffer;
/*����һ������ΪN����������arr�����Ի��ֳ������������֣� �󲿷�arr[0..K]���Ҳ���arr[K+1..arr.length-1]��
 * K����ȡֵ�ķ�Χ��[0,arr.length-2] ����ô�໮�ַ����У��󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵ������Ƕ��٣� 
 * ���磺 [2,7,3,1,1] ���󲿷�Ϊ[2,7]���Ҳ���Ϊ[3,1,1]ʱ���󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵΪ4; 
 * ���󲿷�Ϊ[2,7,3]���Ҳ���Ϊ[1,1]ʱ���󲿷��е����ֵ��ȥ�Ҳ������ֵ�ľ���ֵΪ6; 
 * ��󷵻صĽ��Ϊ6�� ע�⣺�������ĳ���ΪN���뾡������ʱ�临�Ӷ�O(N)������ռ临�Ӷ�O(1) 
 * */
public class MaxValueBetweenLeftRightMax {
	public static void main(String[] args){
		MaxValueBetweenLeftRightMax test = new MaxValueBetweenLeftRightMax();
		int[] arr = {6,1,2,3};
		System.out.println(test.getMaxABSLeftAndRight(arr));
	}
	public int getMaxABSLeftAndRight(int[] arr) {
        int max = Integer.MIN_VALUE;
          for(int k = 0; k < arr.length-1; k++) {
              int leftMax = Integer.MIN_VALUE;
              for(int i = 0; i <= k; i++ ){
                  leftMax = Math.max(arr[i],leftMax);
              }
              int rightMax = Integer.MIN_VALUE;
              for(int i = k+1; i < arr.length; i++ ){
                  rightMax = Math.max(arr[i],rightMax);
              }
              max = Math.max(Math.abs(leftMax-rightMax), max);
          }
        return max;
    }
}