package class021;

public class ImplMergeSort {

    public static int MAXN = 5001;

    public static int[] help = new int[MAXN];


    public static void mergeSort(int[] arr){
        if (arr.length > 1){
            sort(0, arr.length - 1);
        }
    }

    public static void sort(int l, int r){
        if (l == r){
            return;
        }
        int m = l + ((r - l) / 2);
        sort(l, m);
        sort(m + 1, r);

    }

    public static void merge(int[] arr, int l , int m , int r){
        int i = l;
        int a = l;
        int b = r;

        while (a <= m && b <=r ){
            help[i++] = arr[a] <= arr[b++] ? arr[a++] : arr[b++];
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
//        if (r - l >= 0) System.arraycopy(help, l, arr, l, r - l);
    }

}
