package class054;

public class c2ImplLongestSubarrayAbsoluteLimit {

    class Solution {

        public static int MAXN = 100001;
        public static int[] maxDeque = new int[MAXN];
        public static int[] minDeque = new int[MAXN];
        public static int maxh, maxt, minh, mint;
        public static int[] arr;

        public static int longestSubarray(int[] nums, int limit) {
            maxh = maxt = minh = mint = 0;
            arr = nums;
            int n = arr.length;
            int ans =0;
            for (int l = 0, r = 0; l < n; l++) {
                while (r < n && ok(limit, arr[r])){
                    push(r++);
                }
                ans = Math.max(ans, r - l);
                pop(l);
            }
            return ans;
        }

        public static boolean ok(int limit, int number){
            int max = maxh < maxt? Math.max(arr[maxDeque[maxh]], number) : number;
            int min = minh < mint? Math.min(arr[minDeque[minh]], number) : number;
            return max - min <= limit;
        }

        public static void push(int r){
            while (maxh < maxt && arr[maxDeque[maxt - 1]] <= arr[r]){
                maxt--;
            }
            maxDeque[maxt++] = r;
            while (minh < mint && arr[minDeque[mint - 1]] >= arr[r]){
                mint--;
            }
            minDeque[mint++] = r;
        }

        public static void pop(int l){
            if (maxh < maxt && maxDeque[maxh] == l){
                maxh++;
            }
            if (minh < mint && minDeque[minh] == l){
                minh++;
            }
        }
    }
}
