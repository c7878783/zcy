package class050;

public class c1ImplSortArrayByParityII {

    class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int n = nums.length;
            for (int odd = 1, even = 0; odd < n && even < n;){
                if ((nums[n - 1] & 1) == 1){
                    swap(nums, odd, n - 1);
                    odd += 2;
                }else {
                    swap(nums, even, n - 1);
                    even += 2;
                }
            }
            return nums;
        }

        public static void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
