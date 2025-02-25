package class038;

import java.util.ArrayList;
import java.util.List;

// 没有重复项数字的全排列
// 测试链接 : https://leetcode.cn/problems/permutations/
public class Code03_Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		f(nums, 0, ans);
		return ans;
	}

	public static void f(int[] nums, int i, List<List<Integer>> ans) {
		if (i == nums.length) {
			List<Integer> cur = new ArrayList<>();
			for (int num : nums) {
				cur.add(num);
			}
			ans.add(cur);
		} else {
			for (int j = i; j < nums.length; j++) {//当前数字一个个和下面的换
				swap(nums, i, j);
				f(nums, i + 1, ans);//从当前位置数字的下一个开始
				swap(nums, i, j); // 特别重要，课上进行了详细的图解,你不换回来咋咋能是穷举一个个可能
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> ans = permute(nums);
		for (List<Integer> list : ans) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
