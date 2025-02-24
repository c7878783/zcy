package class037;

public class c2ImplLowestCommonAncestorBinarySearch {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            while (root.val != p.val && root.val != q.val){
                if ((Math.min(p.val, q.val) < root.val && root.val < (Math.max(p.val, q.val)))){
                    break;
                }
                root = Math.min(p.val, q.val) < root.val? root.left: root.right;
            }
            return root;
        }
    }

}
