package binaryTree.otherApplication;

import binaryTree.BinaryTree;

public class PostOrderGetHeight {
    public  int getTreeHeight(BinaryTree tree){//使用递归实现，按照这个想法树的高度是子树的高度加1
        int M=0,N=0;
        if (tree.right==null&&tree.left==null){//判断是否为叶结点
            return 1;
        }
        if (tree.left!=null) {
            M= getTreeHeight(tree.left);
        }
        if (tree.right!=null) {
            N = getTreeHeight(tree.right);
        }
        var Max=(M>N)? M:N;
        return Max+1;
    }
    //计算叶结点
    public void PreOrderPrintLeaves(BinaryTree tree){
        //根据前序遍历进行更改而来的，根据叶结点的特征进行判断
        if (tree!=null){
            if (tree.right==null&&tree.left==null){
                System.out.println(tree.data);
            }
            PreOrderPrintLeaves(tree.left);
            PreOrderPrintLeaves(tree.right);
        }
    }
}
