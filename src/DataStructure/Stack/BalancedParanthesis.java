package DataStructure.Stack;

import java.util.Stack;

public class BalancedParanthesis {
    public static boolean isBalanced(String expression){
//        Stack<Character> stack = new Stack<>();
//
//
//        if(stack.isEmpty()==true && expression.charAt(0)==')')
//        {
//            return false;
//        }
//        for(int i=0; i<expression.length(); i++)
//        {
//            if(expression.charAt(i)=='(')
//            {
//                stack.push(expression.charAt(i));
//            }
//            else if(expression.charAt(i)==')'&& (stack.peek()=='(' && stack.isEmpty()!=true)) {
//                stack.pop();
//            }
//            else if(expression.charAt(i)==')' && stack.isEmpty()==true)
//            {
//                return false;
//            }
//
//        }
//
//        return stack.isEmpty();

        Stack<Character> stack = new Stack<>();
        for(int i =0;i<expression.length();i++){
            if(expression.charAt(i) == '('){
                stack.push(expression.charAt(i));
            }else if(expression.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();

                if (expression.charAt(i) == ')' && topChar == '(') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
            String str = "([)]";
            boolean ans = isBalanced(str);
        System.out.println(ans);
    }
}
