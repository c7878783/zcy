package class037;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class c3ImplPathSumII {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null){
                List<Integer> path = new ArrayList<>();
                f(ans, path, root, 0, targetSum);
            }
            return ans;
        }

        public static void f(List<List<Integer>> ans, List<Integer> path, TreeNode cur, int sum, int aim){

            if (cur.left == null && cur.right == null){
                if ((cur.val + sum) == aim){
                    path.add(cur.val);
                    copu(ans, path);
                    path.remove(path.size() - 1);
                }
            }else {
                path.add(cur.val);
                if (cur.left != null){
                    f(ans, path, cur.left, sum + cur.val, aim);
                }
                if (cur.right != null){
                    f(ans, path, cur.right, sum + cur.val, aim);
                }
                path.remove(path.size() - 1);
            }

        }

        public static void copu(List<List<Integer>> ans, List<Integer> path){
            List<Integer> copy = new ArrayList<>();
            for (Integer i : path) {
                copy.add(i);
            }
            ans.add(copy);
        }
    }

}
