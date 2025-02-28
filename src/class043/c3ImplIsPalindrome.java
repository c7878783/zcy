package class043;

public class c3ImplIsPalindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0){
                return false;
            }
            int offset = 1;
            while (x / offset >= 10){
                offset *= 10;
            }
            while (x != 0){
                if (x / offset != x % 10){
                    return false;
                }
                x = (x % offset) / 10;
                offset /= 100;
            }
            return true;
        }
    }
}
