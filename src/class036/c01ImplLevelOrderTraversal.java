package class036;

import java.util.ArrayList;
import java.util.List;

public class c01ImplLevelOrderTraversal {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */


    class Solution {

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

        public static int MAXN = 2001;
        public static TreeNode[] queue = new TreeNode[MAXN];
        public static int l, r;

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null){
                l = r = 0;
                queue[r++] = root;
                while (l < r){
                    int size = r - l;
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < size; i++){
                        TreeNode cur = queue[l++];
                        list.add(cur.val);
                        if (cur.left != null){
                            queue[r++] = cur.left;
                        }
                        if (cur.right != null){
                            queue[r++] = cur.right;
                        }
                    }
                    ans.add(list);
                }

            }
            return ans;
        }
    }

}
