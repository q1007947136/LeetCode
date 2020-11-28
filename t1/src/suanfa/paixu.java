package suanfa;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序算法
 */

public class paixu {
    public static void main(String args[]){
        Random r = new Random();
        int[] a = new int[r.nextInt(20)+1];
        for(int i=0;i<a.length;i++){
            a[i] = r.nextInt(100)+1;
        }
        paixu p = new paixu();
        p.printArray(a);
        int[] b = Arrays.copyOf(a, a.length);
        b = p.bubbleSort(b);
        System.out.print("bubbleSort:");
        p.printArray(b);
        int[] c = Arrays.copyOf(a, a.length);
        c = p.mergeSort(c);
        System.out.print("mergeSort:");
        p.printArray(c);
        int[] d = Arrays.copyOf(a, a.length);
        d = p.bucketSort(d);
        System.out.print("bucketSort:");
        p.printArray(d);
        int[] e = Arrays.copyOf(a, a.length);
        e = p.insertSort(e);
        System.out.print("insertSort:");
        p.printArray(e);

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

    // 冒泡排序时间复杂度为O(n^2)
    private int[] bubbleSort(int[] arr){
        for(int i=0;i<(arr.length-1);i++){
            for(int j=1;j<(arr.length-i);j++){
                if(arr[j - 1] > arr[j]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // 归并排序 时间复杂度为O(nlogn)
    private int[] mergeSort(int[] arr) {
        int mid = arr.length / 2;
        if (mid == 0) {
            return arr;
        } else {
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            int[] resultLeft = mergeSort(left);
            int[] resultRight = mergeSort(right);
            int indexLeft = 0;
            int indexRight = 0;
            int[] temp = new int[resultLeft.length + resultRight.length];
            for (int i = 0; i < temp.length; i++) {
                if (indexLeft == (resultLeft.length)) {
                    temp[i] = resultRight[indexRight];
                    indexRight++;
                } else if (indexRight == (resultRight.length)) {
                    temp[i] = resultLeft[indexLeft];
                    indexLeft++;
                } else {
                    if ((resultLeft[indexLeft]) < (resultRight[indexRight])) {
                        temp[i] = resultLeft[indexLeft];
                        indexLeft++;
                    } else {
                        temp[i] = resultRight[indexRight];
                        indexRight++;
                    }
                }
            }
            return temp;
        }
    }

    // 桶排序
    // 限制条件：需要知道原数组元素的取值范围
    // 初始数组大小为n，桶个数为m，时间复杂度为O(n+m)，近似于O(n),若事先不知道取值范围则时间复杂度为(2n+m)
    private int[] bucketSort(int[] arr){
        // 先取arr的最大值
        int max= 0;
        for (int x:arr) {
            if(x > max){
                max = x;
            }
        }
        int[] bucket = new int[max+1];
        for (int x:arr) {
            bucket[x]++;
        }
        int index = 0;
        for (int i=0;i<bucket.length;i++) {
            for(int j=0;j<bucket[i];j++){
                arr[index] = i;
                index++;
            }
        }
        return arr;
    }


    //插入排序O(n^2)
    private int[] insertSort(int[] arr){
        int[] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int index = 0;
                while ((arr[i] > newArr[index]) && (newArr[index] != 0)) {
                    index++;
                }
                if(newArr[index] != 0) {
                    for (int j = (newArr.length - 1); j > index; j--) {
                        newArr[j] = newArr[j - 1];
                    }
                }
                newArr[index] = arr[i];

        }
        return newArr;
    }

}
