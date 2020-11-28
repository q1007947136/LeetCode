package medium;

import leetcode.Tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。

 斐波那契数字定义为：

 F1 = 1
 F2 = 1
 Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 数据保证对于给定的 k ，一定能找到可行解。

 */
public class T1414 {
    public static void main(String args[]){
        System.out.println(findMinFibonacciNumbers(19));
    }

    public static int findMinFibonacciNumbers(int k) {
        if(k == 1) return 1;
        // 先求出小于等k的斐波那契数列
        int[] init = {1,1};
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(1);
        int cur = 1;
        while(true){
            int next = fibonacci.get(cur) + fibonacci.get(cur - 1);
            if(next <= k) {
                fibonacci.add(next);
                cur++;
            }else{
                break;
            }
        }
        Tool tool = new Tool();
        tool.printArrayList1(fibonacci);
        int index = fibonacci.size() - 1;
        int result = 0;
        while(true){
            if(fibonacci.get(index) > k){
                index--;
            }else {
                result++;
                if (fibonacci.get(index) == k) {
                    return result;
                }
                k -= fibonacci.get(index);
            }
        }

    }


}
