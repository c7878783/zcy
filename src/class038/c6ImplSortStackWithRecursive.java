package class038;

import java.util.Stack;

public class c6ImplSortStackWithRecursive {

    public static int deep(Stack<Integer> stack){
        if (stack.isEmpty()){
            return 0;
        }
        int num = stack.pop();
        int deep = deep(stack) + 1;
        stack.push(num);
        return deep;
    }

    public static int max(Stack<Integer> stack, int deep){
        if (deep == 0){
            return Integer.MIN_VALUE;
        }
        Integer num = stack.pop();
        int max = Math.max(num, max(stack, deep - 1));//一层层比最大，把max方法栈压进去就成了，先从最浅层开始比较，然后依次向下去比较
        stack.push(num);
        return max;
    }

    public static int times(Stack<Integer> stack, int deep, int max){
        if (deep == 0){
            return 0;
        }else {
            Integer num = stack.pop();
            int times = times(stack, deep - 1, max) + ((num == max)? 1 : 0);
            stack.push(num);
            return times;
        }
    }

    public static void down(Stack<Integer> stack, int deep, int max, int k) {
        if (deep == 0) {
            for (int i = 0; i < k; i++) {
                stack.push(max);
            }
        } else {
            int num = stack.pop();
            down(stack, deep - 1, max, k);
            if (num != max) {
                stack.push(num);
            }
        }
    }

    public static void sort(Stack<Integer> stack){
        int deep = deep(stack);
        while (deep > 0){
            int max = max(stack, deep);
            int times = times(stack, deep, max);
            down(stack, deep, max, times);
            deep -= times;
        }
    }


    public static Stack<Integer> randomStack(int n, int v) {
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            ans.add((int) (Math.random() * v));
        }
        return ans;
    }

    // 为了测试
    // 检测栈是不是从顶到底依次有序
    public static boolean isSorted(Stack<Integer> stack) {
        int step = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (step > stack.peek()) {
                return false;
            }
            step = stack.pop();
        }
        return true;
    }

    // 为了测试
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.add(1);
        test.add(5);
        test.add(4);
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(2);
        sort(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

        // 随机测试
        int N = 20;
        int V = 20;
        int testTimes = 20000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N);
            Stack<Integer> stack = randomStack(n, V);
            sort(stack);
            if (!isSorted(stack)) {
                System.out.println("出错了!");
                break;
            }
        }
        System.out.println("测试结束");
    }

}
