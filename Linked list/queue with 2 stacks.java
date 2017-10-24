
Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.

C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.

Assumptions

The elements in the queue are all Integers.
size() should return the number of elements buffered in the queue.
isEmpty() should return true if there is no element buffered in the queue, false otherwise.

public class Solution {
  private Stack<Integer> inStack;
  private Stack<Integer> outStack;
  public Solution() {
    inStack = new Stack<Integer>();
   	outStack = new Stack<Integer>();
  }
  
  public Integer poll() {
    if (outStack.isEmpty()) {
    	while (!inStack.isEmpty()) {
    		outStack.push(inStack.pop());
    	}
    }
    if (outStack.isEmpty()) return null;
    return outStack.pop();
  }
  
  public void offer(int element) {
    inStack.push(element);
  }
  
  public Integer peek() {
    if (outStack.isEmpty()) {
    	while (!inStack.isEmpty()) {
    		outStack.push(inStack.pop());
    	}
    }
    if (outStack.isEmpty()) return null; // can be the trick as in Java, just peek or pop in an empty stack will throw exception. 
    return outStack.peek();
  }
  
  public int size() {
    return inStack.size() + outStack.size();
  }
  
  public boolean isEmpty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }
}