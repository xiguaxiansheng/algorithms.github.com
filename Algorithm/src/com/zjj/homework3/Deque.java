package com.zjj.homework3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

/*
 * Deque API
 * Deque() 创建空双向队列
 * boolean isEmpty() 判断双向队列是否为空
 * int size() 双向队列中的元素数量
 * void pushLeft(Item item) 向左端添加一个新元素
 * void pushRight(Item item) 向右端添加一个新元素
 * Item popLeft() 向左端删除一个元素
 * Item popRight() 向右端删除一个元素
 * 实现 : 双向链表
 */
public class Deque<Item> implements Iterable<Item>{
	
	private DoubleNode left;
	private DoubleNode right;
	private int size = 0;
	
	private class DoubleNode{
		private Item item;
		private DoubleNode next;
		private DoubleNode prev;
	}
	
	public Deque(){
		left = null;
		right = null;
	}
	
	public boolean isEmpty(){
		return left == null;
	}
	
	public int size(){
		return size;
	}
	
	public void pushLeft(Item item){
		DoubleNode node = new DoubleNode();
		node.item = item;
		node.prev = null;
		
		if(!isEmpty()){
			left.prev = node;
			node.next = left;
			left = node;
		}else{
			node.next = null;
			left = node;
			right = node;
		}
		size++;
	}
	
	public void pushRight(Item item){
		DoubleNode node = new DoubleNode();
		node.item = item;
		node.next = null;
		
		if(!isEmpty()){
			right.next = node;
			node.prev =right;
			right = node;
		}else{
			node.prev = null;
			left = node;
			right = node;
		}
		size++;
		
	}
	
	public Item popLeft(){
		
		if(isEmpty())
			return null;
		
		Item item = left.item;
		left = left.next;
	
		if(left != null){
			left.prev.next = null;
			left.prev = null;
		}else{
			left = right = null;
		}
		
		size--;
		return item;	
	}
	
	public Item popRight(){
		if(isEmpty())
			return null;
		Item item = right.item;
		right = right.prev;
		
		if(size == 1){
			left = right = null;
		}else{
			right.next.prev = null;
			right.next = null;
		}
		
		size--;
		return item ;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO 自动生成的方法存根
		return new Iter();
	}
	
	private class Iter implements Iterator<Item>{

		//起点
		private DoubleNode current = left;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	//测试用例
	public static void main(String[] args) {
		
		Deque<String> deque = new Deque<String>();
		
		deque.pushLeft("c");
		deque.pushLeft("b");
		deque.pushLeft("a");
		deque.pushRight("d");
		deque.pushRight("e");
		deque.pushRight("f");

		StdOut.println("预计输出：a b c d e f");
		StdOut.print("deque is :");
		Iterator<String> i = deque.iterator();
		while(i.hasNext())
			StdOut.print(i.next() + " ");
		StdOut.println("");
		StdOut.println("预计长度：6");
		StdOut.println("size:"+deque.size);
		
		StdOut.println("预计输出：a f");
		StdOut.print(deque.popLeft()+" ");
		StdOut.print(deque.popRight());
		StdOut.println("");
		StdOut.println("预计长度：4");
		StdOut.print(deque.size);
		
	}


}
