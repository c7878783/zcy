package class036;

import com.sun.source.tree.Tree;

public class c09ImplCountCompleteTreeNodes {


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

    public static int countNodes(TreeNode head){
        if (head == null){
            return 0;
        }
        return f(head, 1, mostLeft(head, 1));
    }

    public static int f(TreeNode cur, int level, int h){
        if (level == h){
            return 1;
        }
        if (mostLeft(cur.right, level + 1) == h){
            return (1 << (h - level)) + f(cur.right, level + 1, h);
        }else {
            return (1 << (h - level - 1)) + f(cur.left, level + 1, h);
        }
    }

    public static int mostLeft(TreeNode node, int level){
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }


}
