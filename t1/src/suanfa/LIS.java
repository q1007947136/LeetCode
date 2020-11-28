package suanfa;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * LIS算法:求最大上升子串
 */

public class LIS {
    public static void main(String args[]){
        int[] a = {5,4,3,2,1,5,4,3,2,1};
//        Random r = new Random();
//        int[] a = new int[r.nextInt(100)+1];
//        for(int i=0;i<a.length;i++){
//            a[i] = r.nextInt(100)+1;
//        }
        int b[] = a;
        LIS lis = new LIS();
        lis.printArray(a);
        long starTime = System.currentTimeMillis();
        lis.lis(a);
        long endTime = System.currentTimeMillis();
        System.out.println("二分查找执行耗时"+(endTime - starTime)+"ms!");
        long starTime1 = System.currentTimeMillis();
        lis.lis1(b);
        long endTime1 = System.currentTimeMillis();
        System.out.println("for执行耗时"+(endTime1 - starTime1)+"ms!");

//        int[] c = new int[r.nextInt(10)+1];
//        for(int i=0;i<c.length;i++){
//            c[i] = r.nextInt(100)+1;
//        }
//        Arrays.sort(c);
//        lis.printArray(c);
//        int d = r.nextInt(100)+1;
//        System.out.println("d = "+d);
////        int[] c = {1, 3, 12, 20, 25, 44, 45, 47, 58, 63, 73};
////        int d = 43;
//        lis.erfenSelect(c,d);
    }

    private void lis(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int index = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] >= dp[index - 1]){
               dp[index] = arr[i];
               index++;
            }else{// 找到dp中第一个大于arr[i]的值，替换它
                // for循环查找时间复杂度为O(n)
//                for(int j=0;j<index;j++){
//                    if(dp[j] > arr[i]){
//                        dp[j] = arr[i];
//                        break;
//                    }
//                }
                // 二分查找，时间复杂度为O(logn)
                int tempIndex = -1;
                int start = 0;
                int end = index - 1;
                int mid;
                while((end >= start)){
                    mid = (end + start) / 2;
                    if(dp[mid] >= arr[i]) {
                        tempIndex = mid;
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }

                }
                if(tempIndex != -1){
                    dp[tempIndex] = arr[i];
                }
            }
        }
        int[] result = new int[index];
        for (int i=0;i<result.length;i++){
            result[i] = dp[i];
        }
        printArray(result);
    }

    // 用二分查找在数组中找到符合a的位置
    private void erfenSelect(int[] arr, int a){
        int tempIndex = 0;
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while((end >= start)){
            mid = (end + start) / 2;
            if(a < arr[mid]) {
                tempIndex = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        System.out.println("a应该放在第"+(tempIndex+1)+"位");
    }

    private void lis1(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int index = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] >= dp[index - 1]){
                dp[index] = arr[i];
                index++;
            }else{// 找到dp中第一个大于arr[i]的值，替换它
                // for循环查找时间复杂度为O(n)
                for(int j=0;j<index;j++){
                    if(dp[j] >= arr[i]){
                        dp[j] = arr[i];
                        break;
                    }
                }
                // 二分查找，时间复杂度为O(logn)
//                int tempIndex = 0;
//                int start = 0;
//                int end = index;
//                int mid = -1;
//                while((end > start)){
//                    mid = (end + start) / 2;
//                    if(dp[mid] > arr[i]) {
//                        tempIndex = mid;
//                        end = mid - 1;
//                    }else{
//                        start = mid + 1;
//                    }
//
//                }
//                if(tempIndex != 0){
//                    dp[tempIndex] = arr[i];
//                }
            }
        }
        int[] result = new int[index];
        for (int i=0;i<result.length;i++){
            result[i] = dp[i];
        }
        printArray(result);
    }

    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length - 1)) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
