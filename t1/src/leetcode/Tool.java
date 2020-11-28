package leetcode;

import java.util.*;

public class Tool {

    public TreeNode createTree(ArrayList<TreeNode> l, Object[] arr, int index, TreeNode node) {
        ArrayList<TreeNode> newL = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            TreeNode left = null;
            TreeNode right = null;
            if (arr[index] != null) {
                left = new TreeNode((int) arr[index]);
                l.get(i).setLeft(left);
                newL.add(left);
            }
            index++;
            if (index >= arr.length) {
                return node;
            }
            if (arr[index] != null) {
                right = new TreeNode((int) arr[index]);
                l.get(i).setRight(right);
                newL.add(right);
            }
            index++;
            if (index >= arr.length) {
                return node;
            }
        }
        return createTree(newL, arr, index, node);
    }

    public TreeNode list2Tree(Object[] arr){
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode node = new TreeNode((int)arr[0]);
        if(arr.length == 1){
            return node;
        }
        list.add(node);
        return createTree(list, arr, 1, node);
    }

    // 打印列表
    public void printArrayList(ArrayList<int[]> l){
        for(int i=0;i<l.size();i++){
            int[] a = l.get(i);
            System.out.print("[");
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]);
                if(j != a.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("], ");
        }
        System.out.println();
    }

    public void printArrayList(int[][] arr){
        for(int i=0;i<arr.length;i++){
            int[] a = arr[i];
            System.out.print("[");
            for(int j=0;j<a.length;j++){
                System.out.print(a[j]);
                if(j != a.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("], ");
        }
        System.out.println();
    }

    public void printArrayList1(List<Integer> l){
        System.out.print("[");
        for(int i=0;i<l.size();i++){
            int a = l.get(i);
            System.out.print(a);
            if(i != l.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printDoubleArray(double[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printIntArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printArrayList(List<List<Integer>> l){
        for(int i=0;i<l.size();i++){
            List<Integer> a = l.get(i);
            System.out.print("[");
            for(int j=0;j<a.size();j++){
                System.out.print(a.get(j));
                if(j != a.size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("], ");
        }
        System.out.println();
    }

    public List<List<String>> arr2list(String[][] arr){
        List<List<String>> list = new ArrayList<>();
        for(String[] i:arr){
            List<String> l = new ArrayList<>();
            Collections.addAll(l, i);
            list.add(l);
        }
        return list;
    }


}
