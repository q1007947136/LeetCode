package medium;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。

 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。

 如果不存在这样的子数组，请返回 0 。

 */
public class T1493 {
    public static void main(String args[]){
        int[] nums = {1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int res = 0;
        int pre = 0;
        int after = 0;
        boolean flag = true;
        for(int x:nums){
            if(x == 1){
                if(flag){
                    pre++;
                }else{
                    after++;
                }
            }else{
                if(flag){
                    flag = false;
                }else{
                    res = Math.max(res, pre + after);
                    pre = after;
                    after = 0;
                }
            }
        }
        if(flag){
            res = res = Math.max(res, pre + after) - 1;
        }else{
            res = Math.max(res, pre + after);
        }
        return res;
    }
}
