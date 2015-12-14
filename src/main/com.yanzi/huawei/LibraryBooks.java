package com.yanzi.huawei;

// TODO
//not completed yet
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryBooks {
	public static void main(String[] args){
		Scanner fin = new Scanner(System.in);
		List<String[]> booklist = new ArrayList<String[]>();
		String[] book = new String[5];
		List<String> result = new ArrayList<String>();
		
		while(fin.hasNextLine()){
			boolean begin = false;
			if(fin.nextLine().equals("End")){
				break;
			}
			else if(fin.nextLine().equals("SearchBooks")){
				book = fin.nextLine().split(" ");
			}
			else if(fin.nextLine().equals("AddBooks")){
				begin = true;	
			}
			else{
				if(begin == true){
					booklist.add(fin.nextLine().split(" "));
				}
				else 
					continue;
			}
		}
		fin.close();
		if(!book.equals("")){
			for(String[] ss: booklist){
				for(int i = 0; i < ss.length; i++ ){
					for(int j = 0; j < book.length;j++)
					if(ss[i].equals(book[j])){
					    result.add(ss.toString()); 
					}
				}
			}	
		}
		if(result.size() == 0){
			System.out.println("\"\"");
		}
		else{
			//°´×ÖµäÅÅÐòËÑË÷½á¹û
			for(String ss: result){
				System.out.println(ss);
			}
		}
		
	}

}
