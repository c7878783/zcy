package class032;

import java.util.HashSet;

public class ImplBitset {

    public static class Bitset{

        public int[] Bitset;

        public Bitset(int n){
            Bitset = new int[(n + 32 - 1)  / 32];
        }

        public void add(int num){
            Bitset[num / 32] |= 1 << (num % 32);
        }
        public void remove(int num){
            Bitset[num / 32] &= ~(1 << (num % 32));
        }
        public void reverse(int num){
            Bitset[num / 32] ^= (1 << (num % 32));
        }
        public boolean contains(int num){
            return (Bitset[num / 32] & (1 << (num % 32))) != 0;//这样做好像也没什么问题，都是让1和num所在那一位判断。
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        // 实现的位图结构
        Bitset bitSet = new Bitset(n);
        // 直接用HashSet做对比测试
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("调用阶段开始");
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            // number -> 0 ~ n-1，等概率得到
            int number = (int) (Math.random() * n);
            if (decide < 0.333) {
                bitSet.add(number);
                hashSet.add(number);
            } else if (decide < 0.666) {
                bitSet.remove(number);
                hashSet.remove(number);
            } else {
                bitSet.reverse(number);
                if (hashSet.contains(number)) {
                    hashSet.remove(number);
                } else {
                    hashSet.add(number);
                }
            }
        }
        System.out.println("调用阶段结束");
        System.out.println("验证阶段开始");
        for (int i = 0; i < n; i++) {
            if (bitSet.contains(i) != hashSet.contains(i)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("验证阶段结束");
        System.out.println("测试结束");
    }

}
