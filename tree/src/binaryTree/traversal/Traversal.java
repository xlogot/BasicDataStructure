package binaryTree.traversal;

import binaryTree.BinaryTree;

public class Traversal {
    public void PreOrderTraversal(BinaryTree tree){
        if (tree!=null){
            System.out.println(tree.data);
            PreOrderTraversal(tree.left);
            PreOrderTraversal(tree.right);
        }
    }
    public void MidOrderTraversal(BinaryTree tree){
        if (tree!=null){
            MidOrderTraversal(tree.left);
            System.out.println(tree.data);
            MidOrderTraversal(tree.right);
        }
    }
    public void PostOrderTraversal(BinaryTree tree){
        if (tree!=null){
            System.out.println(tree.data);
            PostOrderTraversal(tree.left);
            PostOrderTraversal(tree.right);
        }
    }
}
