package com.yanzi.otherTests;

public class IntSLLNode {
	public int info;
	public IntSLLNode next;  //����һ�������ö���
	public IntSLLNode (int i){
		this(i,null);
	}
	
	public IntSLLNode(int i ,IntSLLNode n){
		info = i;
		next = n;
	}
  
}
