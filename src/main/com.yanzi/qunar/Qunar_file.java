package com.yanzi.qunar;

/*一个文件中找到包含your的语句，并按顺序排列打印出来*/

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.util.Queue;

public class Qunar_file {
	public static void main(String[] args) throws IOException{
		try{
		File file = new File("E:\\test\\qunartest.txt");
		if(file.isFile() && file.exists()){
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			
			int count = 0;
			while((lineTxt = bufferedReader.readLine()) != null ){
				while(lineTxt.indexOf("your") != -1){
					count++;
					lineTxt = lineTxt.substring(lineTxt.indexOf("your")+1);
				}
				System.out.println(count);
			}
			
	    }
	
	    }catch(Exception e){
		  System.out.println("error");
	    }
    }
}
