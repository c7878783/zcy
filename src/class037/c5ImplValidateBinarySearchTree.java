package class037;

public class c5ImplValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    class Solution {
        public static long min;
        public static long max;
        public boolean isValidBST(TreeNode root) {
            if (root == null){
                min = Long.MAX_VALUE;
                max = Long.MIN_VALUE;
                return true;
            }
            boolean lok = isValidBST(root.left);
            long lmin = min;
            long lmax = max;
            boolean rok = isValidBST(root.right);
            long rmin = min;
            long rmax = max;
            min = Math.min(Math.min(lmin, rmin), root.val);//表示我这棵树的最大和最小，至于用我的最大还是最小去比，取决于上面的头认为我是左子树还是右子树
            max = Math.max(Math.max(lmax, rmax), root.val);
            return lok && rok && lmax < root.val && root.val < rmin;
        }



        public static int MAXN = 10001;
        public static TreeNode[] stack = new TreeNode[MAXN];
        public int r;

        public static boolean isValidBST2(TreeNode root) {
            if (root == null){
                return true;
            }
            TreeNode pre = null;
            int r = 0;
            while (r > 0 || root != null){
                if (root != null){
                    stack[r++] = root;
                    root = root.left;
                }else {
                    root = stack[--r];
                    if (pre != null && pre.val >= root.val){
                        return false;
                    }
                    pre = root;
                    root = root.right;
                }
            }

            return true;
        }


    }
}
