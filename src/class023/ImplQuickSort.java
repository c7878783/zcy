package class023;

public class ImplQuickSort {


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length > 1){
            quickSort(nums, 0, nums.length - 1);
        }
        return nums;
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition(arr, l, r, x);
        int left = first;
        int right = last;
        quickSort(arr, l, left - 1);
        quickSort(arr, right + 1, r);

    }
    public static int first;
    public static int last;
    public static void partition(int[] arr, int l ,int r, int x){
        int i = l;
        first = l;
        last = r;

        while(i <= last){
            if ( arr[i] == x){
                i++;
            } else if ( arr[i] < x) {
                swap(arr, i++, first++);
            }else {
                swap(arr, i, last--);
            }
        }


    }

}
