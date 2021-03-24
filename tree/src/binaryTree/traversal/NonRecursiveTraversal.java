package binaryTree.traversal;

import binaryTree.BinaryTree;

import javax.swing.*;
import java.util.Stack;

public class NonRecursiveTraversal {
    public  void PreOrderTraversal(BinaryTree tree){
        Stack<BinaryTree> stack=new Stack<>();
        BinaryTree t=tree;
        while (t!=null||!stack.empty()){
            while (t!=null){
                stack.push(t);
                t=t.left;
            }
            if (!stack.empty()){
                t= stack.pop();
                System.out.println(t.data);
                t=t.right;
            }
        }


    }
}
