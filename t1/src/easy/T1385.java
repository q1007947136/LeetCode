package easy;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 *
 */
public class T1385 {

    public static void main(String[] args) {
        T1385 t = new T1385();
        /**
         * [-3,-3,4,-1,-10]
         * [7,10]
         * 12
         */
        int[] arr1 = {-3,-3,4,-1,-10};
        int[] arr2 = {7,10};
        int d = 12;
        System.out.println(t.findTheDistanceValue(arr1, arr2, d));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // 先排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index = 0;
        int res = 0;
        int start = 0;
        boolean isNext = false;
        while(index < arr1.length){
            boolean flag = arr1[index] < arr2[0];
            if(flag && isNext){
                index++;
                continue;
            }
            boolean loop = true;
            for(int i = start;i<arr2.length;i++){
                if((arr1[index] < arr2[i]) != flag){
                    loop = false;
                    if(Math.abs(arr1[index] - arr2[i]) > d){
                        res++;
                    }
                    break;
                }
                if(Math.abs(arr1[index] - arr2[i]) <= d){
                    if(flag){// 数组是递增的，如果当前数比用来比较的数小，那么递增的结果就是离那个数越来越近，只有当大于那个数时，距离才会拉开
                        isNext = true;
                    }
                    loop = false;
                    break;
                }else{
                    if(!flag) {
                        start = i + 1;
                    }
                }
            }
            if(loop){
                res++;
            }
            index++;
        }
        return res;
    }

}
