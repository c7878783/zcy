package class046;

import java.util.HashMap;

public class c5ImplLongestWellPerformingInterval {

    class Solution {
        public int longestWPI(int[] hours) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int ans = 0;
            for (int i = 0, sum = 0; i < hours.length; i++) {
                sum += hours[i] > 8? 1 : -1;
                if (sum > 0){
                    ans = i + 1;//前面全符合，继续向下，i是索引，记得加1
                }else {
                    if (map.containsKey(sum - 1)){
                        ans = Math.max(ans, i - map.get(sum - 1));
                    }
                }
                if (!map.containsKey(sum)){
                    map.put(sum, i);
                }
            }
            return ans;
        }
    }
}
