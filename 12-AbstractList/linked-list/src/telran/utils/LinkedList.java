package telran.utils;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkedList<T> extends AbstractList<T> {
	static private class Node<T> {
		public T obj;
		public Node<T> next;
		public Node<T> prev;
		public Node(T obj) {
			this.obj = obj;
		}

	}
	private Node<T> head;
	private Node<T> tail;
	

	@Override
	public void add(T obj) {
		Node<T> node = new Node<T>(obj);
		if (tail != null) {
			tail.next = node;
			node.prev = tail;
			tail = node;
		} else {
			head = tail = node;
		}
		size++;

	}

	@Override
	public boolean add(T obj, int index) {
		if (!isValidIndex(index))
			return false;
		if (index == 0) {
			addHead(obj);
		}
		else if (index == size) {
			add(obj);
		}
		else {
			addByIndex(obj, index);
		}
		return true;
	}

	private void addByIndex(T obj, int index) {
		Node<T> node = new Node<T>(obj);
		Node<T> current = getNodeIndex(index);
		current.prev.next = node;
		node.prev = current.prev;
		current.prev = node;
		node.next = current;		
	}

	private void addHead(T obj) {
		Node<T> node = new Node<T>(obj);
		if (head != null) {
			head.prev = node;
			node.next = head;
			head = node;
		}
		else
			head = tail = node;
		size++;
	}

	@Override
	public T get(int index) {
		return isValidIndex(index) ? getNodeIndex(index).obj : null;
	}

	

	@Override
	public boolean remove(int index) {
		if (!isValidIndex(index)) {
			return false;
		}
		removeNode(getNodeIndex(index));
		return true;
	}

	private void removeNode(Node<T> node) {
		if (head == tail) {
			head = tail = null;
			size = 0;
			return;
		}
		if (node == head) {
			removeHead();
			
		} else if (node == tail) {
			removeTail();
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
		
		
	}

	private void removeTail() {
		tail.prev.next = null;
		tail = tail.prev;
		
	}

	private void removeHead() {
		head.next.prev = null;
		head = head.next;
		
	}

	@Override
	public boolean remove(T pattern) {
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			if (current.obj.equals(pattern)) {
				removeNode(current);
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public void addAll(List<T> objects) {
		for (int i = 0; i < objects.size(); i++) {
			add(objects.get(i));
		}
	}

	@Override
	public T set(T object, int index) {
		if (!isValidIndex(index))
			return null;
		T value = getNodeIndex(index).obj;
		getNodeIndex(index).obj = object;
		return value;
	}

	@Override
	public boolean swap(int index1, int index2) {
		if (!isValidIndex(index1) || !isValidIndex(index2)) {
			return false;
		}
		Node <T> index1Node = getNodeIndex(index1);
		Node <T> index2Node = getNodeIndex(index2);
		Node <T> swap = new Node <T>(index1Node.obj);
		index1Node.obj = index2Node.obj;
		index2Node.obj = swap.obj;
		
//		Node<T> swap = getNodeIndex(index1);
//		getNodeIndex(index1).obj = getNodeIndex(index2).obj;
//		getNodeIndex(index2).obj = swap.obj;
		return true;
	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			if (predicate.test(current.obj))
				return i;
			current = current.next;
		}
		return -1;
	}
	
	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		Node <T> current = tail;
		for (int i = size - 1; i >= 0; i--) {
			if(predicate.test(current.obj))
				return i;
			
		}
		return -1;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		Node <T> current = tail;
		for (int i = size - 1; i >= 0; i--) {
			if(predicate.test(current.obj)) {
				removeNode(current);
				return true;
			}
		}
		return false;
	}

	@Override
	public void clean() {
		head = tail = null;
	}
	private Node<T> getNodeIndex(int index) {
		
		return index < size / 2 ? getNodeLtR(index) : getNodeRtL(index);
	}

	private Node<T> getNodeRtL(int index) {
		Node<T> current = tail;
		for(int i = size - 1; i > index; i--) {
			current = current.prev;
		}
		return current;
	}

	private Node<T> getNodeLtR(int index) {
		Node<T> current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		Node<T> current = head;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T res = current.obj;
			current = current.next;
			return res;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Iterator.super.remove();
		}

		@Override
		public void forEachRemaining(Consumer<? super T> action) {
			// TODO Auto-generated method stub
			Iterator.super.forEachRemaining(action);
		}
		
	}

}
