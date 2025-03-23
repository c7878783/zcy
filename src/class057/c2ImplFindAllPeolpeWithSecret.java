package class057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c2ImplFindAllPeolpeWithSecret {

    class Solution {

        public static int MAXN = 100001;
        public static int[] father = new int[MAXN];
        public static boolean[] secret = new boolean[MAXN];

        public static void build(int m, int first){
            for (int i = 0; i < m; i++) {
                father[i] = i;
                secret[i] = false;
            }
            father[first] = 0;
            secret[0] = true;
        }

        public static int find(int i){
            if (i != father[i]){
                father[i] = find(father[i]);
            }
            return father[i];
        }

        public static void union(int i, int j){
            int fx = find(i);
            int fy = find(j);
            if (fx != fy){
                father[fx] = fy;
                secret[fy] |= secret[fx];
            }
        }

        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            build(n, firstPerson);
            Arrays.sort(meetings, (a, b) -> (a[2] - b[2]));
            int m = meetings.length;
            for (int l = 0, r; l < m; ) {
                r = l;
                while (r + 1 < m && meetings[l][2] == meetings[r + 1][2]){
                    r++;
                }
                for (int i = l; i <= r; i++) {
                    union(meetings[i][0], meetings[i][1]);
                }
                for (int i = l, a, b; i <= r; i++){
                    a = meetings[i][0];
                    b = meetings[i][1];
                    if (!secret[find(a)]){
                        father[a] = a;
                    }
                    if (!secret[find(b)]){
                        father[b] = b;
                    }
                }
                l = r + 1;
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (secret[find(i)]){
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
