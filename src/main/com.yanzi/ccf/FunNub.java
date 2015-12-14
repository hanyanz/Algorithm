package com.yanzi.ccf;

import java.util.Scanner;

public class FunNub {
	public static void main(String[] args) {
		new FunNub().run();
	}
		public void run() {
		Scanner fin = new Scanner(System.in);
		
		int N = fin.nextInt();
		long[] count = new long[8];
		count[6] = 0;
		count[7] = 1;
		long mod = 1000000007;
		
		for(int i = 2; i <= N; ++i){
			long[] newCount = new long[8];
			newCount[0] = (count[0]*2+count[1]+count[3])%mod;
			newCount[1] = (count[1]*2+count[2]+count[5])%mod;
			newCount[2] = (count[2]+count[6])%mod;
			newCount[3] = (count[3]*2+count[4]+count[5])%mod;
			newCount[4] = (count[4]+count[7])%mod;
			newCount[5] = (count[5]*2+count[6]+count[7])%mod;
			newCount[6] = 0;
			newCount[7] = 1;
			
			count = newCount;
		}
		System.out.print(count[0]);
		}

}
