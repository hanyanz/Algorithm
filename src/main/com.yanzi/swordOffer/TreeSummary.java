package com.yanzi.swordOffer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeSummary {
	public static void main(String[] args){
		TreeSummary test = new TreeSummary();
		test.FindPath(null, 0);
	}
    //���ϵ������δ�ӡ������-------------------------------------------------------
	public void printFromTopToBottom(BinaryTreeNode node){
		if(node == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<BinaryTreeNode>();		
		while(node != null){
			System.out.print(node);
			if(node.leftTree != null){
				queue.add(node.leftTree);
			}
			if(node.rightTree != null){
				queue.add(node.rightTree);
			}
			//��queue����nodeʱ������
			node = queue.peek();
		}
	}
	//---------------------------------------------------------------------------
	
	//����һ����������������ľ���-------------------------------------------------
	public void mirrorRecursively(BinaryTreeNode root){
		if(root == null){
			return;
		}
		if(root.leftTree == null && root.rightTree == null){
			return;
		}
		BinaryTreeNode temp = root.leftTree;
		root.leftTree = root.rightTree;
		root.rightTree = temp;
		if(root.leftTree != null){
			mirrorRecursively(root.leftTree);
		}
		if(root.rightTree != null){
			mirrorRecursively(root.rightTree);
		}
	}
	//----------------------------------------------------------------------------	
		
	//�ж�һ�������ǲ��Ǻ����������-----------------------------------------------
	public boolean isSquenceOfBST(int[] sequence, int length){
		if(sequence == null || length <= 0){
			return false;
		}
		int root = sequence[length-1];
		int segment = 0;
		for(; segment < length-1; segment++){
			if(sequence[segment] > root){
				break;
			}
		}
		//segment��root���ܵ���������ʼ�ĵط�
		for(int i = segment; i < length-1; i++){
			if(sequence[i] < root){
				return false;
			}
		}
		boolean left = true;
		//�������������������������Ƿ����� �����������
		if(segment > 0){
			left = isSquenceOfBST(sequence,segment);
		}
		boolean right = true;
		//�������������������������Ƿ����� �����������
		if(segment < length-1){
			int[] rightSubSquence = new int[length-1-segment];
			for(int i = 0; i < length-1-segment;i++){
				rightSubSquence[i] = sequence[segment+i];
			}
			right = isSquenceOfBST(rightSubSquence,length-1-segment);
		}		
		return (left && right);
	}
	//----------------------------------------------------------------------------	
	
	//�ж�һ�����ǲ�����һ����������-----------------------------------------------
	public boolean isSubTree(BinaryTreeNode tree1, BinaryTreeNode tree2){
		boolean result = false;
		if(tree2 == null ){
			return true;
		}
		
		if(tree1 != null && tree2 != null){
			if(tree1.nodeValue == tree2.nodeValue){
				result = doesTree2InTree1(tree1,tree2);
			}
			if(!result){
				result = isSubTree(tree1.leftTree, tree2);
			}
			if(!result){
				result = isSubTree(tree1.rightTree,tree2);
			}
		}
		return result;
	}
	public boolean doesTree2InTree1(BinaryTreeNode tree1, BinaryTreeNode tree2){
		if(tree2 == null ){
			return true;
		}
		if(tree1 == null){
			return false;
		}
		if(tree1.nodeValue != tree2.nodeValue){
			return false;
		}
		return doesTree2InTree1(tree1.leftTree, tree2.leftTree)&&doesTree2InTree1(tree1.rightTree, tree2.rightTree);
	}
	
	
	
	//---------------------------------------------------------------------------
	//��ӡ���������н��ֵ��Ϊ��������������·��------------------------------------
	public void FindPath(BinaryTreeNode root, int expectedSum){
		String str = "_";
		str.replace("_", "2222");
		System.out.println(str);
		
	}
	//---------------------------------------------------------------------------
	class BinaryTreeNode{
		int nodeValue;
		BinaryTreeNode leftTree;
		BinaryTreeNode rightTree;
	}
}
