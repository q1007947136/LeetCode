package easy;

import leetcode.Tool;
import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 */
public class T530 {

    public static void main(String args[]) {
        T530 t = new T530();
        Tool tool = new Tool();
        Object[] arr = {0,null,2236,1277,2776,519};
        TreeNode root = tool.list2Tree(arr);
        System.out.println(t.getMinimumDifference(root));
    }

    int result = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        traverse(root, list);
        return result;
    }

    public void traverse(TreeNode root, List<Integer> list){
        if(root.left!=null){
            traverse(root.left, list);
        }
        if(list.size() > 0) {
            result = Math.min(result, Math.abs(list.get(list.size() - 1) - root.val));
        }
        list.add(root.val);
        if(root.right!=null){
            traverse(root.right, list);
        }
    }

}
