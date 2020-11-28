package medium;

import leetcode.Tool;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class T59 {

    public static void main(String args[]) {
        T59 t = new T59();
        Tool tool = new Tool();
        tool.printArrayList(t.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int sub = 1;
        boolean flag = true;
        int num = 1;
        int x = 0;
        int y = 0;
        while(num <= n*n){
            res[x][y] = num;
            num++;
            if(flag){
                if(y+sub >= n || y+sub < 0 || res[x][y+sub] != 0){
                    flag = false;
                    x += sub;
                }else{
                    y+=sub;
                }
            }else{
                if(x+sub >= n || x+sub < 0 || res[x+sub][y] != 0){
                    flag = true;
                    sub = -sub;
                    y += sub;
                }else{
                    x+=sub;
                }

            }
        }
        return res;
    }

}
