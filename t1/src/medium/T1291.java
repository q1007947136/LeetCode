package medium;

import leetcode.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. 顺次数
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。

 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 */
public class T1291 {

    public static void main(String args[]){
        Tool tool = new Tool();
        /**
         * 10
         1000000000
         */
        tool.printArrayList1(sequentialDigits(8551, 23553));
        System.out.println();
    }


        public static List<Integer> sequentialDigits(int low, int high) {
            List<Integer> list = new ArrayList<>();
            String lowStr = Integer.toString(low);
            String highStr = Integer.toString(high);

            String str = "123456789";
            int len = Math.min(highStr.length(), 9);
            for(int i=lowStr.length();i<=len;i++){
                int begin = 0;
                int end = begin + i;
                while(end <= 9) {
                    int val = Integer.valueOf(str.substring(begin,end));
                    if (val >= low && val <= high) {
                        list.add(val);
                    } else if (val > high) {
                        return list;
                    }
                    begin++;
                    end = begin + i;
                }
            }

            return list;
        }
}
