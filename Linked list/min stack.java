Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1

push(int element) - push the element to top
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.

public class Solution {
  public Solution() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }
  
  public int pop() {
    if (stack.isEmpty()) return -1;
    int ret = stack.pop();
    if (minStack.peek() == ret) minStack.pop();
    return ret;
  }
  
  public void push(int element) {
    stack.push(element);
    if (minStack.isEmpty() || minStack.peek() >= element) minStack.push(element);
  }
  
  public int top() {
    if (stack.isEmpty()) return -1;
    return stack.peek();
  }
  
  public int min() {
    if (stack.isEmpty()) return -1;
    return minStack.peek();
  }

  private Stack<Integer> stack;
  private Stack<Integer> minStack;
}
