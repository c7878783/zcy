package class056;

public class c5ImplNumberOfIslands {

    class Solution {
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            build(n, m, grid);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1'){
                        if (i > 0 && grid[i - 1][j] == '1'){
                            union(i, j, i - 1, j);
                        }
                        if (j > 0 && grid[i][j - 1] == '1'){
                            union(i, j, i, j - 1);
                        }
                    }
                }
            }
            return sets;
        }


        public static int MAXSIZE = 90001;
        public static int[] father = new int[MAXSIZE];
        public static int cols;
        public static int sets;

        public static void build(int n, int m, char[][] board){
            cols = m;
            sets = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == '1'){
                        father[index(i, j)] = index(i, j);
                        sets++;
                    }
                }
            }
        }

        public static int index(int n, int m){
            return n * cols + m;
        }

        public static int find(int x){
            if (x != father[x]){
                x = find(father[x]);
            }
            return x;
        }

        public static void union(int a, int b, int c, int d){
            int fx = find(index(a, b));
            int fy = find(index(c, d));
            if (fx != fy){
                father[fx] = fy;
                sets--;
            }
        }
    }

}
