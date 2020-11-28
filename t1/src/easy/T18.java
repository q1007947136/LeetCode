package easy;

import leetcode.Tool;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 399. 除法求值
 * 给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

 输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

 todo 可以优化
 */
public class T18 {

    public static void main(String args[]){
        T18 t = new T18();
        Solution s = t.new Solution();
        Tool tool = new Tool();
        String[][] a1 = {{"a","b"},{"b","c"}};
        double[] values = {2.0,3.0};
        String[][] a2 = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        List<List<String>> equations = tool.arr2list(a1);
        List<List<String>> queries = tool.arr2list(a2);
        tool.printDoubleArray(s.calcEquation(equations, values, queries));
    }


//    class Solution{
//
//        Map<String, List<List<String>>> map = new HashMap<>();
//        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//            setMap(equations, values);
//            double[] results = new double[queries.size()];
//            for(int i=0;i<queries.size();i++){
//                String v1 = queries.get(i).get(0);
//                String v2 = queries.get(i).get(1);
//                double result = findValue(v1,v2);
//                results[i] = result;
//            }
//            return results;
//        }
//
//        public void setMap(List<List<String>> equations, double[] values){
//            for(int i=0;i<equations.size();i++){
//                List<String> list = equations.get(i);
//                String v1 = list.get(0);
//                String v2 = list.get(1);
//                String[] arr = {v2, Double.toString(values[i])};
//                List<String> l1 = new ArrayList<>();
//                Collections.addAll(l1, arr);
//                List<List<String>> list1 = map.get(v1);
//                if(list1 == null) {
//                    list1 = new ArrayList<>();
//                    list1.add(l1);
//                    map.put(v1, list1);
//                }else{
//                    if(list1.indexOf(l1) == -1){
//                        list1.add(l1);
//                    }
//                }
//            }
//        }
//
//        public double findValue(String v1, String v2){
//            List<List<String>> list = map.get(v1);
//            if(list != null){
//                for(List<String> l:list){
////                    List<String> l = list.get(i);
//                    if(l.get(0).equals(v2)){
//                        return Double.valueOf(l.get(1));
//                    }else{
//                        double b = findValue(l.get(0), v2);
//                        if(b != -1) {
//                            return b * Double.valueOf(l.get(1));
//                        }
//                    }
//                }
//            }else{
//                list = map.get(v2);
//                if(list != null){
//                    for(List<String> l:list){
////                        List<String> l = list.get(i);
//                        if(l.get(0).equals(v2)){
//                            return 1 / Double.valueOf(l.get(1));
//                        }else{
//                            double b = findValue(l.get(0), v2);
//                            if(b != -1) {
//                                return b * Double.valueOf(l.get(1));
//                            }
//                        }
//                    }
//                }
//            }
//            return -1;
//        }
//    }

    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] results = new double[queries.size()];
            for(int i=0;i<queries.size();i++){
                String v1 = queries.get(i).get(0);
                String v2 = queries.get(i).get(1);
                List<Double> valueList = Arrays.stream(values).boxed().collect(Collectors.toList());
                double result = findValue(v1, v2, equations, valueList);
                results[i] = result;
            }
            return results;
        }

        public double findValue(String s1, String s2, List<List<String>> equations, List<Double> values){
            for(int i=0;i<equations.size();i++){
                String v1 = equations.get(i).get(0);
                String v2 = equations.get(i).get(1);
                if(s1.equals(v1)){
                    if(s1.equals(s2)){
                        return 1;
                    }
                    double b = values.get(i);
                    if(s2.equals(v2)){
                        return b;
                    }else{
                        List<List<String>> cpL = new ArrayList<>();
                        cpL.addAll(equations);
                        cpL.remove(i);
                        List<Double> cpV = new ArrayList<>();
                        cpV.addAll(values);
                        cpV.remove(i);
                        double b2 = findValue(v2, s2, cpL, cpV);
                        if(b2 != -1){
                            return b * b2;
                        }
                    }
                }else if(s1.equals(v2)){
                    if(s1.equals(s2)){
                        return 1;
                    }
                    double b = 1 / values.get(i);
                    if(s2.equals(v1)){
                        return b;
                    }else{
                        List<List<String>> cpL = new ArrayList<>();
                        cpL.addAll(equations);
                        cpL.remove(i);
                        List<Double> cpV = new ArrayList<>();
                        cpV.addAll(values);
                        cpV.remove(i);
                        double b2 = findValue(v1, s2, cpL, cpV);
                        if(b2 != -1){
                            return b * b2;
                        }
                    }
                }
            }
            return -1;
        }

    }


//    class Solution {
//        /**
//         * key : 当前节点
//         * value : 其父节点
//         */
//        private Map<String, String> parents = new HashMap<>();
//        /**
//         * key : 当前节点
//         * value : 父节点/当前节点
//         */
//        private Map<String, Double> values = new HashMap<>();
//
//        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//            for (int i = 0; i < equations.size(); i++) {
//                union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
//            }
//            double[] result = new double[queries.size()];
//            for (int i = 0; i < queries.size(); i++) {
//                String e = queries.get(i).get(0);
//                String q = queries.get(i).get(1);
//                if (!(parents.containsKey(e) && parents.containsKey(q))) {
//                    result[i] = -1;
//                    continue;
//                }
//                if (e.equals(q)) {
//                    result[i] = 1;
//                    continue;
//                }
//                String r1 = root(e);
//                String r2 = root(q);
//                if (!r1.equals(r2)) {
//                    // 如果两者不相等，说明两个节点是不连通的
//                    result[i] = -1;
//                    continue;
//                }
//                result[i] = pm(q)/pm(e);
//            }
//            return result;
//        }
//
//        private void union(String parent, String child, double value) {
//            add(parent);
//            add(child);
//            String r1 = root(parent);
//            String r2 = root(child);
//            if (!r1.equals(r2)) {
//                parents.put(r2, r1);
//                values.put(r2, value * (pm(parent)/pm(child)));
//            }
//        }
//        private void add(String x) {
//            if (!parents.containsKey(x)) {
//                parents.put(x, x);
//                values.put(x, 1.0);
//            }
//        }
//
//
//
//        /**
//         * 找到x的根节点
//         */
//        private String root(String x) {
//            while (!parents.get(x).equals(x)) {
//                x = parents.get(x);
//            }
//            return x;
//        }
//
//
//        /**
//         * 循环的pm函数
//         */
//        private double pm(String x) {
//            double v = 1;
//            while (!parents.get(x).equals(x)) {
//                v*= values.get(x);
//                x = parents.get(x);
//            }
//            return v;
//        }
//
////    /**
////     * 递归的pm函数
////     * @param x
////     * @return
////     */
////    private double pm(String x){
////        return parents.get(x).equals(x)?1:values.get(x)*pm(parents.get(x));
////    }
//
//    }
}
