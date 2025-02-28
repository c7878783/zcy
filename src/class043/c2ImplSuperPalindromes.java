package class043;

public class c2ImplSuperPalindromes {


    class Solution {
        public int superpalindromesInRange(String left, String right) {
            long l = Long.valueOf(left);
            long r = Long.valueOf(right);
            long limit = (long) Math.sqrt((double) r);
            long seed = 1;
            long num = 0;
            int ans = 0;
            do{
                num = evenEnlarge(seed);
                if (check(num * num, l, r)){
                    ans++;
                }
                num = oodEnlarge(seed);
                if (check(num * num, l, r)){
                    ans++;
                }
                seed++;
            }while (num < limit);
            return ans;
        }

        public static long evenEnlarge(long seed){
            long ans = seed;
            while (seed != 0){//当所有的位都处理了，跳出循环
                ans = ans * 10 + seed % 10;
                seed /= 10;
            }
            return ans;
        }

        public static long oodEnlarge(long seed){
            long ans = seed;
            seed /= 10;
            while (seed != 0){//当所有的位都处理了，跳出循环
                ans = ans * 10 + seed % 10;
                seed /= 10;
            }
            return ans;
        }

        public static boolean check(long ans, long l, long r){
            return ans >= l && ans <= r && isPalindrome(ans);
        }

        public static boolean isPalindrome(long x) {
            if (x < 0){
                return false;
            }
            long offset = 1;
            while (x / offset >= 10){
                offset *= 10;
            }
            while (x != 0){
                if (x / offset != x % 10){
                    return false;
                }
                x = (x % offset) / 10;
                offset /= 100;
            }
            return true;
        }
    }

}
