package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

 拓扑排序
 todo 6.61% 待优化
 */
public class T27 {
    public static void main(String args[]){

        T27 t = new T27();
        Solution s = t.new Solution();
        int numCourses = 7;
        int[][] prerequisites = {{1,0},{0,1}};
//        int[][] prerequisites = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
//        int[][] prerequisites = {{0,1},{2,3},{1,2},{3,0}};
        System.out.println(s.canFinish(numCourses, prerequisites));
    }

    class Myclass{
        int val;
        Set<Myclass> out;
        Set<Myclass> in;

        Myclass(int val){
            this.val = val;
            out = new HashSet<>();
            in = new HashSet<>();

        }

        public boolean canSelect(){
            return this.in.size() == 0;
        }

        public void remove(int val){
            for(Myclass mc:this.in){
                if(mc.val == val){
                    this.in.remove(mc);
                    break;
                }
            }
        }

        public void select(){
            for(Myclass mc:this.out){
                mc.remove(this.val);
            }
        }

        public void putIn(Myclass mc){
            for(Myclass m:this.in){
                if(m.val == mc.val){
                    return;
                }
            }
            this.in.add(mc);
        }

        public void putOut(Myclass mc){
            for(Myclass m:this.in){
                if(m.val == mc.val){
                    return;
                }
            }
            this.out.add(mc);
        }

    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer,Myclass> map = new HashMap<>();
            for(int[] a:prerequisites){
                Myclass mc1 = map.get(a[0]);
                Myclass mc2 = map.get(a[1]);
                if(mc1 == null){
                    mc1 = new Myclass(a[0]);
                    map.put(a[0], mc1);
                }
                if(mc2 == null){
                    mc2 = new Myclass(a[1]);
                    map.put(a[1], mc2);
                }
                mc1.putIn(mc2);
                mc2.putOut(mc1);
            }

            int count = 0;
            boolean flag = true;
            while(!map.isEmpty() && flag) {
                flag = false;
                Set<Integer> delSet = new HashSet<>();
                for (Integer key : map.keySet()) {
                    Myclass m = map.get(key);
                    if (m.canSelect()) {
                        flag = true;
                        m.select();
                        delSet.add(key);
                        count++;
                    }
                }
                for(Integer key: delSet){
                    map.remove(key);
                }
            }

            return count <= numCourses && map.isEmpty();
        }

    }
}
