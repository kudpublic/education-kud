package ua.kud;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/solution/
public class QueueFIFO_1 {

	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();

	public void push(int x) {
		if (s1.isEmpty()) {
			s1.push(x);
		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			s1.push(x);
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
	}

	public int pop() {
		return s1.pop();
	}

	public int peek() {
		return s1.peek();
	}

	public boolean empty() {
		return s1.isEmpty();
	}
}
