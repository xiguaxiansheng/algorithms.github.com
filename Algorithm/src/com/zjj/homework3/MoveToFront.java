package com.zjj.homework3;
/*
 * public class MoveToFront <Item>
 * public MoveToFront()  //创建空队列
 * public boolean isEmpty()  //是否为空
 * public int size()  //返回元素个数
 * public Node isInList(Item e)  //是否存在
 * public void insert(Item e)  //添加元素
 */
public class MoveToFront <Item>{

	private Node first;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public MoveToFront(){
		first =  null;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public Node isInList(Item e){
		//起点
		Node current = first;
		while(current.next != null){
			
			if(current.next.item.equals(e))
				return current;
			
			current = current.next;
		}
		return null;
	}
	
	public void insert(Item e){
		
		if(isEmpty()){
			first = new Node();
			first.item = e;
			N++;
		}else{
			
			if(first.item.equals(e)){
				return;
			}
			
			Node node = isInList(e);
			//如果存在相同
			if(node != null){
				//如果是最后一个元素
				if(node.next.next ==null){
					node.next = null;
					N--;
					//System.out.println("我执行到了这里1");
					//addAtFirst(e);
				}else{
					//删除结点
					Node temp = node.next;
					node.next = node.next.next;
					temp.next = null;
					N--;
					//System.out.println("我执行到了这里2");
					//addAtFirst(e);
					
				}
			}
			addAtFirst(e);
			}	
		
	}

	private void addAtFirst(Item e) {
		Node oldFirst = first;
		first = new Node();
		first.item = e;
		first.next = oldFirst;
		N++;
	}
	
	public void print(){
		Node current = first;
		while(current != null){
			System.out.printf("%2d",current.item);
			current = current .next;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,2};
		MoveToFront<Integer> mtf = new MoveToFront<Integer>();
		
		for(int i=0;i < arr.length; i++)
			mtf.insert(arr[i]);
		
		System.out.println(mtf.size());
		mtf.print();
	}

}
