package class038;

import class013.Impl;

import java.util.Stack;

public class c5ImplReverseStackWithRecursive {

    public static int bottomOut(Stack<Integer> stack){
        int ans = stack.pop();
        if (stack.isEmpty()){
            return ans;
        }else {
            int last = bottomOut(stack);
            stack.push(ans);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int num = bottomOut(stack);
        reverse(stack);
        stack.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
