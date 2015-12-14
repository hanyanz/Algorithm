package com.yanzi.otherTests;

public class IntSLLNode {
	public int info;
	public IntSLLNode next;  //这是一个自引用对象
	public IntSLLNode (int i){
		this(i,null);
	}
	
	public IntSLLNode(int i ,IntSLLNode n){
		info = i;
		next = n;
	}
  
}
