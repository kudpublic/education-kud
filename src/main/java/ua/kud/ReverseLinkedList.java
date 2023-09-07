package ua.kud;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node tail = buildLinkedList();
		print(tail);

		tail = reverse(tail);

		System.out.println("");
		print(tail);
	}

	private static void print(Node tail) {
		Node n = tail;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}

	private static Node reverse(Node tail) {
		Node current = tail;
		Node prev = null;
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static Node buildLinkedList() {
		Node tail = new Node(0);
		Node current = tail;
		for (int i = 1; i < 100; i++) {
			Node next = new Node(i);
			current.next = next;
			current = next;
		}
		return tail;
	}

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}
}
