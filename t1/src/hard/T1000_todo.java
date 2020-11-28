package hard;

/**
 *1000. 合并石头的最低成本
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。

 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。

 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。

 todo 动态规划

 */
public class T1000_todo {

    public static void main(String args[]) {
        T1000_todo t = new T1000_todo();

    }

    public int mergeStones(int[] stones, int K) {

        if((stones.length - 1) % (K - 1) != 0) return -1;

        int[] sumArr = new int[stones.length];
        int tempSum = 0;
        for(int i=0;i<stones.length;i++){
            sumArr[i] = tempSum + stones[i];
        }

        return 0;
    }

    public int get(int index, int[] sum){
        if(index == 0){
            return sum[0];
        }
        return sum[index] - sum[index -1];
    }

    public int getSum(int start, int end, int[] sum){
        if(start == 0) return sum[end];
        return sum[end] - sum[start - 1];
    }

}
