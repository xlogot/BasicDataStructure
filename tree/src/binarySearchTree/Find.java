package binarySearchTree;


import binaryTree.BinaryTree;

public class Find {
    public static BinaryTree find(int data, BinaryTree tree) {
        if (tree == null) {
            return null;
        }
        if (data < tree.data) {
            return find(data, tree.left);
        } else if (data > tree.data) {
            return find(data, tree.right);
        } else
            return tree;
    }
    public static BinaryTree iterFind(int data,BinaryTree tree) {
        if (tree==null){
            return null;
        }
        while (tree.data!=data){
            if (data<tree.data){
                tree=tree.left;
            }
            else if (data>tree.data){
                tree=tree.right;
            }
        }
        return tree;
    }
}
