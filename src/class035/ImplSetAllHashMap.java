package class035;

import java.io.*;
import java.util.HashMap;

public class ImplSetAllHashMap {


    public static HashMap<Integer, int[]> map = new HashMap<>();
    public static int setAllValue;
    public static int setAlltime;
    public static int cnt;

    public static void put(int k, int v){
        if (map.containsKey(k)){
            int[] value = map.get(k);
            value[0] = v;
            value[1] = cnt++;
        }else {
            map.put(k, new int[] {v, cnt++});
        }
    }

    public static void setAll(int allValue){
        setAllValue = allValue;
        setAlltime = cnt++;
    }

    public static int get(int k){
        if (!map.containsKey(k)){
            return -1;
        }
        int[] value = map.get(k);
        if (value[1] < setAlltime){
            return setAllValue;
        }else return value[0];
    }

    public static int n, opt, x, y;

    public static void main(String[] args) throws IOException {//ACM风格通用方案
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            map.clear();
            setAllValue = 0;
            setAlltime = -1;
            cnt = 0;
            n = (int) in.nval;
            for (int i = 0; i < n; i++){
                in.nextToken();
                opt = (int) in.nval;
                if (opt == 1){
                    in.nextToken();
                    x = (int) in.nval;
                    in.nextToken();
                    y = (int) in.nval;
                    put(x, y);
                } else if (opt == 2) {
                    in.nextToken();
                    x = (int) in.nval;
                    out.println(get(x));
                }else {
                    in.nextToken();
                    x = (int) in.nval;
                    setAll(x);
                }
            }

        }
        out.flush();
        out.close();
        br.close();
    }
}
