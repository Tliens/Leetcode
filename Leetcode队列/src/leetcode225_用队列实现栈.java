import java.util.Queue;
import java.util.LinkedList;

public class leetcode225_用队列实现栈 {
	class MyStack {

	    Queue<Integer> queue1;
	    Queue<Integer> queue2;

	    public MyStack() {
	        queue1 = new LinkedList<Integer>();
	        queue2 = new LinkedList<Integer>();
	    }
	    
	    public void push(int x) {
	        queue2.offer(x);
	        while (!queue1.isEmpty()){
	            queue2.offer(queue1.poll());
	        }
	        Queue<Integer> temp = queue1;
	        queue1 = queue2;
	        queue2 = temp;
	    }
	    
	    public int pop() {
	        return queue1.poll();
	    }
	    
	    public int top() {
	        return queue1.peek();
	    }
	    
	    public boolean empty() {
	        return queue1.isEmpty();
	    }
	}
}
