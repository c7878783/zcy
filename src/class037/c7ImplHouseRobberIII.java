package class037;

public class c7ImplHouseRobberIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    class Solution {
        public int rob(TreeNode root) {
            f(root);
            return Math.max(yes, no);
        }

        public static int yes, no;

        public static void f(TreeNode root) {
            if (root == null){
                yes = 0;
                no = 0;
                return;
            }
            int y = root.val;
            int n = 0;
            f(root.left);
            y += no;
            n += Math.max(yes, no);
            f(root.right);
            y += no;
            n += Math.max(yes, no);
            yes = y;
            no = n;
        }
    }

}
