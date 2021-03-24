package binarySearchTree;

import binaryTree.BinaryTree;

public class MaximumOrMinimum {
    public static BinaryTree iterFindMaximum(BinaryTree tree   ){
        if (tree==null){
            return null;
        }
        while (tree.right!=null){
                tree=tree.right;
        }
        return tree;
    }
    public static BinaryTree findMaximum(BinaryTree tree){
        if (tree==null){
            return null;
        }
        if (tree!=null){
            if (tree.right!=null) {
              return  findMaximum(tree.right);
            }
        }
        return tree;
    }
    public static BinaryTree findMinimum(BinaryTree tree){
        if (tree==null){
            return null;
        }
        if (tree!=null){
            if (tree.left!=null) {
                return  findMaximum(tree.left);
            }
        }
        return tree;
    }
    public static BinaryTree iterFindMinimum(BinaryTree tree   ){
        if (tree==null){
            return null;
        }
        while (tree.left!=null){
                tree=tree.left;
        }
        return tree;
    }
}
