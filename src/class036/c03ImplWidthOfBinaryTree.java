package class036;

public class c03ImplWidthOfBinaryTree {

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
        private static int MAXN = 3001;
        public static TreeNode[] nodeQueue = new TreeNode[MAXN];
        public static int[] indexQueue = new int[MAXN];//存储节点在树中的位置索引，按照杨辉三角来
        public static int l, r;

        public int widthOfBinaryTree(TreeNode root) {
            int ans = 1;
            l = r = 0;
            nodeQueue[r] = root;
            indexQueue[r++] = 1;
            while (l < r){
                int size = r - l;
                ans = Math.max(ans, indexQueue[r - 1] - indexQueue[l] + 1);
                for (int i = 0; i < size; i++){
                    TreeNode cur = nodeQueue[l];
                    int id = indexQueue[l++];
                    if (cur.left != null){
                        nodeQueue[r] = cur.left;
                        indexQueue[r++] = 2 * id;
                    }
                    if (cur.right != null){
                        nodeQueue[r] = cur.right;
                        indexQueue[r++] = 2 * id + 1;
                    }
                }
            }
            return ans;
        }
    }

}
