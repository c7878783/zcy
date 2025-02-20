package class031;

public class ImplLeftToRightAnd {


    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right){
            right -= right & -right;//去掉right中最右边的1，如过去掉后还比left大，则说明去掉的这个区间中一定在这个位置有个0要与上来，所以干脆全变0.
        }
        return right;

    }
}
