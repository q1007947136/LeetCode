package medium;

/**
 * 1219. 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。

 为了使收益最大化，矿工需要按以下规则来开采黄金：

 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 矿工每次可以从当前位置向上下左右四个方向走。
 每个单元格只能被开采（进入）一次。
 不得开采（进入）黄金数目为 0 的单元格。
 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。

 回溯算法
 */
public class T25 {

    public static void main(String args[]){

        T25 t = new T25();
        Solution s = t.new Solution();
//        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        int[][] grid = {{0,0,0,0,0,0,32,0,0,20},{0,0,2,0,0,0,0,40,0,32},{13,20,36,0,0,0,20,0,0,0},{0,31,27,0,19,0,0,25,18,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,18,0,6},{0,0,0,25,0,0,0,0,0,0},{0,0,0,21,0,30,0,0,0,0},{19,10,0,0,34,0,2,0,0,27},{0,0,0,0,0,34,0,0,0,0}}
                ;
        System.out.println(s.getMaximumGold(grid));
    }

    class Solution {
        public int getMaximumGold(int[][] grid) {
            int result = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j] == 0){
                        continue;
                    }
                    result = Math.max(result, dfs(i, j, grid));
                }
            }
            return result;
        }

        public int dfs(int x, int y, int[][] grid){
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
                return 0;
            }

            int result = 0;
            int temp = grid[x][y];
            // 走过的置0 关键，这样就不需要做额外的剪枝操作了
            grid[x][y] = 0;

            // 上
            result = Math.max(result, dfs(x-1, y, grid));
            // 下
            result = Math.max(result, dfs(x+1, y, grid));
            // 左
            result = Math.max(result, dfs(x, y-1, grid));
            // 右
            result = Math.max(result, dfs(x, y+1, grid));

            // 复原
            grid[x][y] = temp;
            return result + temp;
        }

    }
}
