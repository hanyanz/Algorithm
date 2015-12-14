package com.yanzi.crazyJava;

public class EqualsMethod2 {
	static class Value{
		int i ;
	}
	public static void main(String[] args){
		Value v1 = new Value();
		Value v2 = new Value();
		v1.i = v2.i = 100;
		
		/**输出false，因为在Object类中equals默认行为是比较引用 ，而class Value中没有重写equals()*/
		System.out.println(v1.equals(v2));
	}

}
