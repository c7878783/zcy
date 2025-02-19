package class022;

public class ImplReversePairs {

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static long reversePairs(int[] arr){
        return count(arr, 0, arr.length - 1);
    }

    public static long count(int[] arr, int l, int r){
        if (l == r){
            return 0;
        }
        int m = l + (r - l) / 2;

        return count(arr, l, m) + count(arr, m + 1, r) + countTwoSide(arr, l, m, r);
    }
    public static long countTwoSide(int[] arr, int l, int m, int r){
        long ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) arr[j] * 2){
                j++;
            }
            ans += j - (m + 1);
        }
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r){
            help[i++] = arr[a] < arr[b]? arr[a++] : arr[b++];
        }
        while (a <= m){
            help[i++] = arr[a++];
        }
        while (b <= r){
            help[i++] = arr[b++];
        }
        for (int j = l; j <= r; j++) {
            arr[j] = help[j];
        }

        return ans;
    }
}
