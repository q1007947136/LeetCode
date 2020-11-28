package hard;

import leetcode.Tool;

import java.util.Arrays;


/**
 * 面试题 10.11. 峰与谷
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 */
public class T30 {
    public static void main(String args[]){
        T30 t = new T30();
        Solution s = t.new Solution();
        /**
         * [3,5,2,1,6,4]
         */
        int[] nums = {3,5,2,1,6,4};
        s.wiggleSort(nums);
    }

    class Solution {
        public void wiggleSort(int[] nums) {
            // 特判
            if(nums.length == 0) return;


            int[] temp = Arrays.copyOf(nums, nums.length);
            Arrays.sort(temp);

            for(int i=0;i<temp.length/2;i++){
                nums[2*i] = temp[i];
                nums[2*i+1] = temp[temp.length - 1 - i];
            }
            if((temp.length & 1) == 1){
                nums[nums.length - 1] = temp[temp.length/2];
            }


//            Arrays.sort(nums);
//            int[] temp = new int[nums.length];
//
//            for(int i=0;i<nums.length/2;i++){
//                temp[2*i] = nums[i];
//                temp[2*i+1] = nums[nums.length - 1 - i];
//            }
//            if((nums.length & 1) == 1){
//                temp[temp.length - 1] = nums[nums.length/2];
//            }
//            nums = temp;


            Tool tool = new Tool();
            tool.printIntArray(nums);
        }
    }
}
