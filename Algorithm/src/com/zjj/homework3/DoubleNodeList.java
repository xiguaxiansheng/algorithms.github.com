package com.zjj.homework3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
 * 双链表的实现
 */
public class DoubleNodeList<Item> {

	// first node,last node
	private DoubleNode first;
	private DoubleNode last;

	// node
	public static class DoubleNode<E> {
		private DoubleNode next;
		private DoubleNode prev;
		private E item;
	}

	// 初始化头尾结点
	public DoubleNodeList() {
		first = null;
		last = null;
	}

	// 在表头插入结点
	public static <T> void addNodeAsFirst(DoubleNodeList<T> list, T item) {

		DoubleNode<T> oldFirst = list.first;// 保存旧的first
		list.first = new DoubleNode<T>();// 新建名为first的结点保存要加入的结点
		list.first.item = item;// 赋值
		list.first.next = oldFirst;// 新结点的后驱指向旧的first
		list.first.prev = null;// first的前驱为空

		// 判断插入前list是否为空
		if (oldFirst != null)
			oldFirst.prev = list.first;// 旧的first前驱指向新结点
		else
			list.last = list.first;

	}

	// 在表尾插入结点

	public static <T> void addNodeAsLast(DoubleNodeList<T> list, T item) {
		DoubleNode<T> oldLast = list.last;
		list.last = new DoubleNode<T>();
		list.last.item = item;
		list.last.prev = oldLast;
		list.last.next = null;

		if (oldLast != null)
			oldLast.next = list.last;
		else
			list.first = list.last;

	}

	// 在表头删除结点
	public static <T> void deleteNodeAtFirst(DoubleNodeList<T> list) {
		if (list.first == null)
			return;// do nothing

		list.first = list.first.next;// list的first指向后驱结点
		// 判断删除后是否为空
		if (list.first != null) {
			// 不为空
			list.first.prev.next = null;// 将删除的结点的后驱结点指向null
			list.first.prev = null;// 将新的first前驱结点指向null
		} else {
			list.last = null;// 为空,last赋值null
		}

	}

	// 在表尾删除结点
	public static <T> void deleteNodeAtLast(DoubleNodeList<T> list) {
		if (list.last == null)
			return;

		list.last = list.last.prev;

		if (list.last != null) {
			list.last.next.prev = null;
			list.last.next = null;
		} else {
			list.first = null;
		}
	}

	// 循环链表表找到指定值的结点
	public static <T> DoubleNode findDoubleNodeByItem(DoubleNodeList<T> list, T item) {
		DoubleNode<T> current = list.first;

		while (current != null) {
			if (current.item.equals(item))
				break;
			current = current.next;
		}
		return current;
	}

	// 判断结点是否在链表中
	public static <T> boolean isInList(DoubleNodeList<T> list, DoubleNode<T> node) {
		DoubleNode<T> current = list.first;

		while (current != null) {
			if (current == node)
				return true;
			current = current.next;
		}
		return false;
	}

	// 在指定点前添加结点
	public static <T> void addNodeBeforeNode(DoubleNodeList<T> list, DoubleNode<T> node, T item) {

		if (node == null)
			return;// do nothing
		// 判断结点是否在链表中
		if (isInList(list, node)) {

			// 判断node是否为first
			if (node.prev != null) {
				DoubleNode<T> newNode = new DoubleNode<T>();
				newNode.item = item;
				newNode.next = node;
				newNode.prev = node.prev;
				node.prev.next = newNode;
				node.prev = newNode;

			} else {
				addNodeAsFirst(list, item);
			}
		}

	}

	// 在指定点后添加结点
	public static <T> void addNodeAfterNode(DoubleNodeList<T> list, DoubleNode<T> node, T item) {

		if (node == null)
			return;// do nothing
		// 判断结点是否在链表中
		if (isInList(list, node)) {

			// 判断node是否为last
			if (node.next != null) {
				DoubleNode<T> newNode = new DoubleNode<T>();
				newNode.item = item;
				newNode.prev = node;
				newNode.next = node.next;
				node.next.prev = newNode;
				node.next = newNode;

			} else {
				addNodeAsLast(list, item);
			}
		}

	}

	// 删除指点结点

	public static <T> void deleteByNode(DoubleNodeList<T> list, DoubleNode<T> node) {

		if (node == null)
			return;
		// 判断结点在不在链表中
		if (isInList(list, node)) {
			if (list.first == node) {
				deleteNodeAtFirst(list);
			} else if (list.last == node) {
				deleteNodeAtLast(list);
			} else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node.next = null;
				node.prev = null;
			}

		}
	}

	@Override
	public String toString() {
		String s = "";

		DoubleNode<Item> current = first;
		while (current != null) {
			s += current.item + " ";
			current = current.next;
		}

		s += first == null ? "first:null " : "first:" + first.item + " ";
		s += last == null ? "last:null " : "last:" + last.item + " ";

		return s;
	}

	public static void main(String[] args) {

		DoubleNodeList<Integer> list = new DoubleNodeList<Integer>();
		for (int i = 1; i < 11; i++) {
			DoubleNodeList.addNodeAsFirst(list, i);
		}

		StdOut.println("test:addNodeAsFirst:11");
		StdOut.println(list);
		DoubleNodeList.addNodeAsFirst(list, 11);
		StdOut.println(list);
		StdOut.println("------------------------------");

		StdOut.println("test:deleteNodeAtFirst:11");
		StdOut.println(list);
		DoubleNodeList.deleteNodeAtFirst(list);
		StdOut.println(list);
		StdOut.println("------------------------------");

		StdOut.println("test:addNodeAsLast:0");
		StdOut.println(list);
		DoubleNodeList.addNodeAsLast(list, 0);
		StdOut.println(list);
		StdOut.println("------------------------------");

		StdOut.println("test:deleteNodeAtLast:0");
		StdOut.println(list);
		DoubleNodeList.deleteNodeAtLast(list);
		StdOut.println(list);
		StdOut.println("------------------------------");

		StdOut.println("test:addNodeBeforeNode:'11 10','20 5'");
		StdOut.println(list);
		DoubleNode<Integer> node1 = DoubleNodeList.findDoubleNodeByItem(list, 10);
		DoubleNode<Integer> node2 = DoubleNodeList.findDoubleNodeByItem(list, 5);
		DoubleNodeList.addNodeBeforeNode(list, node1, 11);
		DoubleNodeList.addNodeBeforeNode(list, node2, 20);
		StdOut.println(list);
		StdOut.println("------------------------------");

		StdOut.println("test:deleteNodeAtLast:'1 0','5 20'");
		StdOut.println(list);
		DoubleNode<Integer> node3 = DoubleNodeList.findDoubleNodeByItem(list, 1);
		DoubleNode<Integer> node4 = DoubleNodeList.findDoubleNodeByItem(list, 5);
		DoubleNodeList.addNodeAfterNode(list, node3, 0);
		DoubleNodeList.addNodeAfterNode(list, node4, 20);
		StdOut.println(list);
		StdOut.println("------------------------------");

		StdOut.println("test:deleteByNode:-1,-5");
		StdOut.println(list);
		DoubleNode<Integer> node5 = DoubleNodeList.findDoubleNodeByItem(list, 1);
		DoubleNode<Integer> node6 = DoubleNodeList.findDoubleNodeByItem(list, 5);
		DoubleNodeList.deleteByNode(list, node5);
		DoubleNodeList.deleteByNode(list, node6);
		StdOut.println(list);
	}

}
