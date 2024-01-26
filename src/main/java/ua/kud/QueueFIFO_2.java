package ua.kud;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/solution/
public class QueueFIFO_2 {

	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();

	public void push(int x) {
		s1.push(x);
	}

	public int pop() {
		pushSecondStackIfEmpty();
		return s2.pop();
	}

	public int peek() {
		pushSecondStackIfEmpty();
		return s2.peek();
	}

	private void pushSecondStackIfEmpty() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
	}

	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}
