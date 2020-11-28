package easy;

import leetcode.*;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 */
public class T543 {
    public static void main(String args[]){
        T543 t = new T543();
        Object[] list = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        Tool tool = new Tool();
        TreeNode node = tool.list2Tree(list);
//        node.printTree();
        Solution s = t.new Solution();
        System.out.println(s.diameterOfBinaryTree(node));
    }

    class Solution {
        int maxWidth;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            maxWidth = 0;
            findWidth(root);
            return maxWidth;
        }

        public int findWidth(TreeNode root){
            int leftWidth = 0;
            int rightWidth = 0;
            if(root.left == null && root.right == null){
                return 0;
            }
            if(root.left != null) {
                leftWidth = findWidth(root.left) + 1;
            }
            if(root.right != null) {
                rightWidth = findWidth(root.right) + 1;
            }
            int totalWidth = leftWidth + rightWidth;
            if(totalWidth > maxWidth){
                maxWidth = totalWidth;
            }
            return Math.max(leftWidth, rightWidth);
        }
    }
}


