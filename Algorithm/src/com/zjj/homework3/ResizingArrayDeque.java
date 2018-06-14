package com.zjj.homework3;

/*
 * ResizingArrayDeque API
 * ResizingArrayDeque() 创建空双向队列
 * boolean isEmpty() 判断双向队列是否为空
 * int size() 双向队列中的元素数量
 * void pushLeft(Item item) 向左端添加一个新元素
 * void pushRight(Item item) 向右端添加一个新元素
 * Item popLeft() 向左端删除一个元素
 * Item popRight() 向右端删除一个元素
 * void relize(int max) 动态调整数组长度
 * 实现 : 动态数组
 */
public class ResizingArrayDeque<Item> {

	private Item deque[];
	private int N = 0;

	public ResizingArrayDeque(int cap) {

		// 初始化队列
		deque = (Item[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	
	
	public void pushLeft(Item item) {

		if (N == deque.length)
			relize(deque.length * 2);

		if(isEmpty()){
			
			deque[N++] = item;
			
		}else{	
			
			for (int i = N; i > 0; i--){
				deque[i] = deque[i - 1];
			}
			
			deque[0] = item;
			N++;
		}
	}

	
	
	
	public void pushRight(Item item) {

		if (N == deque.length)
			relize(deque.length * 2);

		deque[N++] = item;
	}

	public Item popLeft() {
		
		if(isEmpty())
			return null;
		
		Item temp = deque[0];
		
		for (int i = 1; i < N; i++) {
			deque[i - 1] = deque[i];
		}
		deque[--N] = null;

		if (N > 0 && N == deque.length / 4)
			relize(deque.length / 2);

		return temp;
	}

	public Item popRight() {
		
		if(isEmpty())
			return null;
		
		Item temp = deque[N-1];
		deque[--N] = null;

		if (N > 0 && N == deque.length / 4)
			relize(deque.length / 2);

		return temp;
	}

	public void relize(int max) {

		// 创建新的数组
		Item item[] = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			item[i] = deque[i];
		}

		deque = item;

	}
	
	public static void main(String[] args){
		
		ResizingArrayDeque<String> deque = new ResizingArrayDeque<String>(4);
		System.out.println(deque.size());
		
		deque.pushLeft("a");
		deque.pushLeft("b");
		deque.pushLeft("c");
		deque.pushLeft("d");
		deque.pushLeft("e");
		//deque.pushRight("a");
		//deque.pushRight("b");
		//deque.pushRight("c");
		//deque.pushRight("d");
		//deque.pushRight("e");
		//System.out.println("预期输出:5");
		System.out.println(deque.size());
		System.out.println("预期输出:e,d,c,b,a");
		//System.out.println(deque.popRight());
		//System.out.println(deque.popRight());
		//System.out.println(deque.popRight());
		//System.out.println(deque.popRight());
		//System.out.println(deque.popRight());
		System.out.println(deque.popLeft());
		System.out.println(deque.popLeft());
		System.out.println(deque.popLeft());
		System.out.println(deque.popLeft());
		System.out.println(deque.popLeft());
		System.out.println(deque.size());
		}

}