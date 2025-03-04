package class048;

public class c2ImplLarestOneBorderedSquare {

    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            build(n, m, grid);
            if (sum(grid, 0, 0, n - 1, m - 1) == 0){
                return 0;
            }
            int ans = 1;
            for (int a = 0; a < n; a++){
                for (int b = 0; b < m; b++){

                    for (int c = a + ans, d = b + ans, k = ans + 1; c < n && d < m;c++, d++, k++){//给中间挖掉
                        if (sum(grid, a, b, c, d) - sum(grid, a + 1, b + 1, c - 1, d - 1) == (k - 1) << 2){
                            ans = k;
                        }
                    }
                }
            }
            return ans * ans;
        }


        public static void build(int n, int m, int[][] g){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++) {
                    g[i][j] += get(g, i - 1, j) + get(g, i, j - 1) - get(g, i - 1, j - 1);
                }
            }
        }
        public static int sum(int[][] g, int a, int b, int c, int d){
            return a > c? 0 : (get(g, c, d) - get(g, c, b - 1) - get(g, a - 1, d) + get(g, a - 1, b - 1));
        }
        public static int get(int[][] g, int i, int j){
            return (i < 0 || j < 0)? 0 : g[i][j];
        }
    }
}
