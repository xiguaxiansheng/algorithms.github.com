package com.zjj.homework3;

import edu.princeton.cs.algs4.StdOut;

/*
 * 实现队列
 * 复制队列
 */
public class Queue<Item> {
	
	private Item[] queue;
	private int N ;
	
	public Queue(int N){
		queue = (Item[]) new Object[N];
	}
	
	public Queue(Queue q){
		
		queue = (Item[]) new Object[q.size()];
		
		while(N != q.size()){
			Item temp = (Item) q.dequeue();
			enqueue(temp);
			q.enqueue(temp);
		}
		
	}
	
	public void enqueue(Item item){
		if(isEmpty()){
			
			queue[N++] = item;
			
		}else{	
			
			for (int i = N; i > 0; i--){
				queue[i] = queue[i - 1];
			}
			queue[0] = item;
			N++;
		}
		
	}
	
	public Item dequeue(){
		return queue[--N];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	
	public static void main(String[] args){
		
		Queue<Integer> q = new Queue<Integer>(10);
		
		for(int i = 0; i < 10; i++)
			q.enqueue(i);
		
		Queue<Integer> t = new Queue<Integer>(q);
		
		while(!q.isEmpty())
			StdOut.print(q.dequeue()+" ");
		
		StdOut.println(" ");
		
		while(!t.isEmpty())
			StdOut.print(t.dequeue()+" ");
	}
	
	
	
}
