package medium;

import java.util.*;

/**
 * 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

 n >= 3
 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

 !!! 用数组一直超时，使用set就通过了
 */
public class T21 {

    public static void main(String args[]){
        T21 t = new T21();
        Solution s = t.new Solution();
        /**
         *[2,5,6,7,8,10,12,17,24,41,65]
         */
        int[] A = {2,5,6,7,8,10,12,17,24,41,65};
        System.out.println(s.lenLongestFibSubseq(A));
    }

//    class Solution {
//        public int lenLongestFibSubseq(int[] A) {
//            if(A.length < 3){
//                return 0;
//            }
//            int result = Integer.MIN_VALUE;
//            Map<int[], Integer> map = new HashMap<>();
////            int max = Arrays.stream(A).max().getAsInt();
////            int min = Arrays.stream(A).min().getAsInt();
//            for(int i=0;i<A.length - 2;i++){
//                // 两个最小值之和大于最大值
//                if(A[i] + A[i+1] > A[A.length - 1]){
//                    break;
//                }
//                if(A.length - i < result){
//                    return result;
//                }
////                // 两个值之最大和小于最大值
////                if(A[i] + A[A.length - 2] < A[A.length - 1]){
////                    continue;
////                }
//                for(int j=i+1;j<A.length - 1;j++){
//                    // 两个最小值之和大于最大值
//                    if(A[i] + A[j] > A[A.length - 1]){
//                        break;
//                    }
//                    if(A.length + 1 - j < result){
//                        break;
//                    }
//                    int[] arr = {i, j};
//                    if(map.get(arr)!=null){
//                        continue;
//                    }
//                    // 指针
//                    int left = i;
//                    int right = j;
//                    int index = j + 1;
//                    int length = 0;
//                    int sum;
//                    while(index < A.length) {
//                        sum = A[left] + A[right];
//                        if(sum > A[A.length - 1]){
//                            break;
//                        }
//                        if (sum == A[index]) {
//                            int[] a = {left, right};
//                            map.put(a, 1);
//                            if(length == 0){
//                                length = 3;
//                            }else {
//                                length += 1;
//                            }
//                            left = right;
//                            right = index;
//                        }else if(sum < A[index]){
//                            break;
//                        }
//                        index++;
//                    }
//
//                    // 在剩下的数组里查找sum
////                    while(index < A.length) {
////                        sum = A[left] + A[right];
////                        if(sum > A[A.length - 1]){
////                            break;
////                        }
////                        if(search(index, A.length - 1, sum, A)){
////                            int[] a = {left, right};
////                            map.put(a, 1);
////                            if(length == 0){
////                                length = 3;
////                            }else {
////                                length += 1;
////                            }
////                            left = right;
////                            right = index;
////                            index = right + 1;
////                        }
////                    }
//
//                    result = Math.max(result, length);
//                }
//            }
//            return result;
//        }
//
//        public boolean search(int left, int right, int value, int[] arr){
//            int mid;
//            while(right >= left){
//                mid = (right + left)/2;
//                if(arr[mid] == value){
//                    return true;
//                }else if(arr[mid] > value){
//                    right = mid - 1;
//                }else{
//                    left = mid + 1;
//                }
//            }
//            return false;
//        }
//    }

    class Solution {
        public int lenLongestFibSubseq(int[] A) {
            int result = 0;
//            List<Integer> aList = Arrays.stream(A).boxed().collect(Collectors.toList());
            Set<Integer> set = new HashSet<>();
            for(int x:A){
                set.add(x);
            }
            for(int i=0;i<A.length - 2;i++){
                for(int j=i+1;j<A.length - 1;j++){
                    int sum = A[i] + A[j];
                    int right = A[j];
                    int length = 2;
                    while(set.contains(sum)) {
                        length += 1;
                        int temp = sum;
                        sum += right;
                        right = temp;
                    }
                    if(length > 2){
                        result = Math.max(result, length);
                    }
                }
            }
            return result;
        }
    }
}
