package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 846. 一手顺子
 * 爱丽丝有一手（hand）由整数数组给定的牌。 

 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。

 如果她可以完成分组就返回 true，否则返回 false。

 */
public class T20 {

    public static void main(String args[]){
        T20 t = new T20();
        Solution s = t.new Solution();
        /**
         * hand = [1,2,3,6,2,3,4,7,8], W = 3
         */
        int[] hand = {8,10,12};
        int W = 3;
        System.out.println(s.isNStraightHand(hand, W));
    }

    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            // W能被hand的长度整除才满足需求
            if(hand.length % W != 0){
                return false;
            }
            List<Integer> handList = Arrays.stream(hand).boxed().collect(Collectors.toList());
//            List<List<Integer>> list = new ArrayList<>();
            while(handList.size() > 0){
//                List<Integer> l = new ArrayList<>();
                int min = Collections.min(handList);
//                l.add(min);
                handList.remove(Integer.valueOf(min));
                min += 1;
                // 每组W个
                for(int j=1;j<W;j++){
                    if(handList.indexOf(min) == -1){
                        return false;
                    }else{
//                        l.add(min);
                        handList.remove(Integer.valueOf(min));
                        min += 1;
                    }
                }
//                list.add(l);
            }
//            Tool tool = new Tool();
//            tool.printArrayList(list);
            return true;
        }
    }

    // 超出内存限制
//    class Solution {
//        public boolean isNStraightHand(int[] hand, int W) {
//            // W能被hand的长度整除才满足需求
//            if (hand.length % W != 0) {
//                return false;
//            }
//            Arrays.sort(hand);
////            Map<Integer, Integer> map = new HashMap<>();
//            int max = Arrays.stream(hand).max().getAsInt();
//            int[] arr = new int[max + 1];
//            for(int i=0;i<hand.length;i++){
////                int value = map.get(hand[i]);
//                if(arr[hand[i]] == 0){
//                    for(int j=1;j<W;j++){
//                        if(hand[i] + j >= arr.length){
//                            return false;
//                        }
//                        arr[hand[i] + j] += 1;
////                        if(arr[hand[i] + j] == 0) {
////                            arr[hand[i] + j] = 1;
////                        }else{
////                            int value = map.get(hand[i] + j);
////                            map.put(hand[i] + j, value + 1);
////                        }
//                    }
//                }else{
//                    arr[hand[i]] -= 1;
////                    int value = map.get(hand[i]);
////                    if(value - 1 == 0){
////                        map.remove(hand[i]);
////                    }else {
////                        map.put(hand[i], value - 1);
////                    }
//                }
//            }
//            return Arrays.stream(arr).max().getAsInt() == 0;
//        }
//    }
}
