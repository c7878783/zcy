package class033;

public class ImplBitOperationAddMinusMultiplyDivide {

    public static int add(int a, int b){
        int ans = 0;
        while (b != 0){
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int minus(int a, int b){
        return add(a, neg(b));
    }
    public static int neg(int a){
        return add(~a, 1);
    }
    public static int multiply(int a, int b){
        int ans = 0;
        while (b != 0){
            if ((b & 1) != 0){
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }
    public static int MIN = Integer.MAX_VALUE;

    public static int divide(int a, int b){
        if ((a == MIN) && (b == MIN)){
            return 1;
        }
        if ((a != MIN) && (b != MIN)){
            return div(a, b);
        }
        if (b == MIN){
            return 0;
        }
        if (b == neg(1)){
            return Integer.MAX_VALUE;
        }
        a = add(a, b > 0? b : neg(b));//整数最小是个负数，调用div会无法得到相反数，因为正数最大值要缺一个，所以先削掉一部分，再加回来。
        int ans = div(a, b);
        int offset = b > 0? neg(1) : 1;
        return add(ans, offset);
    }
    public static int div(int a, int b){
        int x = a < 0? neg(a) : a;
        int y = a < 0? neg(b) : b;
        int ans = 0;
        while (x >= y){
            for (int i = 30; i >= 0; minus(i, 1)){
                if ((x >> i) >= y) {
                    ans |= (1 << i);
                    x = minus(x, y << i);
                }
            }
        }
        return (a < 0) ^ (b < 0)? neg(ans) : ans;
    }
}
