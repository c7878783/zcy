package class030;

public class ImplOneKindNumberLessMtimes {

    public static int singleNumber(int[] nums) {
        return find(nums, 3);
    }


    public static int find(int[] nums, int m){
        int ans = 0;
        int[] cnts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                cnts[i] += (num >> i) & 1;//必须 >> i,因为num每次都是原始值
            }
        }
        for (int i = 0; i < 32; i++) {
            if (cnts[i] % m != 0){
                ans |= 1 << i;//用或的方式填充1
            }
        }
        return ans;
    }

}
