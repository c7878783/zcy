package class040;

// N皇后问题
// 测试链接 : https://leetcode.cn/problems/n-queens-ii/
public class NQueens {

	// 用数组表示路径实现的N皇后问题，不推荐
	public static int totalNQueens1(int n) {
		if (n < 1) {
			return 0;
		}
		return f1(0, new int[n], n);
	}

	// i : 当前来到的行
	// path : 0...i-1行的皇后，都摆在了哪些列
	// n : 是几皇后问题
	// 返回 : 0...i-1行已经摆完了，i....n-1行可以去尝试的情况下还能找到几种有效的方法
	public static int f1(int i, int[] path, int n) {
		if (i == n) {
			return 1;//在递归函数 f1(i, path, n) 中，当 i == n 时，表示我们已经尝试完了从行 0 到行 n-1 的所有皇后放置，而且每一行的放置都没有发生冲突。此时，我们已经找到了一个有效的解决方案。
		}
		int ans = 0;
		// 0 1 2 3 .. n-1
		// i j
		for (int j = 0; j < n; j++) {
			if (check(path, i, j)) {
				path[i] = j;
				ans += f1(i + 1, path, n);//每一种有效的，我都加一下
			}
		}
		return ans;
	}

	// 当前在i行、j列的位置，摆了一个皇后
	// 0...i-1行的皇后状况，path[0...i-1]
	// 返回会不会冲突，不会冲突，有效！true
	// 会冲突，无效，返回false
	public static boolean check(int[] path, int i, int j) {
		// 当前 i
		// 当列 j
		for (int k = 0; k < i; k++) {
			// 0...i-1
			// 之前行 : k
			// 之前列 : path[k]
			//j表示当前尝试的列，首先当前列不能和以前的列撞，其次跟之前的每一个行列差值不能相等，相等表示占据了对角线
			if (j == path[k] || Math.abs(i - k) == Math.abs(j - path[k])) {
				return false;
			}
		}
		return true;
	}

	// 用位信息表示路径实现的N皇后问题，推荐
	public static int totalNQueens2(int n) {
		if (n < 1) {
			return 0;
		}
		// n = 5
		// 1 << 5 = 0...100000 - 1
		// limit  = 0...011111; 
		// n = 7
		// limit  = 0...01111111; 
		int limit = (1 << n) - 1;//表示需要占据五个位置
		return f2(limit, 0, 0, 0);
	}

	// limit : 当前是几皇后问题
	// 之前皇后的列影响：col
	// 之前皇后的右上 -> 左下对角线影响：left
	// 之前皇后的左上 -> 右下对角线影响：right
	public static int f2(int limit, int col, int left, int right) {
		if (col == limit) {
			// 所有皇后放完了！（5个正好）
			return 1;
		}
		// 总限制
		int ban = col | left | right;//这一行的这些位置不允许放置皇后（1表示其他皇后的限制，0表示其他皇后没有限制此处）
		// ~ban : 1可放皇后，0不能放
		int candidate = limit & (~ban);//与一下是因为可能会长一些，递归中有位移操作，能放的位置可能会超出规定棋盘长度
		// 放置皇后的尝试！
		int place = 0;
		// 一共有多少有效的方法
		int ans = 0;
		while (candidate != 0) {
			// 提取出最右侧的1
			// 0 0 1 1 1 0
			// 5 4 3 2 1 0
			// place : 
			// 0 0 0 0 1 0
			// candidate : 
			// 0 0 1 1 0 0
			// 5 4 3 2 1 0
			// place : 
			// 0 0 0 1 0 0
			// candidate : 
			// 0 0 1 0 0 0
			// 5 4 3 2 1 0
			// place : 
			// 0 0 1 0 0 0
			// candidate : 
			// 0 0 0 0 0 0
			// 5 4 3 2 1 0
			place = candidate & (-candidate);
			candidate ^= place;//表示我已经用了这一行可以放置的位置了
			//右移两位，表示左下，左移两位，表示右下
			//col | place表示当前的列是否和上面已用过的列重合
			ans += f2(limit, col | place, (left | place) >> 1, (right | place) << 1);
		}//递归走不到最后是无法返回1的，当向下走到一行不成功时，由于递归开头有判断条件，于是会向下走，导致ban是满的，也就是candidate为0然后退出
		return ans;
	}

	public static void main(String[] args) {
		int n = 14;
		long start, end;
		System.out.println("测试开始");
		System.out.println("解决" + n + "皇后问题");
		start = System.currentTimeMillis();
		System.out.println("方法1答案 : " + totalNQueens1(n));
		end = System.currentTimeMillis();
		System.out.println("方法1运行时间 : " + (end - start) + " 毫秒");

		start = System.currentTimeMillis();
		System.out.println("方法2答案 : " + totalNQueens2(n));
		end = System.currentTimeMillis();
		System.out.println("方法2运行时间 : " + (end - start) + " 毫秒");
		System.out.println("测试结束");

		System.out.println("=======");
		System.out.println("只有位运算的版本，才能10秒内跑完16皇后问题的求解过程");
		start = System.currentTimeMillis();
		int ans = totalNQueens2(16);
		end = System.currentTimeMillis();
		System.out.println("16皇后问题的答案 : " + ans);
		System.out.println("运行时间 : " + (end - start) + " 毫秒");
	}

}
