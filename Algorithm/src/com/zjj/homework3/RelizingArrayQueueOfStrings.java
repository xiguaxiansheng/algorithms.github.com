package com.zjj.homework3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RelizingArrayQueueOfStrings<Item> {

	private Item[] arr;
	private int N;

	@SuppressWarnings("unchecked")
	public RelizingArrayQueueOfStrings(int cap) {
		arr = (Item[]) new Object[cap];
	}

	// 入列
	private void enqueue(Item item) {
		if (N == arr.length)
			resize(2 * arr.length);
		arr[N++] = item;
	}

	// 出列
	private Item dequeue() {
		Item temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[--N] = null;
		if (N > 0 && N == arr.length / 4)
			resize(arr.length / 2);
		return temp;
	}

	private boolean isEmpty() {
		return N == 0;
	}

	private int size() {
		return N;
	}

	// 调整数组大小,数据转移到新数组
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		// 创建泛型数组
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	public static void main(String[] args) {

		/*
		 * 本类的测试用例 RelizingArrayQueueOfStrings<String> queue = new
		 * RelizingArrayQueueOfStrings<String>(10); while(!StdIn.isEmpty()) { String
		 * item = StdIn.readString(); if(!item.equals("-")) queue.enqueue(item); else
		 * if(!queue.isEmpty()) StdOut.print(queue.dequeue()+" "); }
		 * StdOut.println("("+queue.size()+"left on queue)");
		 */

		/*
		 * 用例：接受命令行参数 k,返回倒数第k个数 思路：出列n-k个数，得到倒数第k个数
		 */
		RelizingArrayQueueOfStrings<String> queue = new RelizingArrayQueueOfStrings<String>(4);

		while (!StdIn.isEmpty())
			queue.enqueue(StdIn.readString());

		int k = Integer.parseInt(args[0]);
		int size = queue.size();// 保存队列的初始长度

		for (int i = 0; i < size - k; i++)
			queue.dequeue();
		StdOut.print(queue.dequeue());
	}

}
