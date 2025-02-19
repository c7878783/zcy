package class030;

public class ImplGetMaxWithoutJudge {

    public static int flip(int n){
        return n ^ 1;
    }

    public static int sign(int n){
        return flip(n >>> 31);
    }

    public static int getMax(int a, int b){
        int c = a - b;
        int returnA = sign(c);
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static int getMax2(int a, int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int differAB = sa ^ sb;
        int sameAB = flip(differAB);
        int returnA = differAB * sa + sameAB * sc;
        int returnB = flip(returnA);

        return a * returnA + b * returnB;


    }
}
