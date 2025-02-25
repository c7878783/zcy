package class038;

public class c7ImplTowerOfhanoi {


    public static void f(int i, String from, String to, String other){
        if (i == 1){
            System.out.println("移动圆盘 1 从 " + from + " 到 " + to);//from是当前位置，to是期望位置，other是另一个位置
        }else {
            f(i - 1, from, other, to);
            System.out.println("移动圆盘 " + i + " 从 " + from + " 到 " + to);
            f(i - 1, other, to, from);
        }
    }

    public static void hanoi(int n) {
        if (n > 0) {
            f(n, "左", "右", "中");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
