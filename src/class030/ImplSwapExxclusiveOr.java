package class030;

public class ImplSwapExxclusiveOr {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a是：" + a);
        System.out.println("b是：" + b);
    }
}
