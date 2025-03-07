package class051;

public class c5ImplMaximumRunningTimeOfNcomputers {

    class Solution {
        public long maxRunTime(int n, int[] batteries) {
            long sum = 0;
            for (int battery : batteries) {
                sum += battery;
            }
            long ans = 0;
            for (long l = 0, r = sum, m; l <= r;){
                m = l + ((r - l) >> 1);
                if (f(n, batteries, m)){
                    ans = m;
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            return ans;
        }

        public static boolean f(int n, int[] batteries, long time){
            long sum = 0;
            for (int battery : batteries) {
                if (battery > time){
                    n--;
                }else {
                    sum += battery;
                }
                if (sum >= (long) n * time){
                    return true;
                }
            }
            return false;
        }
    }


}
