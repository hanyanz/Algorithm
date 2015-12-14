package com.yanzi.huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Chopsticks {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		Set<Integer> result = new HashSet<Integer>();
		int num = fin.nextInt();
		boolean excp = false;
		try{
			for(int i = 0; i < num; i++){
				int temp = fin.nextInt();
				if(!result.contains(temp)){
					result.add(temp);
				}
				else{
					result.remove(temp);
				}
			}
		}catch (Exception e){
			excp = true;
			}
		finally{
			if((excp == true) || (result.isEmpty()) )
				System.out.println(-1);
			else 
				for(int s :result){
				  System.out.println(s);
				  break;
				}
		 }
		}

}
