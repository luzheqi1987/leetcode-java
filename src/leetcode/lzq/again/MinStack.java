/**
 * 
 */
package leetcode.lzq.again;

import java.util.Stack;

/**
 * @author Administrator
 * 
 */
public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		if (minStack.empty() || x <= minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);
	}

	public void pop() {
		if (!stack.empty() && stack.pop().equals(minStack.peek())) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack minstack = new MinStack();
		minstack.push(512);
		minstack.push(-1024);
		minstack.push(-1024);
		minstack.push(512);
		minstack.pop();
		System.out.println(minstack.getMin());
		minstack.pop();
		System.out.println(minstack.getMin());
		minstack.pop();
		System.out.println(minstack.getMin());
	}
}
