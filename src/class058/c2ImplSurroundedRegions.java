package class058;

public class c2ImplSurroundedRegions {

    class Solution {
        public void solve(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            for (int i = 0; i < m; i++) {
                if (board[0][i] == 'O'){
                    dfs(board, n, m, 0, i);
                }
                if (board[n - 1][i] == 'O'){
                    dfs(board, n, m, n - 1, i);
                }
            }
            for (int i = 1; i < n - 1; i++) {
                if (board[i][0] == 'O'){
                    dfs(board, n, m, i, 0);
                }
                if (board[i][m - 1] == 'O'){
                    dfs(board, n, m, i, m - 1);

                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == 'F'){
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public static void dfs(char[][] board, int n, int m, int i, int j){
            if (i < 0 || j < 0 || i == n || j == m || board[i][j] != 'O'){
                return;
            }
            board[i][j] = 'F';
            dfs(board, n, m, i - 1, j);
            dfs(board, n, m, i + 1, j);
            dfs(board, n, m, i, j - 1);
            dfs(board, n, m, i, j + 1);
        }
    }
}
