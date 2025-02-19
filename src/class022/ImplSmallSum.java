package class022;

public class ImplSmallSum {

    public static int MAXN = 50001;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];


    public static long smallSum(int l, int r){
        if (l == r){
            return 0;
        }
        int m = l + (r - l) / 2;
        return smallSum(l, m ) + smallSum(m + 1, r) + merge(l, m, r);
    }

    public static long merge(int l, int m,int r){
        long ans = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]){
                sum += arr[i++];
            }
            ans += sum;
        }

        int i = l;
        int a = l;
        int b = m + 1;
        while ( a <= m && b <= r){
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
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
