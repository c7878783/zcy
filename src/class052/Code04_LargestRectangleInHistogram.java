package class052;

// 柱状图中最大的矩形
// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度
// 每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积
// 测试链接：https://leetcode.cn/problems/largest-rectangle-in-histogram
public class Code04_LargestRectangleInHistogram {

	public static int MAXN = 100001;

	public static int[] stack = new int[MAXN];

	public static int r;

	public static int largestRectangleArea(int[] height) {
		int n = height.length;
		r = 0;
		int ans = 0, cur, left;
		for (int i = 0; i < n; i++) {
			// i -> arr[i]
			// stack存的值比现在遍历到的大，那这个cur高度画矩形只能画到遍历到的这个位置，和他stack中压的下一个，
			// 就这段距离，是这个高度可以处理的，其他的就比他矮了
			while (r > 0 && height[stack[r - 1]] >= height[i]) {
				cur = stack[--r];
				left = r == 0 ? -1 : stack[r - 1];
				// 假设现在位置是8，7是left，9是i，那只能画出8这一个部分
				ans = Math.max(ans, height[cur] * (i - left - 1));
			}
			stack[r++] = i;
		}
		while (r > 0) {
			cur = stack[--r];
			left = r == 0 ? -1 : stack[r - 1];
			ans = Math.max(ans, height[cur] * (n - left - 1));
		}
		return ans;
	}

}
