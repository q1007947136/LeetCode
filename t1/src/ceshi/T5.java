package ceshi;

import java.util.Arrays;

/**
 * 有长度为n的木头，需要切割成1的木块，共有m个人，切成3段之前只能由一个人完成
 */

public class T5 {
//    int m = 20;
//    int cutTime = 0;
    public static void main(String args[]){
        int n = 30;
        int[] arr = {n};
        T5 t = new T5();
        int result = t.cut(arr);
        System.out.println("result = "+result);
    }

    public int cut(int[] a){
        boolean bool = true;
        int cutTime = 0;
        int length = a[0];
        int[] tempArr;
        int index = a.length;
        while (bool) {
            bool = false;
            int m;
            if (a.length < 3) {
                m = 1;
            } else {
                m = 20;
            }
            tempArr = new int[index + Math.min(m, length)];
            length = 0;
            index = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != 1) {
                    bool = true;
                    if (m != 0) {
                        int left = a[i] / 2;
                        int right = a[i] - left;
                        tempArr[index] = left;
                        if(left != 1){
                            length++;
                        }
                        index++;
                        tempArr[index] = right;
                        if(right != 1){
                            length++;
                        }
                        index++;
                        m = m - 1;
                    } else {
                        tempArr[index] = a[i];
                        if(a[i] != 1){
                            length++;
                        }
                        index++;
                    }
                }else{
                    tempArr[index] = a[i];
                    if(a[i] != 1){
                        length++;
                    }
                    index++;
                }
            }
            a = Arrays.copyOf(tempArr, tempArr.length);
//            for(int i=0;i<tempArr.length;i++){
//                if(tempArr[i] != 1){
//                    length++;
//                }
//            }
            cutTime++;
        }
        return cutTime - 1;
    }

}
