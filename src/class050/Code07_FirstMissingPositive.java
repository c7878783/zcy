package class050;

// 缺失的第一个正数
// 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
// 测试链接 : https://leetcode.cn/problems/first-missing-positive/
public class Code07_FirstMissingPositive {

	// 时间复杂度O(n)，额外空间复杂度O(1)
	public static int firstMissingPositive(int[] arr) {
		// l的左边，都是做到i位置上放着i+1的区域
		// 永远盯着l位置的数字看，看能不能扩充(l++)
		int l = 0;
		// [r....]垃圾区
		// 最好的状况下，认为1~r是可以收集全的，每个数字收集1个，不能有垃圾
		// 有垃圾呢？预期就会变差(r--)
		int r = arr.length;
		while (l < r) {
			if (arr[l] == l + 1) {
				l++;
				// 三种情况，垃圾会变多，
				// 1.当前这个数，比左边界还要小，负数或0不应该存在，如果是小的正数，早就该发配好了
				// 2.这个数比垃圾区边界值大，那完了，我只能找1~r不缺失，你对我没用。由于我只排列正整数，所以0~r-1摆放的应该是1~r，比r大，没用了
				// 3.这个数应该去的位置已经有数字了，也就是说数字重了
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
				swap(arr, l, --r);
			} else {
				swap(arr, l, arr[l] - 1);
			}
		}
		return l + 1;//最后l和r会相等，说明我收集完了1~r这几个数，而找不到的就是下一个
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
