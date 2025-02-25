package class038;

// 打印n层汉诺塔问题的最优移动轨迹
public class Code07_TowerOfHanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			f(n, "左", "右", "中");
		}
	}

	public static void f(int i, String from, String to, String other) {//i表示的不是第i大的盘，而是第1~i大这i个盘
		if (i == 1) {
			System.out.println("移动圆盘 1 从 " + from + " 到 " + to);//from是当前位置，to是期望位置，other是另一个位置
		} else {
			f(i - 1, from, other, to);//需要把这i个阻拦我行进的盘挪到other上才好
			System.out.println("移动圆盘 " + i + " 从 " + from + " 到 " + to);
			f(i - 1, other, to, from);//再把这i个盘从other挪到to上,经历了上面的操作，原本的from成了空的other
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
