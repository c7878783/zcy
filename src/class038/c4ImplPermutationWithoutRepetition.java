package class038;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class c4ImplPermutationWithoutRepetition {

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            f(ans, nums, 0);
            return ans;
        }

        public void f(List<List<Integer>> ans, int[] nums, int i){
            if (i == nums.length){
                ArrayList<Integer> cur = new ArrayList<>();
                for (int num : nums) {
                    cur.add(num);
                }
                ans.add(cur);
            }else {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i; j < nums.length; j++){
                    if (!set.contains(nums[j])){
                        set.add(nums[j]);
                        swap(nums, i, j);
                        f(ans, nums, i + 1);
                        swap(nums, i, j);
                    }
                }
            }
        }


        public static void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
