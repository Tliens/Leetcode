import java.util.Stack;
public class leetcode_856_括号的分数 {
	public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int score = 0;
        for (char c: s.toCharArray()) {
            if (c == '('){
                stack.push(0);
            }else{
                int top = stack.peek();
                //上一步不为0，说明有套嵌 将分数*2
                //上一步为0的话，说明就是最外的一层 加1  比如() +1分，并弹出栈
                top = top==0?1:top*2;
                //将栈顶元素弹出，并修改栈顶值，计算好的分数
                stack.pop();
                //如果栈为空了，说明完结一个结构  比如 ()() 计2分  ()计1分
                if(stack.isEmpty()){
                    score+=top;
                }else{  //栈不为空，说明有套嵌的结构  比如 (())
                        //此时修改栈顶的值，即上一步计算的值 +1或*2的
                    int inScore = stack.pop();
                    inScore+=top;
                    stack.push(inScore);
                }
            }
        }
        return score;
    }
	/*
	作者：ninjutsu
	链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/856-yong-zhan-shi-xian-jian-dan-yi-li-ji-nuya/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	*/
}
