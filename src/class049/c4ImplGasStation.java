package class049;

public class c4ImplGasStation {


    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;

            for (int l = 0, r = 0, sum; l < n; l = r + 1, r = l){
                sum = 0;
                while (sum + gas[r % n] - cost[r % n] >= 0){
                    if (r - l + 1 == n){
                        return l;
                    }
                    sum += gas[r % n] - cost[r % n];
                    r++;
                }
            }
            return -1;
        }
    }
}
