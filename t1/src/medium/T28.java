package medium;

import leetcode.Tool;

import java.util.Arrays;

/**
 * 面试题60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

  

 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

 */
public class T28 {

    public static void main(String args[]){
        T28 t = new T28();
        Solution s = t.new Solution();
        Tool tool = new Tool();
        tool.printDoubleArray(s.dicesProbability(3));
    }

    class Solution {
        public double[] dicesProbability(int n) {
            int len = 6;
            int[] arr = new int[len];
            Arrays.fill(arr, 1);
            for(int i=2;i<=n;i++){
                int left = 0;
                int right = 0;
                boolean flag = false;
                len = i * 5 + 1;
                int index = 0;
                int sum = 0;
                int[] temp = new int[len];
                while(left < arr.length - 1){
                    if(right < arr.length){
                        sum+=arr[right];
                        right++;
                    }
                    if(flag){
                        sum-=arr[left];
                        left++;
                    }
                    if(right - left > 5){
                        flag = true;
                    }
                    temp[index] = sum;
                    index ++;
                }
                arr = temp;
            }

            double fenmu = Math.pow(6,(double) n);
            double[] result = new double[arr.length];
            for(int i=0;i<arr.length;i++){
                result[i] = arr[i] / fenmu;
            }


            return result;
        }

        public double[] twoSum(int n) {
            double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
            for(int i=2;i<=n;i++){
                double tmp[]=new double[5*i+1];
                for(int j=0;j<pre.length;j++)
                    for(int x=0;x<6;x++)
                        tmp[j+x]+=pre[j]/6;
                pre=tmp;
            }
            return pre;
        }
    }
}
