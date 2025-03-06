package class050;

import java.util.Arrays;

public class c4ImplBoatsToSavePeople {

    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int ans = 0;
            int l = 0;
            int r = people.length - 1;
            int sum = 0;
            while (l <= r){
                sum = l == r? people[l] : people[l] + people[r];
                if (sum > limit){
                    r--;
                }else {
                    l++;
                    r--;
                }
                ans++;
            }
            return ans;
        }
    }
}
