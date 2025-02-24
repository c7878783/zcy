package class037;

// 验证搜索二叉树
// 测试链接 : https://leetcode.cn/problems/validate-binary-search-tree/
public class Code05_ValidateBinarySearchTree {

	// 不提交这个类
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 提交以下的方法
	public static int MAXN = 10001;

	public static TreeNode[] stack = new TreeNode[MAXN];

	public static int r;

	// 提交时改名为isValidBST
	public static boolean isValidBST1(TreeNode head) {//中序遍历栈方法，要求每次从栈中pop的值要大于上一个
		if (head == null) {
			return true;
		}
		TreeNode pre = null;
		r = 0;
		while (r > 0 || head != null) {
			if (head != null) {
				stack[r++] = head;//中序遍历，先朝着左边把所有的节点搜集到最后一个，然后在叶子节点弹出
				head = head.left;
			} else {
				head = stack[--r];
				if (pre != null && pre.val >= head.val) {//可以先不看这个，这个就是代替了中序的显示
					return false;//回来再看这句就是在说，当中序有弹出的时候，pre不是null，同时需要保证递增
				}
				pre = head;//pre这个是用来存住一个结点的左节点，这个左节点是作为中序节点弹出的，只要保证中序节点弹出依次递增就可以保证二叉搜索树
				head = head.right;//在最左叶子节点为heda的时候，这个.right也是空的，然而这是由于head空，我们需要再取从stack中取值，取出来的就是最左叶子的根了
			}//至于右边的处理问题，把右边单独的想象成独立地子树就很好理解了
		}
		return true;
	}

	public static long min, max;

	// 提交时改名为isValidBST
	public static boolean isValidBST2(TreeNode head) {//左右递归法
		if (head == null) {
			min = Long.MAX_VALUE;
			max = Long.MIN_VALUE;
			return true;
		}
		boolean lok = isValidBST2(head.left);
		long lmin = min;
		long lmax = max;
		boolean rok = isValidBST2(head.right);
		long rmin = min;
		long rmax = max;
		min = Math.min(Math.min(lmin, rmin), head.val);
		max = Math.max(Math.max(lmax, rmax), head.val);
		return lok && rok && lmax < head.val && head.val < rmin;
	}

}
