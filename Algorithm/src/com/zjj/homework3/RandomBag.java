package com.zjj.homework3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/*
 * public class RandomBag<Item> implements Iterable <Item>
 * RandomBag() //创建空的 背包
 * boolean isEmpty()  //背包是否为空
 * int size()  //背包的元素数量
 * void add(Item item)  //添加一个元素
 */
public class RandomBag<Item> implements Iterable<Item>{
	
	private Item bag[];
	private int N = 0;
	
	public RandomBag(int N){
		//新建空的背包
		bag = (Item[]) new Object[N];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item){
		bag[N++] = item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new Iter();
	}
	
	private class Iter implements Iterator<Item>{

		private int current = 0 ; //起点
		
		public Iter(){
			for(int i = 0 ; i < N ; i++){
				int r = StdRandom.uniform(N);
				Item temp = (Item) bag[i];
				bag[i] = bag[r];
				bag[r] = temp;
			}
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return (Item) bag[current++];
		}
		
	}
	
	public static void main(String[] args){
		RandomBag<String> bag = new RandomBag<>(10);
		bag.add("a");
		bag.add("b");
		bag.add("c");
		bag.add("d");
		bag.add("e");
		bag.add("f");
		bag.add("g");
		bag.add("h");
		bag.add("i");
		bag.add("j");
		System.out.println("the bag's size is:"+bag.size());
		Iterator<String> iter = bag.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+",");
		}
	}
	
}
