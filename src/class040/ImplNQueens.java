package class040;

import com.sun.source.tree.BreakTree;

public class ImplNQueens {


    class Solution {
        public int totalNQueens(int n) {
            if (n < 1){
                return 0;
            }
            int limit = (1 << n) - 1;
            return f(limit, 0, 0, 0);
        }
        public static int f(int limit, int col, int left, int right){
            if (col == limit){
                return 1;
            }
            int ban = col | left | right;
            int candidate = limit & (~ban);
            int place = 0;
            int ans = 0;
            while (candidate != 0){
                place = candidate & (-candidate);
                candidate ^= place;
                ans += f(limit, col | place, (left | place) >> 1, (right | place) << 1);
            }
            return ans;
        }
    }
}
