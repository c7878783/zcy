package class048;

public class c1ImplPrefixSumMatrix {

    class NumMatrix {

        public static int[][] sum;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            sum = new int[n + 1][m + 1];
            for (int a = 1, c = 0; c < n; a++, c++) {
                for (int b = 1, d = 0; d < m; b++, d++) {
                    sum[a][b] = matrix[c][d];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
                row2++;
                col2++;
                return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
        }

    }


}
