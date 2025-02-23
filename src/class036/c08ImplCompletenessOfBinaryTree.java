package class036;

public class c08ImplCompletenessOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    class Solution {

        public static int MAXN = 101;
        public static TreeNode[] queue = new TreeNode[MAXN];
        public static int l, r;

        public boolean isCompleteTree(TreeNode root) {
            if (root == null){
                return true;
            }
            l = r = 0;
            queue[r++] = root;
            boolean leaf = false;
            while (l < r){
                root = queue[l++];
                if ((root.left == null && root.right != null) || (leaf && (root.left != null || root.right != null))){
                    return false;
                }
                if (root.left != null){
                    queue[r++] = root.left;
                }
                if (root.right != null){
                    queue[r++] = root.right;
                }
                if (root.left == null || root.right == null){
                    leaf = true;
                }
            }
            return true;
        }
    }

}
