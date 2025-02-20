package class031;

public class ImplPowerOfTwo {

    public static boolean isPowerOfTwo(int num){
        return (num > 0) && ((num ^ ( num & (-num))) == 0);
    }//取最有的1是与操作
}
