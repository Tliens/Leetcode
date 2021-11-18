import java.util.Stack;
/// https://leetcode-cn.com/problems/implement-queue-using-stacks/
public class leetcode_232_用栈实现队列 {

	class MyQueue {

	    Stack<Integer> stack1;
	    Stack<Integer> stack2;

	    public MyQueue() {
	        stack1 = new Stack<Integer>();
	        stack2 = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        stack1.push(x);
	    }
	    
	    public int pop() {
	        if (stack2.empty()){
	            while (!stack1.empty()){
	                stack2.push(stack1.pop());
	            }
	        }
	        return stack2.pop();
	    }
	    
	    public int peek() {
	        int x = this.pop();
	        stack2.push(x);
	        return x;
	    }
	    
	    public boolean empty() {
	        if (stack1.empty() && stack2.empty()){
	            return true;
	        }else{
	            return false;
	        }
	    }
	}
}
