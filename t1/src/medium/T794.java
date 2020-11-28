package medium;

/**
 * 794. 有效的井字游戏
 * 用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。

 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。

 以下是井字游戏的规则：

 玩家轮流将字符放入空位（" "）中。
 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 当所有位置非空时，也算为游戏结束。
 如果游戏结束，玩家不允许再放置字符。

 */
public class T794 {


    public static void main(String args[]) {
        T794 t = new T794();
        /**
         * ["XXO","XOX","OXO"]
         */
        String[] board = {"XXO","XOX","OXO"};
        System.out.println(t.validTicTacToe(board));
    }

    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        int[][] row = new int[board.length][2]; // 行
        int[][] column = new int[board[0].length()][2]; // 列
        int[] leftItalic = new int[2]; // 左斜，只考虑过中间点的斜线, y = x
        int[] rightItalic = new int[2]; // 右斜，只考虑过中间点的斜线, y = -x + board.length

        for(int i=0;i<board.length;i++){
            char[] c = board[i].toCharArray();
            for(int j=0;j<c.length;j++) {
                if(c[j] == 'X'){
                    xCount++;
                    row[i][0]++;
                    column[j][0]++;
                    if(i == j){
                        leftItalic[0]++;
                    }
                    if(board.length - 1 - i == j){
                        rightItalic[0]++;
                    }
                }
                if(c[j] == 'O'){
                    oCount++;
                    row[i][1]++;
                    column[j][1]++;
                    if(i == j){
                        leftItalic[1]++;
                    }
                    if(board.length - 1 - i == j){
                        rightItalic[1]++;
                    }
                }
            }
        }

        for(int[] x:row){
            if(x[0] == board.length){
                return xCount == oCount + 1;
            }else if(x[1] == board.length){
                return xCount == oCount;
            }
        }

        for(int[] x:column){
            if(x[0] == board.length){
                return xCount == oCount + 1;
            }else if(x[1] == board.length){
                return xCount == oCount;
            }
        }

        if(leftItalic[0] == board.length){
            return xCount == oCount + 1;
        }else if(leftItalic[1] == board.length){
            return xCount == oCount;
        }

        if(rightItalic[0] == board.length){
            return xCount == oCount + 1;
        }else if(rightItalic[1] == board.length){
            return xCount == oCount;
        }


        return (xCount == oCount + 1) || (xCount == oCount);

    }

    public boolean checkWinner(int xCount, int oCount, int eachX, int eachO, int target){
        if(eachX == target){
            return xCount == oCount + 1;
        }else if(eachO == target){
            return xCount == oCount;
        }
        return false;
    }
}
