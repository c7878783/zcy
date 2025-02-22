package class035;

import java.util.ArrayList;
import java.util.HashMap;

public class ImplInsertDeleteRandom {


    class RandomizedSet {

        public HashMap<Integer, Integer> map;
        public ArrayList<Integer> arr;
        //一个哈希表一个动态链表，哈希表存储数值和数组索引，快速查询，动态链表使用索引完成均等随机
        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            int valueIndex = map.get(val);
            int endValue = arr.get(arr.size() - 1);
            map.put(endValue, valueIndex);
            arr.set(valueIndex, endValue);
            map.remove(val);
            arr.remove(arr.size() - 1);
            return true;
        }

        public int getRandom() {
            return arr.get((int)(Math.random() * arr.size()));
        }
    }

}
