package class031;

public class ImplNear2Power {

    public static int near2Power(int n){
        if (n <=0 ){
            return n;
        }
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n + 1;
    }

}

