package class037;

public class c4ImplBalanceBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    class Solution {

        public static boolean balance;

        public boolean isBalanced(TreeNode root) {
            balance = true;
            height(root);
            return balance;
        }

        public static int height(TreeNode root) {
            if (!balance || root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            if (Math.abs(lh - rh) > 1){
                balance = false;
            }
            return Math.max(lh, rh) + 1;
        }
    }

}
