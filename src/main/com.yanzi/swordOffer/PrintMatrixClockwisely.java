package com.yanzi.swordOffer;
/*����һ�����󣬴�������˳ʱ�����δ�ӡ��ÿһ������
 * ÿһȦ�����ֱ���(0��0)��(1��1)....(start,start)
 * ����Ҫע�⣬������ܲ���Ȧ������Ҫ�ж�start��endX��endY�Ĵ�С��ϵ���費��Ҫ�������£���������ϴ�ӡ��
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
		//Ȧ�����ᳬ������֮�н�С���Ǹ���һ��
		while(columns > 2*start  && rows > 2*start){
			printCircle(arr,rows,columns,start);
			++start;
		}	
	}
	//˳ʱ���ӡʱ����ӡÿ���������֮ǰ��Ҫ���ж��Ƿ���Ҫ�ٴ�ӡ������˵�ܲ��ܴ�ӡ
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
