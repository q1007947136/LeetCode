package easy;

/**
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。

 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。

 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 */
public class T10 {
    public static void main(String args[]){
        int[] nums = {-3,2,-3,4,2};
        Solution s = new T10().new Solution();
        System.out.println(s.minStartValue(nums));

    }

    class Solution {
        public int minStartValue(int[] nums) {
            int min = 0;
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
                if(sum < min){
                    min = sum;
                }
            }
            if(min >= 0){
                return 1;
            }else{
               return -min + 1;
            }
        }
    }
}
