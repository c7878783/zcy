package class038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c2ImplCombinations {


    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            f(ans, nums, new int[nums.length], 0, 0);
            return ans;
        }

        public static void f(List<List<Integer>> ans, int[] nums, int[] path, int i, int size){
            if (i == nums.length){
                List<Integer> cur = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    cur.add(path[j]);
                }
                ans.add(cur);
            }else {
                int j = i + 1;
                while (j < nums.length && nums[i] == nums[j]){
                    j++;
                }
                f(ans, nums, path, j, size);
                for (; i < j; i++){
                    path[size++] = nums[i];
                    f(ans, nums, path, j, size);

                }
            }
        }
    }

}
