package com.zjj.homework3;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Josephus {

	public static void main(String[] args) {
		
		int N =Integer.parseInt( args[0]);
		int M =Integer.parseInt( args[1]);
		Queue<Integer> queue = new ArrayBlockingQueue<Integer>(N);
		
		for(int i = 0; i < N; i++)
			queue.add(i);
		
		while(!queue.isEmpty()){
			
		for(int j = 0; j < M-1; j++)
			queue.add(queue.remove());//
		System.out.println("kill No."+queue.remove());
		
		}
	}

}
