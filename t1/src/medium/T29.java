package medium;

import leetcode.Tool;

/**
 * 1319. 连通网络的操作次数
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。

 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。

 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 todo 待优化（深度优先遍历）
 */
public class T29 {

    public static void main(String args[]){
        T29 t = new T29();
        Solution s = t.new Solution();
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(s.makeConnected(n, connections));
    }

//    class Solution {
//        public int makeConnected(int n, int[][] connections) {
//            int freeLine = 0;
//            Set<Integer> set = new HashSet<>();
//            int id = 0;
//            Map<Integer, Set<Integer>> pic = new HashMap<>();
//            Map<Integer, Integer> map = new HashMap<>();
//            for(int[] x:connections){
//                if(set.contains(x[0]) && set.contains(x[1])){
//                    int id1 = map.get(x[0]);
//                    int id2 = map.get(x[1]);
//                    if(id1 == id2){ // 同一个图，内部多余线
//                        freeLine++;
//                    }else{ // 不同图，合并
//                        Set<Integer> pic1 = pic.get(id1);
//                        Set<Integer> pic2 = pic.get(id2);
//                        pic1.addAll(pic2);
//                        for(Integer key:pic2){ // 图2的元素的id改为id1
//                            map.put(key, id1);
//                        }
//                        pic.remove(id2);
//                    }
//
//                }else if(set.contains(x[0])){
//                    set.add(x[1]);
//                    int id1 = map.get(x[0]);
//                    Set<Integer> pic1 = pic.get(id1);
//                    pic1.add(x[1]);
//                    map.put(x[1], id1);
//                }else if(set.contains(x[1])){
//                    set.add(x[0]);
//                    int id1 = map.get(x[1]);
//                    Set<Integer> pic1 = pic.get(id1);
//                    pic1.add(x[0]);
//                    map.put(x[0], id1);
//                }else{
//                    set.add(x[0]);
//                    set.add(x[1]);
//                    // 新增一张图
//                    Set<Integer> singleSet = new HashSet<>(); // 单个图
//                    singleSet.add(x[0]);
//                    singleSet.add(x[1]);
//                    // 保存个体和图之间的关系
//                    pic.put(id, singleSet);
//                    map.put(x[0], id);
//                    map.put(x[1], id);
//                    id++;
//                }
//            }
////            System.out.println("pic.size() = "+pic.size());
////            System.out.println("set.size() = "+ set.size());
////            System.out.println("freeLine = "+freeLine);
//            // 最终有pic.size()张图，内部多余线freeLine，合并为1张图需要操作pic.size() - 1次操作
//            if(pic.size() - 1 + n - set.size() <= freeLine){ // 可以合并已知图，独立图还有 n - set.size()张，需要n - set.size()次操作
//                return pic.size() - 1 + n - set.size();
//            }else{
//                return -1;
//            }
//        }
//    }

    // 并查集
    class Solution {
        int[] father;
        public int makeConnected(int n, int[][] connections) {
            if(connections.length < n-1) return -1;
            father = new int[n];
            for(int i=0;i<n;i++){
                // 先将所有点都看作单独的，与其他点无联系
                // 所有节点的父节点都设定为自身
                father[i] = i;
            }
            for(int[] a:connections){ // 线
                // 点与点之间用线连成图
                union(a[0], a[1]);
            }
            Tool tool = new Tool();
            tool.printIntArray(father);
            int count = 0;
            for(int i=0;i<n;i++){
                if(father[i] == i){
                    // 如果所有节点都连成了一张图，只有父节点自身的父节点才等于自身
                    count++;
                }
            }
            // count 表示所有节点构成的图的张数
            // count 张图需要count - 1 条线连接
            return count - 1;
        }

        // 连接
        public void union(int a, int b){
            int i = find(a);
            int j = find(b);
            if(i != j){
                // 如果两个节点的父节点不一样，则选择其中一个作为共同的父节点
                // 实质上是选择图中的一个节点作为图中所有节点的父节点，这样通过两个节点本身的值就可以判断他们是否处于同一张图
//                father[i] = j;
                father[j] = i;
            }
        }

        // 查找父节点
        public int find(int a){
            if(a != father[a]){
                father[a] = find(father[a]);
            }
            return father[a];
        }
    }


}
