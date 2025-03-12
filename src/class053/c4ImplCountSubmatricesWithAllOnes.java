package class053;

import java.util.Arrays;

public class c4ImplCountSubmatricesWithAllOnes {

    class Solution {

        public static int MAXN = 151;
        public static int[] height = new int[MAXN];
        public static int[] stack = new int[MAXN];
        public static int r;

        public int numSubmat(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            int ans = 0;
            Arrays.fill(height, 0, m, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    height[j] = mat[i][j] == 0? 0 : height[j] + 1;
                }
                ans += countFromBottom(m);
            }
            return ans;
        }

        public int countFromBottom(int m){
            r = 0;
            int ans = 0;
            for (int i = 0, left, len, bottom; i < m; i++){
                while (r > 0 && height[stack[r - 1]] >= height[i]){
                    int cur = stack[--r];
                    if (height[cur] > height[i]){
                        left = r == 0? -1 : stack[r - 1];//这类题很容易出现没分清索引和具体值的错误
                        len = i - left - 1;
                        bottom = Math.max(left == -1? 0 : height[left], height[i]);
                        ans += (height[cur] - bottom) * (len * (len + 1) / 2);
                    }
                }
                stack[r++] = i;
            }

            while (r > 0){
                int cur = stack[--r];
                int left = r == 0? -1 : stack[r - 1];
                int len = m - left - 1;
                int bottom = left == -1? 0 : height[left];
                ans += (height[cur] - bottom) * len * (len + 1) / 2;
            }
            return ans;
        }
    }
}
