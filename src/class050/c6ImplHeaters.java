package class050;

import java.util.Arrays;

public class c6ImplHeaters {

    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int ans = 0;
            for (int i = 0, j = 0; i < houses.length; i++) {
                while (!best(houses, heaters, i, j)){
                    j++;
                }
                ans = Math.max(ans, Math.abs(houses[i] - heaters[j]));
            }
            return ans;
        }

        public static boolean best(int[] houses, int[] heaters, int i, int j){
            return j == heaters.length - 1 || Math.abs(houses[i] - heaters[j]) < Math.abs(houses[i] - heaters[j + 1]);
        }
    }
}
