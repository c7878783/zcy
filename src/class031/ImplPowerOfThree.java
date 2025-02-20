package class031;

public class ImplPowerOfThree {
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    //意思是所有3的某次幂都可以让1162261467整除
}
