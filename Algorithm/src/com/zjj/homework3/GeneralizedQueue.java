package com.zjj.homework3;


/*
 * public class GeneralizedQueue<Item>
 * GeneralizedQueue()  //创建一条空队列
 * boolean isEmpty() //队列是否为空
 * void insert(Item e) //添加一个元素
 * Item delete(int k) //删除并返回最早插入的第k个元素
 * 实现 : 数组
 */

public class GeneralizedQueue<Item> {
	
	private Item queue[];
	private int N;
	
	public GeneralizedQueue(){
		queue = (Item[]) new Object[10];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Item e){
		queue[N++] = e;
	}
	
	public Item delete(int k){
		Item temp = queue[k-1];
		for(;k < N; k++)
			queue[k - 1] = queue[k];
		queue[--N] = null;
		return temp;
	}
	
	public int size(){
		return N;
	}
	
	public static void main(String[] args){
		GeneralizedQueue<String> queue = new GeneralizedQueue<String>();
		queue.insert("a");
		queue.insert("b");
		queue.insert("c");
		queue.insert("d");
		queue.insert("e");
		System.out.println("the size is:"+queue.size());
		System.out.println("delete the No.4:"+queue.delete(4));
		System.out.println("the size is:"+queue.size());
		
	}
	

}
