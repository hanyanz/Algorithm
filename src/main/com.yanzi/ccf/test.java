package com.yanzi.ccf;


import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner fin = new Scanner(System.in);
		String[] str = fin.nextLine().split(" ");
		int[] conn = new int[str.length];
		for(int i = 0; i < str.length; i++){
			conn[i] = Integer.parseInt(str[i]);
		}
		for(int s:conn){
			System.out.println(s);
		}
	}

}
