package medium;

/**
 * 1558. 得到目标数组的最少函数调用次数
 * 给你一个与 nums 大小相同且初始值全为 0 的数组 arr ，请你调用以上函数得到整数数组 nums 。

 请你返回将 arr 变成 nums 的最少函数调用次数。

 答案保证在 32 位有符号整数以内。
 */
public class T22 {

    public static void main(String args[]){
        T22 t = new T22();
        Solution s = t.new Solution();
        /**
         *[1000000000]
         */
        int[] A = {1000000000};
        System.out.println(s.minOperations(A));
    }

    class Solution {
        int maxCount = 0;
        public int minOperations(int[] nums) {
            int subCount = 0;
            for(int x:nums){
                subCount += getCount(x);
            }
            return subCount + maxCount;
        }

        public int getCount(int num){
            int count = 0; // 除以2次数，取最大值即可
            int subCount = 0; // -1次数
            while(num != 0){
                if((num & 1) == 1){//如果是奇数，则-1再除以2
                    num -= 1;
                    subCount++;
                }
                if(num != 0) {
                    num = num >> 1;
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
            return subCount;
        }
    }
}
