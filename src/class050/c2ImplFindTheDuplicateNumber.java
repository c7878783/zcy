package class050;

public class c2ImplFindTheDuplicateNumber {


    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length < 2){
                return -1;
            }
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
