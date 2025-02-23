package class036;

import java.util.ArrayList;
import java.util.List;

public class c02ImplZigzagLevelOrderTraversal {


    class Solution {

        public class TreeNode {
            int val;
            Solution.TreeNode left;
            Solution.TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, Solution.TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public static int MAXN = 2001;
        public static TreeNode[] queue = new TreeNode[MAXN];
        public static int l, r;

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null){
                l = r = 0;
                queue[r++] = root;
                boolean reverse = false;
                while (l < r){
                    int size = r - l;
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = reverse? r - 1 : l, j = reverse? -1 : 1, k = 0; k < size; i += j, k++){
                        list.add(queue[i].val);
                    }
                    for (int i = 0; i < size; i ++){
                        TreeNode cur = queue[l++];
                        if (cur.left != null){
                            queue[r++] = cur.left;
                        }
                        if (cur.right != null){
                            queue[r++] = cur.right;
                        }
                    }
                    ans.add(list);
                    reverse = !reverse;
                }
            }
            return ans;
        }
    }

}
