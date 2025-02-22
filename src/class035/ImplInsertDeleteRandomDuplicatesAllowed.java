package class035;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ImplInsertDeleteRandomDuplicatesAllowed {


    class RandomizedCollection {

        public HashMap<Integer, HashSet<Integer>> map;//改用不能重复的set代替interger来存储这个value的所有下标；
        public ArrayList<Integer> arr;

        public RandomizedCollection() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            arr.add(val);
            HashSet<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
            set.add(arr.size() - 1);
            map.put(val, set);
            return set.size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            HashSet<Integer> valSet = map.get(val);
            Integer anyValIndex = valSet.iterator().next();
            int endValue = arr.get(arr.size() - 1);
            if (val == endValue){
                valSet.remove(arr.size() - 1);
            }else {
                HashSet<Integer> endValueSet = map.get(endValue);
                endValueSet.add(anyValIndex);
                arr.set(anyValIndex, endValue);
                endValueSet.remove(arr.size() - 1);
                valSet.remove(anyValIndex);
            }
            arr.remove(arr.size() - 1);
            if (valSet.isEmpty()){
                map.remove(val);
            }
            return true;

        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }



}
