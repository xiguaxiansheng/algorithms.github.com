package com.zjj.homework3;


/*
 * public class GenerelizedQueueLinkList<Item>
 * GeneralizedQueueLinkList()  //创建空队列
 * boolean isEmpty()  //判断队列是否为空
 * void insert(Item e) //添加一个元素
 * Item delete(int k)  //删除并返回最早插入的第k个元素
 */

public class GeneralizedQueueLinkList<Item> {

	private Node first;
	private int N;
	
	private class Node<Item>{
		private Item item;
		private Node next;
	}
	
	public GeneralizedQueueLinkList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Item e){
		if(isEmpty()){
			first = new Node();
			first.item = e;
			first.next = null;
			N++;
		}else{
			Node node = new Node();
			node.item = e;
			Node current = first;
			while(current.next != null)
				current  = current.next;
			current.next = node;
			N++;
		}
	}
	
	public Item delete(int k){
		if(isEmpty())
			return null;
		
		if(k==1){
			Item item = (Item) first.item;
			first = null;
			N--;
			return item;
		}
		
		if(k <= N){
			
			Node current = first;
			//遍历到指定结点的前一个结点
			for(int i = 0; i < k - 2; i++){
				current = current.next;
			}
			//保存指定结点
			Item item = (Item) current.next.item;
			//重新指向
			if(k!=N){
			current .next = current.next.next;
			current.next.next = null;
			}else{
				current.next = null;
			}
			N--;
			return item;
			
		}else{
			return null;
		}
	}
	
	
	public void print(){
		Node current = first;
		while(current.next != null){
			System.out.print(current.item +" ");
			current = current.next;
		}
		System.out.println(current.item);
	}
	
	
	
	public static void main(String[] args) {
		
		GeneralizedQueueLinkList<String> list = new GeneralizedQueueLinkList<String>();
		list.insert("a");
		list.insert("b");
		list.insert("c");
		list.print();
		System.out.println("the size is :" + list.size());
		System.out.println("delete the No.3 :"+list.delete(3));
		list.print();
		System.out.println("the size is :" + list.size());
	}

}
