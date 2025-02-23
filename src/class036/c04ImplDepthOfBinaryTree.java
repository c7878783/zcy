package class036;

public class c04ImplDepthOfBinaryTree {

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

        public int maxDepth(TreeNode root) {
            return root == null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        public int minDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null){
                return 1;
            }
            int ldeep = Integer.MAX_VALUE;
            int rdeep = Integer.MAX_VALUE;
            if (root.left != null){
                ldeep = minDepth(root.left);
            }
            if (root.right != null){
                rdeep = minDepth(root.right);
            }

            return Math.min(ldeep, rdeep) + 1;
        }
    }

}
