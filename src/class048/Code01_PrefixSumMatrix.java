package class048;

// 利用二维前缀和信息迅速得到二维区域和
// 测试链接 : https://leetcode.cn/problems/range-sum-query-2d-immutable/
public class Code01_PrefixSumMatrix {

	class NumMatrix {

		public int[][] sum;

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
					sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
				}
			}
		}
		//首先原始图的a,b,c,d对应的应该是sum图的每个地方+1，但是由于在计算公式中a,b 两处需要+1再-1，所以直接用原始数值
		public int sumRegion(int a, int b, int c, int d) {
			c++;
			d++;
			return sum[c][d] - sum[c][b] - sum[a][d] + sum[a][b];
		}

	}

}
