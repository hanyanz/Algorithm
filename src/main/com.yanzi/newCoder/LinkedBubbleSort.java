package com.yanzi.newCoder;

public class LinkedBubbleSort {
	public static void main(String[] args){
		Node head = new Node(2);
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(6);
		Node n4 = new Node(5);
		Node n5 = new Node(9);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		bubbleSort(head);		
	}
	public static void bubbleSort(Node head){
		Node lastNode = null;
		Node tempNode = null;
		Node itor = null;
		Node first = head;
		while(head != lastNode){		
			for(itor = first; itor.next != lastNode; itor = itor.next){
				if(itor.num > itor.next.num){
					tempNode = itor.next;
					itor.next = tempNode.next;
					tempNode.next = itor;
					if(itor == head){
						head = tempNode;
					}
				}
			}
			lastNode = itor;
		}
		for(Node it = head; it != null; it = it.next){
			System.out.println(it.num);
		}
	}
	static class Node{
		Integer num;
		Node next;
		Node(Integer num){
			this.num = num;
			this.next = null;
		}
	}

}
