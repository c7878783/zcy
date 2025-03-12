package class053;

// 最大宽度坡
// 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]
// 这样的坡的宽度为 j - i，找出 A 中的坡的最大宽度，如果不存在，返回 0
// 测试链接 : https://leetcode.cn/problems/maximum-width-ramp/
public class Code01_MaximumWidthRamp {

	public static int MAXN = 50001;

	public static int[] stack = new int[MAXN];

	public static int r;

	public static int maxWidthRamp(int[] arr) {
		// 令r=1相当于0位置进栈了
		// stack[0] = 0，然后栈的大小变成1
		r = 1;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[stack[r - 1]] > arr[i]) {//比栈顶小，就往里放，下降坡
				stack[r++] = i;//栈在维护最大宽度有哪些可能性，可能有哪些位置参与了
			}
		}
		int ans = 0;
		for (int j = n - 1; j >= 0; j--) {//右侧边界是在减小的，所以左侧应该越往左越好也就是弹出越多越好
			while (r > 0 && arr[stack[r - 1]] <= arr[j]) {
				ans = Math.max(ans, j - stack[--r]);
			}
		}
		return ans;
	}

}
