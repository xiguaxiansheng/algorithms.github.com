package com.zjj.homework3;

import java.util.Iterator;

import org.omg.CORBA.Current;

import edu.princeton.cs.algs4.StdOut;

/*
 * Steque API
 * boolean isEmpty() 判断链表是否为空
 * void push(Item e) 表头插入元素
 * Item pop() 表头删除元素
 * void enqueue(Item e) 表尾插入元素
 * 
 */

public class Steque<Item> implements Iterable<Item>{
	
	// 首尾结点
	private Node first;
	private Node last;
	
	//结点类
	private class Node{	
		private Item item;
		private Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(Item e){
		Node node = new Node();
		node.item = e;
		if(isEmpty()){
			first = node;
			last = node;
			node.next = null;
		}else{
			node.next = first;
			first = node;
		}
	}
	
	public Item pop(){
		if(isEmpty())
			return null;
		else{
			Item e = first.item;
			first = first.next;
			return e;
		}
	}
	
	public void enqueue(Item e){
		Node node = new Node();
		node.item = e;
		node.next = null;
		if(isEmpty()){
			first = node;
			last = node;
		}else{
			last.next = node;
			last = node;
		}
	}
	
	//返回迭代器
	@Override
	public Iterator<Item> iterator(){
		return new Iter();
	}
	
	//迭代器实现
	private class Iter implements Iterator<Item>{

		//起点
		private Node current = first; 
		@Override
		public boolean hasNext() {
			// TODO 自动生成的方法存根
			return current != null;
		}

		@Override
		public Item next() {
			// TODO 自动生成的方法存根
			Item e = current.item;
			current = current.next;
			return e;
		}
		
	}

	//测试用例
	public static void main(String[] args) {
		
		Steque<String> s = new Steque<String>();
		s.enqueue("d");
		s.enqueue("e");
		s.enqueue("f");
		s.push("c");
		s.push("b");
		s.push("a");
		//预测输出: a b c d e f
		StdOut.print("Steque is :");
		Iterator<String> i = s.iterator();
		while(i.hasNext())
			StdOut.print(i.next()+" ");
		//预测输出: a b c d e f
		StdOut.println("");
		StdOut.print("pop is :");
		while(!s.isEmpty())
			StdOut.print(s.pop()+" ");
	}

	
}
