package easy;

import leetcode.Tool;

import java.util.Arrays;

/**
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。

 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

 */
public class T1030 {

    public static void main(String args[]){
        Tool tool = new Tool();
        tool.printArrayList(allCellsDistOrder(3,3,0,2));
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        /** 暴力解法
        int[][] res = new int[R * C][2];
        int max = Math.max(R,C);
        int[] pos = {r0, c0};
        res[0] = pos;
        int index = 1;
        for(int i=1;i<=max*2;i++){
            for(int j=0;j<=i;j++){
                // 偏移量
                int offset_x = j;
                int offset_y = i - j;
                if(0 <= (r0 + offset_x) && (r0 + offset_x) < R){
                    int x = r0 + offset_x;
                    if(0 <= (c0 + offset_y) && (c0 + offset_y) < C){
                        int y = c0 + offset_y;
                        pos = new int[]{x, y};
                        res[index] = pos;
                        index++;
                    }
                    if(offset_y != 0) {
                        if (0 <= (c0 - offset_y) && (c0 - offset_y) < C) {
                            int y = c0 - offset_y;
                            pos = new int[]{x, y};
                            res[index] = pos;
                            index++;
                        }
                    }
                }
                if(offset_x != 0) {
                    if (0 <= (r0 - offset_x) && (r0 - offset_x) < R) {
                        int x = r0 - offset_x;
                        if (0 <= (c0 + offset_y) && (c0 + offset_y) < C) {
                            int y = c0 + offset_y;
                            pos = new int[]{x, y};
                            res[index] = pos;
                            index++;
                        }
                        if(offset_y != 0) {
                            if (0 <= (c0 - offset_y) && (c0 - offset_y) < C) {
                                int y = c0 - offset_y;
                                pos = new int[]{x, y};
                                res[index] = pos;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        return res;
         */
        // 用Arrays.sort 慢了将近10ms
        int[][] res = new int[R * C][2];
        int index = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                res[index] = new int[]{i, j};
                index++;
            }
        }
        Arrays.sort(res, (a,b) -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) -
                (Math.abs(b[0] - r0) + Math.abs(b[1] - c0)));
        return res;
    }
}
