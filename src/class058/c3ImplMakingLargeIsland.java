package class058;

public class c3ImplMakingLargeIsland {

    class Solution {
        public int largestIsland(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int id = 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != 0){
                        dfs(grid, n, m, i, j, id++);
                    }
                }
            }
            int[] sizes = new int[id];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > 1){
                        ans = Math.max(ans, ++sizes[grid[i][j]]);
                    }
                }
            }

            boolean[] visit = new boolean[id];
            int up, left, down, right, merge;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0){
                        up = i > 0? grid[i - 1][j] : 0;
                        down = i + 1 < n? grid[i + 1][j] : 0;
                        left = j > 0? grid[i][j - 1] : 0;
                        right = j + 1 < m? grid[i][j + 1] : 0;
                        visit[up] = true;
                        merge = 1 + sizes[up];
                        if (!visit[down]){
                            merge += sizes[down];
                            visit[down] = true;
                        }
                        if (!visit[left]){
                            merge += sizes[left];
                            visit[left] = true;
                        }
                        if (!visit[right]){
                            merge += sizes[right];
                            visit[right] = true;
                        }
                        ans = Math.max(ans, merge);
                        visit[up] = false;
                        visit[down] = false;
                        visit[left] = false;
                        visit[right] = false;
                    }
                }
            }
            return ans;
        }

        public static void dfs(int[][] grid, int n, int m, int i, int j, int id){
            if (i < 0 || j < 0 || i == n || j == m || grid[i][j] != 1){
                return;
            }
            grid[i][j] = id;
            dfs(grid, n, m, i - 1, j, id);
            dfs(grid, n, m, i + 1, j, id);
            dfs(grid, n, m, i, j - 1, id);
            dfs(grid, n, m, i, j + 1, id);
        }
    }
}
