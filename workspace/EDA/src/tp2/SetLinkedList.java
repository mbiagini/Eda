package tp2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetLinkedList<T> implements Set<T>{
	
	private static class SetIterator<T> implements Iterator<T>{
		Node<T> current;
		
		public SetIterator(Node<T> first){
			this.current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			Node<T> ret = current;
			current = current.tail;
			return ret.elem;
		}
		
	}
	
	private static class Node<T>{
		T elem;
		Node<T> tail;
		
		public Node(T elem) {
			this.elem = elem;
			this.tail = null;
		}
	}
	
	Node<T> first;
	int size;

	@Override
	public boolean add(T e) {
		if (e == null)
			return false;
		Node<T> newNode = new Node<T>(e);
		newNode.tail = first;
		first = newNode;
		size++;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		if (o == null)
			return false;
		Node<T> current = first;
		while(current != null) {
			if (current.elem.equals(o)) {
				return true;
			}
			current = current.tail;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterator<T> iterator() {
		return new SetIterator<T>(first);
	}

	@Override
	public boolean remove(Object o) {
		if (o == null || first == null)
			return false;
		Node<T> current = first;
		if (current.elem.equals(o)) {
			first = current.tail;
			size--;
			return true;
		}
		Node<T> next = current.tail;
		while (next != null) {
			if (next.elem.equals(o)) {
				current.tail = next.tail;
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
	
}
