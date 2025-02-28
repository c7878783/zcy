package class043;

import java.io.*;
import java.util.Scanner;

public class c1ImplKillMonsterEverySkillUserOnce {

    public static int MAXN = 11;
    public static int[] kill = new int[MAXN];
    public static int[] blood = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            int t = (int)in.nval;
            for (int i = 0; i < t; i++){
                in.nextToken();
                int n = (int)in.nval;
                in.nextToken();
                int m = (int)in.nval;
                for (int j = 0; j < n; j++){
                    in.nextToken();
                    kill[j] = (int)in.nval;
                    in.nextToken();
                    blood[j] = (int)in.nval;
                }
                int ans = f(n, 0, m);
                out.println(ans == Integer.MAX_VALUE? -1 : ans);
            }
        }
        out.flush();
        br.close();
        out.close();
    }

    public static int f(int n, int i, int restBlood){
        if (restBlood <= 0){
            return i;
        }
        if (i == n){
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < n; j++){
            swap(i, j);
            ans = Math.min(ans, f(n, i + 1, restBlood - (restBlood > blood[i]? kill[i] : 2*kill[i])));
            swap(i, j);
        }
        return ans;
    }

    public static void swap(int i, int j){
        int temp = kill[i];
        kill[i] = kill[j];
        kill[j] = temp;
        temp = blood[i];
        blood[i] = blood[j];
        blood[j] = temp;
    }

}
