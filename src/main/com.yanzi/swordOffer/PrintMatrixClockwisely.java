package com.yanzi.swordOffer;
/*输入一个矩阵，从外向里顺时针依次打印出每一个数字
 * 每一圈的起点分别是(0，0)，(1，1)....(start,start)
 * 这里要注意，里面可能不是圈，所以要判断start与endX、endY的大小关系（需不需要向再向下，向左或向上打印）
 * */
public class PrintMatrixClockwisely {

	public static void main(String[] args){
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}} ;
		PrintMatrixClockwisely test = new PrintMatrixClockwisely();
		test.printClockwisely(arr);
	}
	public  void printClockwisely(int[][] arr){
		if(arr == null)
			return;
		int rows = arr.length;
		int columns = arr[0].length;
		int start = 0;
		//圈数不会超过长宽之中较小的那个的一半
		while(columns > 2*start  && rows > 2*start){
			printCircle(arr,rows,columns,start);
			++start;
		}	
	}
	//顺时针打印时，打印每个方向的数之前，要先判断是否需要再打印，或者说能不能打印
	public void printCircle(int[][] arr, int rows, int columns, int start){
		int endX = columns-1-start;
		int endY = rows-1-start;
		for(int i = start;  i <= endX; i++){
			System.out.print(arr[start][i]+" ");
		}
		for(int i = start+1; i <= endY; i++){
			System.out.print(arr[i][endX]+" ");
		}
		if( start < endY){
			for(int i = endX-1; i >= start; i--){
				System.out.print(arr[endY][i]+" ");
			}
		}
		if(start < endX ){
			for(int i = endY-1; i > start; i--){
				System.out.print(arr[i][start]+" ");
			}
		}
	}//end of printCircle
}
