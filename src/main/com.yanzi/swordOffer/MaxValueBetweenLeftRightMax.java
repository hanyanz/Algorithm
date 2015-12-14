package com.yanzi.swordOffer;
/*给定一个长度为N的整型数组arr，可以划分成左右两个部分： 左部分arr[0..K]，右部分arr[K+1..arr.length-1]，
 * K可以取值的范围是[0,arr.length-2] 求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？ 
 * 例如： [2,7,3,1,1] 当左部分为[2,7]，右部分为[3,1,1]时，左部分中的最大值减去右部分最大值的绝对值为4; 
 * 当左部分为[2,7,3]，右部分为[1,1]时，左部分中的最大值减去右部分最大值的绝对值为6; 
 * 最后返回的结果为6。 注意：如果数组的长度为N，请尽量做到时间复杂度O(N)，额外空间复杂度O(1) 
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