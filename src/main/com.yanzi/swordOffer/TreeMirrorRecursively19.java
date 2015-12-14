package com.yanzi.swordOffer;

import java.util.Stack;

/*����һ����������������ľ���*/
public class TreeMirrorRecursively19 {
	void MirrorRecursively(BinaryTreeNode node){
		if(node == null)
			return;
		if(node.leftTree == null && node.rightTree == null)
			return;
		BinaryTreeNode temp = node.leftTree;
		node.leftTree = node.rightTree;
		node.rightTree = temp;
		if(node.leftTree != null)
			MirrorRecursively(node.leftTree);
		if(node.rightTree != null)
			MirrorRecursively(node.rightTree);	 
	}
	
		
	
	class BinaryTreeNode{
		int nodeValue;
		BinaryTreeNode leftTree;
		BinaryTreeNode rightTree;
	}
	
	

}
