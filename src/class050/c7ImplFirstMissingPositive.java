package class050;

public class c7ImplFirstMissingPositive {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int l = 0;
            int r = nums.length;
            while (l < r){
                if (nums[l] == l + 1){
                    l++;
                } else if ( nums[l] < l + 1 || nums[l] > r || nums[nums[l] - 1] == nums[l] ){
                    r--;
                    swap(nums, l, r);
                }else {
                    swap(nums, nums[l] - 1, l);
                }
            }
            return l + 1;
        }
        public static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }



}
