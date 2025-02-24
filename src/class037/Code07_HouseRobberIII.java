package class037;

// 二叉树打家劫舍问题
// 测试链接 : https://leetcode.cn/problems/house-robber-iii/
public class Code07_HouseRobberIII {

	// 不提交这个类
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 提交如下的方法
	public static int rob(TreeNode root) {
		f(root);
		return Math.max(yes, no);
	}

	// 全局变量，完成了X子树的遍历，返回之后
	// yes变成，X子树在偷头节点的情况下，最大的收益
	public static int yes;

	// 全局变量，完成了X子树的遍历，返回之后
	// no变成，X子树在不偷头节点的情况下，最大的收益
	public static int no;

	public static void f(TreeNode root) {
		if (root == null) {
			yes = 0;
			no = 0;
		} else {
			int y = root.val;
			int n = 0;
			f(root.left);
			y += no;//y是当前节点自身的数值，这一句就是我偷了当前的节点
			n += Math.max(yes, no);//这里没有加Y而是进一步向下去偷
			f(root.right);
			y += no;
			n += Math.max(yes, no);
			yes = y;//这是为了告诉上面，你取我这个节点的值能拿到多少，no变量则是，你不取我能拿到多少。
			no = n;
		}
	}

}
