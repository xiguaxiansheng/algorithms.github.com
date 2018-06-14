package com.zjj.homework3;

/*
 * public class RingBuffer <Item>
 * public RingBuffer(int N)  //创建空队列
 * boolean isEmpty()  //是否为空
 * boolean isFull() //是否为满
 * public void putData(Item item)  //存储数据
 * public Item getData() //获取数据
 */
public class RingBuffer<Item>{
	
	Item a[];
	private int first;
	private int last;
	
	public RingBuffer(int N){
		a = (Item[]) new Object[N];
	}
	
	public boolean isEmpty(){
		return first == last; 
	}

	public boolean isFull(){
		return (last + 1)%a.length == first%a.length;
	}
	
	public void putData(Item item){
		//while(isFull());
		a[(last++)%a.length] = item;
	}
	
	public Item getData(){
		//while(isEmpty());
		return a[(first++)%a.length];
	}
	
	public String toString(){
		return "the first is :"+first+",the last is :"+last;
	}
	
	public static void main(String[] args){
		
		RingBuffer<String> ringBuffer = new RingBuffer<String>(10);
		ringBuffer.putData("a");
		ringBuffer.putData("b");
		ringBuffer.putData("c");
		ringBuffer.putData("d");
		System.out.println(ringBuffer);
		System.out.println("getData_1:"+ringBuffer.getData());
		System.out.println("getData_2:"+ringBuffer.getData());
		System.out.println(ringBuffer);
		
	}
	
	
	
	
	
	
}
