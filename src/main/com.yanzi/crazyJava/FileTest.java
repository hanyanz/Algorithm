package com.yanzi.crazyJava;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args)throws IOException{

		File file = new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
		
		File tempFile = File.createTempFile("aaa", ".txt", file);
		tempFile.deleteOnExit();
		
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("newFile 对象是否存在："+ newFile.exists());
		System.out.println();
		newFile.createNewFile();
		newFile.mkdir();
		String[] fileList = file.list();
		for(String fileName: fileList){
			System.out.println(fileName);
		}
		System.out.println();
		File[] roots = File.listRoots();
		for(File root: roots){
			System.out.println(root);
		}
		
		
	}

}
