package class047;

public class c1ImplCorporateFilghtBookings {

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] cnt = new int[n + 2];
            for (int[] booking : bookings) {
                cnt[booking[0]] += booking[2];
                cnt[booking[1] + 1] -= booking[2];
            }

            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i - 1];
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = cnt[i + 1];
            }
            return ans;
        }
    }

}
