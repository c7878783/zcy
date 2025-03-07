package class051;

public class c1ImplKokoEatingBananas {

    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1;
            int r = 0;
            for (int pile : piles) {
                r = Math.max(r, pile);
            }

            int ans = 0;
            int m = 0;
            while (l <= r){
                m = l + ((r - l) >> 1);
                if (f(piles, m) <= h){//当满足条件，可以在hours内达成，就记录，然后去找更好的
                    ans = m;
                    r = m - 1;
                }else {
                    l = m + 1;
                }
            }
            return ans;
        }

        public static long f(int[] piles, int speed){
            long ans = 0;
            for (int pile : piles) {
                ans += (pile + speed - 1) / speed;
            }
            return ans;
        }
    }
}
