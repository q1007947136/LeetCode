package easy;

import leetcode.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * 218. 天际线问题
 */

public class T14_undone {
    public static void main(String args[]){

        T14_undone t = new T14_undone();
        Solution s = t.new Solution();
        int[][] arr = {{3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}};
        s.getSkyline(arr);
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> L = new ArrayList<>();
            if(buildings.length == 0){
                return L;
            }
            ArrayList<int[]> l = new ArrayList<>();
            l.add(buildings[0]);
            l = getSkyline1(buildings, l, 1);
            for(int i=0;i<l.size();i++){
                int[] a = l.get(i);
                List<Integer> list = new ArrayList<>();
                list.add(a[0]);
                list.add(a[2]);
                L.add(list);
                if(i == l.size() - 1){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(a[1]);
                    list1.add(0);
                    L.add(list1);
                }
            }
            Tool tool = new Tool();
            tool.printArrayList(l);
            tool.printArrayList(L);
            return L;
        }

        public ArrayList<int[]> getSkyline1(int[][] buildings, ArrayList<int[]> l, int index) {
            if (index < buildings.length) {
                ArrayList<int[]> NL = new ArrayList<>();
                int[] a1 = buildings[index];
                int left = a1[0];
                int right = a1[1];
                int height = a1[2];
                int ML = Integer.MAX_VALUE;
                int MR = 0;
                for (int j = 0; j < l.size(); j++) {
                    int[] a2 = l.get(j);
                    int tempL = a2[0];
                    int tempR = a2[1];
                    int tempH = a2[2];
                    ML = Math.min(ML, tempL);
                    MR = Math.max(MR, tempR);
                    if(left >= tempL && left <= tempR){

                    }
                }

            }
            return l;
        }



    }
}
