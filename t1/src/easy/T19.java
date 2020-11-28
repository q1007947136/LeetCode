package easy;

import leetcode.Tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 注意：

 答案中不可以包含重复的四元组。

 方法：双指针
 四个数可以先固定两个数，剩下两个数使用双指针来调整大小，类似滑动窗口
 */

public class T19 {

    public static void main(String args[]){
        T19 t = new T19();
        Solution s = t.new Solution();
        Tool tool = new Tool();
        /**
         * [-2,-1,-1,1,1,2,2]
         0
         */
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        tool.printArrayList(s.fourSum(nums, target));
    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            if(nums.length < 4){
                return list;
            }
            Arrays.sort(nums);
            for(int i=0;i<nums.length-3;i++){
                // 加上剪枝
                // 第一个固定值判断最小值，最小值如果比target大，后面就不需要再看了
                if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                    break;
                }
                // 判断最大值，如果最大值比target小，后面就不需要再看了
                if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target){
                    continue;
                }
                for(int j=i+1;j<nums.length-2;j++){
                    // 双指针
                    int left = j + 1;
                    int right = nums.length - 1;
                    // 第二次剪枝
                    // 判断最小值，最小值如果比target大，后面就不需要再看了
                    if(nums[i] + nums[j] + nums[left] + nums[left + 1] > target){
                        break;
                    }
                    // 判断最大值，如果最大值比target小，后面就不需要再看了
                    if(nums[i] + nums[j] + nums[right] + nums[right - 1] < target){
                        continue;
                    }

                    int doubleSum = nums[i] + nums[j];
                    while(right > left){
                        int totalSum = doubleSum + nums[left] + nums[right];
                        if(totalSum == target){
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[left]);
                            l.add(nums[right]);
                            // 排好序的数组不需要考虑顺序问题
                            if(list.indexOf(l) == -1) {
                                list.add(l);
                            }
                        }
                        if(totalSum > target){
                            right -= 1;
                        }else{
                            left += 1;
                        }
                    }
                }
            }
            return list;
        }
    }
}
