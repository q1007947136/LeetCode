package medium;

import leetcode.*;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class T26 {

    public static void main(String args[]){

        T26 t = new T26();
        Solution s = t.new Solution();
        Tool tool = new Tool();
        /**
         * [5,4,1,null,1,null,4,2,null,2,null]
         */
        Object[] arr = {5,4,1,null,1,null,4,2,null,2,null};
        TreeNode root = tool.list2Tree(arr);
        System.out.println(s.isSymmetric(root));
    }

    class Solution {
//        public boolean isSymmetric(TreeNode root) {
//            if(root == null){
//                return false;
//            }
//            TreeNode[] newArr = {root};
//            return recursion(newArr);
//        }
//
//        public boolean recursion(TreeNode[] arr){
//            TreeNode[] newArr = new TreeNode[arr.length * 2];
//            boolean flag = true;
//            for(int i = 0;i<arr.length;i++){
//                if(i <= arr.length / 2){
//                    if(arr[i] == null){
//                        if(arr[arr.length - 1 - i] != null) {
//                            return false;
//                        }
//                    }else if(arr[arr.length - 1 - i] == null){
//                        return false;
//                    }else if(arr[i].val != arr[arr.length - 1 - i].val){
//                        return false;
//                    }
//                }
//                if(arr[i] == null){
//                    newArr[i*2] = null;
//                    newArr[i*2 + 1] = null;
//                }else {
//                    if (arr[i].left != null || arr[i].right != null) {
//                        flag = false;
//                    }
//                    newArr[i * 2] = arr[i].left;
//                    newArr[i * 2 + 1] = arr[i].right;
//                }
//            }
//            return flag || recursion(newArr);
//
//        }

        public boolean isSymmetric(TreeNode root) {
            return root == null || recursion(root.left, root.right);
        }

        public boolean recursion(TreeNode left, TreeNode right){
            if(left == null && right == null){
                return true;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            return recursion(left.left, right.right) && recursion(left.right, right.left);
        }

    }
}
