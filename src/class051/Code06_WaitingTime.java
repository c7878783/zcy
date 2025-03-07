package class051;

import java.util.PriorityQueue;

// 计算等位时间
// 给定一个数组arr长度为n，表示n个服务员，每服务一个人的时间
// 给定一个正数m，表示有m个人等位，如果你是刚来的人，请问你需要等多久？
// 假设m远远大于n，比如n <= 10^3, m <= 10^9，该怎么做是最优解？
// 谷歌的面试，这个题连考了2个月
// 找不到测试链接，所以用对数器验证
public class Code06_WaitingTime {

	// 堆模拟
	// 验证方法，不是重点
	// 如果m很大，该方法会超时
	// 时间复杂度O(m * log(n))，额外空间复杂度O(n)
	public static int waitingTime1(int[] arr, int m) {
		// 一个一个对象int[]
		// [醒来时间，服务一个客人要多久]
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			heap.add(new int[] { 0, arr[i] });//0表示从0时间开始随时服务
		}
		for (int i = 0; i < m; i++) {
			int[] cur = heap.poll();
			cur[0] += cur[1];//表示去服务的时间点和服务结束后的时间长度加起来，用来表示可以再次服务的时间点
			heap.add(cur);//其实这个做法在一开始的时候是，所有waiters都出去服务，然后谁回来的早谁就接着服务
		}
		return heap.peek()[0];
	}

	// 二分答案法
	// 最优解
	// 时间复杂度O(n * log(min * w))，额外空间复杂度O(1)
	public static int waitingTime2(int[] arr, int w) {
		int min = Integer.MAX_VALUE;
		for (int x : arr) {
			min = Math.min(min, x);
		}
		int ans = 0;
		for (int l = 0, r = min * w, m; l <= r;) {
			// m中点，表示一定要让服务员工作的时间！
			// 我让每个服务员工作m时间，能不能轮到我？
			m = l + ((r - l) >> 1);
			// 能够给几个客人提供服务
			if (f(arr, m) >= w + 1) {//这里的含义是需要等几个人才能服务
				ans = m;
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return ans;
	}

	// 如果每个服务员工作time，可以接待几位客人（结束的、开始的客人都算）
	public static int f(int[] arr, int time) {
		int ans = 0;
		for (int num : arr) {
			ans += (time / num) + 1;
		}
		return ans;
	}

	// 对数器测试
	public static void main(String[] args) {
		System.out.println("测试开始");
		int N = 50;
		int V = 30;
		int M = 3000;
		int testTime = 20000;
		for (int i = 0; i < testTime; i++) {
			int n = (int) (Math.random() * N) + 1;
			int[] arr = randomArray(n, V);
			int m = (int) (Math.random() * M);
			int ans1 = waitingTime1(arr, m);
			int ans2 = waitingTime2(arr, m);
			if (ans1 != ans2) {
				System.out.println("出错了!");
			}
		}
		System.out.println("测试结束");
	}

	// 对数器测试
	public static int[] randomArray(int n, int v) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * v) + 1;
		}
		return arr;
	}

}
