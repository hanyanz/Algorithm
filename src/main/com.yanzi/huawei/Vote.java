package com.yanzi.huawei;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Vote {
	public static void main(String[] args){
	   List<Candidate> candidate = new ArrayList<Candidate>();
	   Scanner fin = new Scanner(System.in);
	   int illegal = 0;
	   while (fin.hasNextLine()){
		   String[] temp = fin.nextLine().split(" ");
		   if(temp[0].equals("addCandidate")){
			   Candidate conn = new Candidate(temp[1],0);
			   candidate.add(conn);			   
		   }
		   else break;
		   }
	   while (fin.hasNextLine()){
		   String[] temp = fin.nextLine().split(" ");
		    if(temp[0].equals("vote")){
			   int i = 1;
			   for(Candidate ss:candidate){
				     if(ss.name.equals(temp[1])){
				    	 ss.voteNum++;
				    	 break;
				     }
				     else
				    	 i++;
			   }
			  if(i > candidate.size())
                       illegal++;				   
		   }
		   else
			   break;
	   }
	  for(Candidate ss: candidate){
		  if(ss.voteNum != 0)
		    System.out.println(ss.name +" "+ss.voteNum);
	  }
	  if(illegal != 0)
	      System.out.println(illegal);
	}
	
	static class Candidate{
		String name;
		int voteNum;
		public Candidate(String name,int num){
			this.name = name;
			this.voteNum = num;
		}
	}
}
