package leetcode;

import java.util.ArrayList;

public class TreeNode {
    public void setVal(int val) {
        this.val = val;
    }

    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    TreeNode(int x){
        this.val = x;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void printTree(){
        System.out.print(this.val + " ");
        if(this.left != null){
            this.left.printTree();
        }
        if(this.right != null){
            this.right.printTree();
        }
    }


}
