package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 递归的缺点：重复计算，使用map保存重复的值
 */

public class T17 {

    public static void main(String args[]){

        T17 t = new T17();
        Solution s = t.new Solution();
        System.out.println(s.numWays(44));
    }

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int numWays(int n) {

            int totalWays = jump(0, n);
            return totalWays;

        }


        public int jump(int start, int n){
            if(map.get(start) != null){
                return map.get(start);
            }else {
                if (start > n) {
                    return 0;
                } else if (start == n) {
                    return 1;
                } else {
                    int ways = (jump(start + 1, n) + jump(start + 2, n)) % 1000000007;
                    map.put(start, ways);
                    return ways;
                }
            }

        }
    }
}
