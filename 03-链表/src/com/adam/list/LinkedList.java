package com.adam.list;

@SuppressWarnings("unused")
public class LinkedList<E> extends AbstractList<E> {

	private Node<E> first;

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}

		@Override
		protected void finalize() throws Throwable {

			super.finalize();
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public E get(int idx) {

		return node(idx).element;
	}

	@Override
	public E set(int idx, E element) {
		Node<E> node = node(idx);

		E oldE = node.element;
		node.element = element;
		return oldE;
	}

	@Override
	public void add(int idx, E element) {
		if (idx == 0) {
			first = new Node<>(element, first);
		} else {
			Node<E> prev = node(idx - 1);
			prev.next = new Node<>(element, prev.next);
		}

		size++;
	}

	@Override
	public E remove(int idx) {
		Node<E> node = first;
		if (idx == 0) {
			first = first.next.next;
		} else {

			Node<E> prev = node(idx - 1);
			node = prev.next;
			prev = node.next;
		}

		size--;
		return node.element;
	}

	@Override
	public void remove(E element) {

	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}

				node = node.next;
			}
		}

		return ELEMENT_NOT_FOUND;

	}

	/**
	 * 给定idx查找Node
	 */
	private Node<E> node(int idx) {
		rangeCheck(idx);

		Node<E> node = first;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ArrayList [size=").append(size).append(", elements=(");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}

			stringBuilder.append(node.element);
			node = node.next;
		}
		stringBuilder.append(")]");
		return stringBuilder.toString();
	}

}
