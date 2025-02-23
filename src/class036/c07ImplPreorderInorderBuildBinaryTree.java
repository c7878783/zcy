package class036;

import java.util.HashMap;

public class c07ImplPreorderInorderBuildBinaryTree {

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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length) return null;

            HashMap<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i <inorder.length; i++){
                inMap.put(inorder[i], i);
            }
            return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length, inMap);
        }
        public TreeNode f(int[] pre, int lpre, int rpre, int[] in, int lin, int rin, HashMap<Integer, Integer> inMap){
                if (lpre > rpre){
                    return null;
                }
                TreeNode head = new TreeNode(pre[lpre]);
                if (lpre == rpre){
                    return head;
                }
            Integer k = inMap.get(pre[lpre]);//先序的头一个，中序的中点
            head.left = f(pre, lpre + 1, lpre + k - lin, in, lin, k - 1, inMap);
            head.right = f(pre, lpre + k - lin + 1, rpre, in, k + 1, rin, inMap);
            return head;
        }
    }
}
