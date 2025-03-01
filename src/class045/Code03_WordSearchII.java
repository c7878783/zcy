package class045;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 同一个单元格内的字母在一个单词中不允许被重复使用。
// 在二维字符数组中搜索可能的单词
// 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words
// 返回所有二维网格上的单词。单词必须按照字母顺序，通过 相邻的单元格 内的字母构成
// 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
// 同一个单元格内的字母在一个单词中不允许被重复使用
// 1 <= m, n <= 12
// 1 <= words.length <= 3 * 10^4
// 1 <= words[i].length <= 10
// 测试链接 : https://leetcode.cn/problems/word-search-ii/
public class Code03_WordSearchII {

	public static List<String> findWords(char[][] board, String[] words) {
		build(words);
		List<String> ans = new ArrayList<>();//注意单个单词不要重复，多个单词用同一个表字符没关系
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, 1, ans);
			}
		}
		clear();
		return ans;
	}

	// board : 二维网格
	// i,j : 此时来到的格子位置，i行、j列
	// t : 前缀树的编号（从1号节点开始，向下寻找26条路径）
	// List<String> ans : 收集到了哪些字符串，都放入ans
	// 返回值 : 收集到了几个字符串
	public static int dfs(char[][] board, int i, int j, int t, List<String> ans) {
		// 越界 或者 走了回头路，直接返回0
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 0) {
			return 0;
		}
		// 不越界 且 不是回头路
		// 用tmp记录当前字符
		char tmp = board[i][j];
		// 路的编号
		// a -> 0
		// b -> 1
		// ...
		// z -> 25
		int road = tmp - 'a';
		t = tree[t][road];
//		if (t == 0 || pass[t] == 0) {
		if (pass[t] == 0) {
			return 0;//说明这一路已经被提取完了，没有必要搜了（或者是这个字符的下面的road就没有单词，没必要搜了，跟上面那句是一个效果，t=0就是所谓的从来没有过节点）
		}
		// i，j位置有必要来
		// fix ：从当前i，j位置出发，一共收集到了几个字符串
		int fix = 0;
		if (end[t] != null) {//搜到一个（这个）单词了
			fix++;
			ans.add(end[t]);
			end[t] = null;
		}
		// 把i，j位置的字符，改成0，后续的过程，是不可以再来到i，j位置的！
		board[i][j] = 0;//这个字符我取走了，后续不要绕回来
		fix += dfs(board, i - 1, j, t, ans);//向其他四个方向搜索
		fix += dfs(board, i + 1, j, t, ans);
		fix += dfs(board, i, j - 1, t, ans);
		fix += dfs(board, i, j + 1, t, ans);
		pass[t] -= fix;//我顺着这个节点提取了多少个单词出来，树上已经没有和这个节点字符相关的单词了
		board[i][j] = tmp;//取走的塞回去
		return fix;
	}

	public static int MAXN = 10001;

	public static int[][] tree = new int[MAXN][26];

	public static int[] pass = new int[MAXN];

	public static String[] end = new String[MAXN];

	public static int cnt;

	public static void build(String[] words) {
		cnt = 1;
		for (String word : words) {
			int cur = 1;
			pass[cur]++;
			for (int i = 0, path; i < word.length(); i++) {
				path = word.charAt(i) - 'a';
				if (tree[cur][path] == 0) {
					tree[cur][path] = ++cnt;
				}
				cur = tree[cur][path];
				pass[cur]++;
			}
			end[cur] = word;
		}
	}

	public static void clear() {
		for (int i = 1; i <= cnt; i++) {
			Arrays.fill(tree[i], 0);
			pass[i] = 0;
			end[i] = null;
		}
	}

}