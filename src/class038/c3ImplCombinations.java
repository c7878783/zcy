package class038;

import class009.ListReverse;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class c3ImplCombinations {


    class Solution {



        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            f(nums, 0, ans);
            return ans;
        }

        public static void f(int[] nums, int i, List<List<Integer>> ans){
            if (i == nums.length){
                List<Integer> cur = new ArrayList<>();
                for (int num : nums) {
                    cur.add(num);
                }
                ans.add(cur);
            }else {
                for (int j = i; j < nums.length; j++){
                    swap(nums, i, j);
                    f(nums, i + 1, ans);
                    swap(nums, i, j);
                }

            }

        }
        public static void swap(int[] arr, int i, int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
