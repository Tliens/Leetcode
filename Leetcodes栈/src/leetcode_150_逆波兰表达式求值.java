import java.util.Stack;
public class leetcode_150_逆波兰表达式求值 {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String c:tokens ){
            if (!isNumber(c)){
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (c) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.peek();
    }
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
