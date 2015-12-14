package com.yanzi.qunar;

/*implement a function of String randomAlphabetic(int count)
Creats a random string whose length is the number of characters specified;
Characters will be chosen from the set of alpabetic characters*/
public class Qunar_randString {
	public static void  main(String[] args){
		Qunar_randString test = new Qunar_randString();
		System.out.println(test.randomAlphabetic(5));
		
	}
	private String randomAlphabetic(int count){
		StringBuffer str = new StringBuffer();
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z",  "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
		for(int i = 0; i < count; i++){
			int num = (int)((Math.random())*51);
			str.append(chars[num]);
		}
		return str.toString();
		
	}
	

}
