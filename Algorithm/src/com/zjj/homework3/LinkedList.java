package com.zjj.homework3;

/*
 * 链表的实现
 */
public class LinkedList<Item> {
	
	private Node first;  //首结点
	//内嵌类
	private class Node{
		Item item;
		Node next;
	}
	
	//删除尾结点
	public void deleteLastNode() {
		
		Node current = first; //current 是 first的引用
		if(current == null)return;
		
		if(current.next == null)first = null;
		
		Node next = current.next;
		
		//找到最后第二个结点
		while(next.next != null) {
			current = next;
			next = next.next;
		}
		//删除最后一个结点
		current.next = null;
	}
	

}
