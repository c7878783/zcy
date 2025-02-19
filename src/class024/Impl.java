package class024;


class Solution {

    public static int first, last;
    public int findKthLargest(int[] nums, int k) {
        int[] nums1;
        nums1 = new int[]{3,2,1,5,6,4};
        return RandomSelect(nums, nums.length - k);
    }

    private int RandomSelect(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;

        int ans = 0;
        while(l <= r){
            int m = l + (int) (Math.random() * (r - l + 1));
            partition1(arr, l ,r, arr[m]);
            if(k < first){
                r = first-1;
            } else if (k > last) {
                l = last+1;
            }else {
                ans = arr[k];
                break;
            }
        }
        return ans;
    }

    private void partition1(int[] arr, int l, int r, int m) {
        first = l;
        last = r;
        int i = l;
        while(i <= last){
            if(arr[i] < m){
                swap1(arr, first++, i++);
            } else if (arr[i] > m) {
                swap1(arr, last--, i);
            }else {
                i++;
            }
        }
    }

    private void swap1(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
