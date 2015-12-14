package com.yanzi.swordOffer;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
	    int[][] stationPersons = new int[num][2];
	    for(int i = 0; i < num; i++){
	    	stationPersons[i][0] = sc.nextInt();
	    	stationPersons[i][1] = sc.nextInt();	    	
	    }
	    System.out.println(getMaxPersonNum(stationPersons));
	}
	 
	private static int getMaxPersonNum(int[][] stationPersons){
		int max = 0;
		int tempMax = 0;
		for(int i = 0; i < stationPersons.length;i++){
			tempMax += stationPersons[i][1];
			tempMax = tempMax - stationPersons[i][0];
			if(tempMax < 0){
				tempMax = 0;
			}
			if(tempMax > max){
				max = tempMax;
			}
		}
		return max;
	}
}
