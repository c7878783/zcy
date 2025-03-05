package class049;

import java.util.Arrays;

// K个不同整数的子数组
// 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
// 如果 nums 的某个子数组中不同整数的个数恰好为 k
// 则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
// 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
// 子数组 是数组的 连续 部分。
// 测试链接 : https://leetcode.cn/problems/subarrays-with-k-different-integers/
public class Code06_SubarraysWithKDifferentIntegers {
	//求k个不是单调的，所谓单调指的就是l前进会更不容易超过k，r前进会更容易超过，而=k无论是l前进还是r前进都无法保证单调更接近k还是远离
	public static int subarraysWithKDistinct(int[] arr, int k) {
		return numsOfMostKinds(arr, k) - numsOfMostKinds(arr, k - 1);//不超过k的减去不超过k-1的就是严格等于k的
	}

	public static int MAXN = 200001;

	public static int[] cnts = new int[MAXN];//值得注意的是，输入数字只说了大于1，也就是有可能是多位数

	// arr中有多少子数组，数字种类不超过k
	// arr的长度是n，arr里的数值1~n之间
	public static int numsOfMostKinds(int[] arr, int k) {
		Arrays.fill(cnts, 1, arr.length + 1, 0);//因为我走过去了就不会再走回来
		int ans = 0;
		for (int l = 0, r = 0, collect = 0; r < arr.length; r++) {
			if (++cnts[arr[r]] == 1) {//=1说明之前从没进来过
				collect++;
			}
			while (collect > k) {
				if (--cnts[arr[l++]] == 0) {
					collect--;
				}
			}
			ans += r - l + 1;//此时我们的目的是不能超过k种，所以在当前r，如果满足了满的k，我们应当注意到只能l向前移动才可以远离这个k
		}
		return ans;
	}

}
