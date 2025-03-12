package class053;

import java.io.*;

public class c3ImplBigFishEatSmallFish {

    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n, r;
    public static int[][] stack = new int[MAXN][2];
    //栈里存arr上的索引位置还是具体的数字，根据题目分析，这个题不需要算索引距离一类的，所以直接
    //存体积来比较就可以，其他题有明确计算距离，所以存索引既可以方便求距离，也能再用索引去数组里取值
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(turns());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int turns(){
        r = 0;
        int ans = 0;
        for (int i = n - 1, curTurn; i >= 0; i--) {
            curTurn = 0;
            while (r > 0 && stack[r - 1][0] < arr[i]){
                curTurn = Math.max(curTurn + 1, stack[--r][1]);
            }
            stack[r][0] = arr[i];
            stack[r++][1] = curTurn;
            ans = Math.max(ans, curTurn);
        }
        return ans;
    }
}
