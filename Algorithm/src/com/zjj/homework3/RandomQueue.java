package com.zjj.homework3;

import edu.princeton.cs.algs4.StdRandom;

/*
 * public class RandomQueue<Item>
 * RandomQueue() //生成空的随机队列
 * boolean isEmpty() //队列是否为空
 * void enqueue(Item item) //添加一个元素
 * Item dequeue() //删除并随机返回一个元素
 * Item sample() //随机返回一个元素但不删除它
 */
public class RandomQueue<Item> {

	private Item queue[];
	private int N = 0;

	public RandomQueue() {
		queue = (Item[]) new Object[10];
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size(){
		return N;
	}

	public void enqueue(Item item) {
		// 调整数组
		if (N == queue.length)
			relize(queue.length * 2);

		queue[N++] = item;
	}

	public Item deqeue() {

		if (isEmpty())
			return null;

		int r = StdRandom.uniform(N);
		Item temp = queue[r];
		queue[r] = queue[--N];
		queue[N] = null;
		// 调整数组
		if (N == queue.length / 4)
			relize(queue.length / 2);

		return temp;
	}

	public Item sample() {

		if (isEmpty())
			return null;

		int r = StdRandom.uniform(N);
		return queue[r];
	}

	public void relize(int max) {
		Item arr[] = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			arr[i] = queue[i];
		}
		queue = arr;
	}

	public static void main(String[] args) {

		RandomQueue<Card> cards = new RandomQueue<Card>();

		String[] names = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		String[] colors = { "红桃", "黑桃", "梅花", "棉花" };
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < colors.length; j++) {
				Card card = new Card();
				card.setCard(colors[j] + names[i]); 
				cards.enqueue(card);
			}
		}

		System.out.println("牌的总数为："+cards.size());
		for (int i = 0; i < 13; i++)
			System.out.print(cards.deqeue()+" ");
		System.out.println("");
		System.out.println("剩余牌的总数为："+cards.size());

	}

}
