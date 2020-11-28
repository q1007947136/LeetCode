package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 502. IPO
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。

 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。

 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。

 贪心算法+动态规划

 */
public class T502 {

    public static void main(String args[]){
        int k = 10;
        int W = 0;
        int[] Profits = {1,2,3};
        int[] Capital = {0,1,2};
        System.out.println(findMaximizedCapital(k,W,Profits, Capital));
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if(W >= Arrays.stream(Capital).max().getAsInt()){
            Arrays.sort(Profits);
            for(int i=0;i<k;i++){
                W+=Profits[Profits.length - 1 - i];
            }
            return W;
        }
        while(k > 0){
            int max = 0;
            int index = -1;
            for(int i=0;i<Capital.length;i++){
                if(W >= Capital[i]){
                    if(Profits[i] > max){
                        max = Profits[i];
                        index = i;
                    }
                }
            }
            if(index == -1) return W;
            W += max;
            Profits[index] = 0;
            k -= 1;
        }
        return W;
    }
}
