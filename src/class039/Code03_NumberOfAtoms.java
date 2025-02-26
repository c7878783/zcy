package class039;

import java.util.TreeMap;

// 含有嵌套的分子式求原子数量
// 测试链接 : https://leetcode.cn/problems/number-of-atoms/
public class Code03_NumberOfAtoms {

	public static String countOfAtoms(String str) {
		where = 0;
		TreeMap<String, Integer> map = f(str.toCharArray(), 0);
		StringBuilder ans = new StringBuilder();
		for (String key : map.keySet()) {
			ans.append(key);
			int cnt = map.get(key);
			if (cnt > 1) {
				ans.append(cnt);
			}
		}
		return ans.toString();
	}

	public static int where;

	// s[i....]开始计算，遇到字符串终止 或者 遇到 ) 停止
	// 返回 : 自己负责的这一段字符串的结果，有序表！
	// 返回之间，更新全局变量where，为了上游函数知道从哪继续！
	public static TreeMap<String, Integer> f(char[] s, int i) {
		// ans是总表
		TreeMap<String, Integer> ans = new TreeMap<>();
		// 之前收集到的名字，历史一部分
		StringBuilder name = new StringBuilder();
		// 之前收集到的有序表，历史一部分
		TreeMap<String, Integer> pre = null;
		// 历史翻几倍
		int cnt = 0;
		while (i < s.length && s[i] != ')') {//一个右括必定伴随一个左括
			if (s[i] >= 'A' && s[i] <= 'Z' || s[i] == '(') {
				fill(ans, name, pre, cnt);//把这个位字符前面的，下面栈括号中包含的先填进来。
				name.setLength(0);//至于这一位，从这里set成0开始就往下设置，但是是在跳出while循环后的那个fill中加入的,之所以这样做，是因为原子的名字是需要每次重置的
				pre = null;
				cnt = 0;
				if (s[i] >= 'A' && s[i] <= 'Z') {
					name.append(s[i++]);
				} else {
					// 遇到 (
					pre = f(s, i + 1);
					i = where + 1;
				}
			} else if (s[i] >= 'a' && s[i] <= 'z') {
				name.append(s[i++]);
			} else {
				cnt = cnt * 10 + s[i++] - '0';
			}
		}
		fill(ans, name, pre, cnt);
		where = i;
		return ans;
	}
	//进入这个方法只有两种事件要处理，一是单个的name，二是一组pre
	public static void fill(TreeMap<String, Integer> ans, StringBuilder name, TreeMap<String, Integer> pre, int cnt) {
		if (name.length() > 0 || pre != null) {
			cnt = cnt == 0 ? 1 : cnt;
			if (name.length() > 0) {
				String key = name.toString();
				ans.put(key, ans.getOrDefault(key, 0) + cnt);//要么是单独一个原子有cnt个
			} else {
				for (String key : pre.keySet()) {//要么就是有一整组为cnt个
					ans.put(key, ans.getOrDefault(key, 0) + pre.get(key) * cnt);//这句是说，把ans中已有的原子拿出来，再加上pre中有和ans中重复的原子乘上cnt
				}
			}
		}
	}

}
