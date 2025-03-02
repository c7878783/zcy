package class046;

import java.io.*;
import java.util.HashMap;

public class c2ImplLongestSubarraySumEqualsAim {

    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n;
    public static int aim;

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            aim = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int compute(){
        map.clear();
        map.put(0, -1);
        int ans = 0;
        for (int i = 0, sum = 0; i < n; i++){
            sum += arr[i];
            if (map.containsKey(sum - aim)){
                ans = Math.max(ans, i - map.get(sum - aim));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return ans;
    }
}
