package hard;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。

 注意： x 不必 是 nums 的中的元素。

 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 */
public class T31 {

    public static void main(String args[]){

        T31 t = new T31();
        Solution s = t.new Solution();
        //[3,5]
        int[] nums = {3,6,7,7,0};
        System.out.println(s.specialArray(nums));
    }

    class Solution {
        public int specialArray(int[] nums) {
            if(nums.length==0) return -1;
            Arrays.sort(nums);
            int result = -1;
            int lastV = -1;
            for(int i=0;i<nums.length;i++){
                if((nums[i] >= nums.length - i) && (nums.length - i > lastV)){
                    result = nums.length - i;
                    break;
                }
                lastV = nums[i];
            }
            return result;
        }
    }
}
