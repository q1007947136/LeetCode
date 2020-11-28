package hard;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * todo 动态规划，完全背包，
 */
public class T33_undone {

    public static void main(String args[]){

        T33_undone t = new T33_undone();
        Solution s = t.new Solution();
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(s.change(amount, coins));
    }

    class Solution {
        int result = 0;
        public int change(int amount, int[] coins) {
            Arrays.sort(coins);
            change1(amount, coins);
            return result;
        }

        // 只能用已有硬币凑
        public void change1(int amount, int[] coins){
            if(amount == 0) result++;
            for(int x:coins){
                if(x > amount){
                    break;
                }
                change1(amount - x, coins);
            }
        }
    }
}
