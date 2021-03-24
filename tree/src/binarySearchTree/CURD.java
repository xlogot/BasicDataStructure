package binarySearchTree;


import binaryTree.BinaryTree;
import binaryTree.traversal.CengXuBianLi;

public class CURD {

    public static BinaryTree /*void*/   insert(int data, BinaryTree tree){
        //整个过程有点类似与find操作
        if (tree==null){

            //如果树为空，生成并返回一个节点的二叉搜索树
            tree=new BinaryTree();
            tree.data=data;
            tree.left=tree.right=null;
        }
        else if(data<tree.data){
            //递归插入左子树
            tree.left=insert(data,tree.left);
        }else if (data>tree.data){
            //递归插入右子树
            tree.right=insert(data,tree.right);
        }
        return tree;
    }

    public static BinaryTree delete(int data,BinaryTree tree) {
        if (data < tree.data) {
            tree.left= delete(data, tree.left);//传回null值时，java不会将其删除。
        } else if (data > tree.data) {
            tree.right= delete(data, tree.right);
        } else {
            if (tree.left != null && tree.right != null) {//先检测删除的节点是否由左右子树，这样，之后的别的有一个或者没有子树的条件比较好写
                var tmp=MaximumOrMinimum.findMinimum(tree.right);//找出右子树中最小的节点替换，并删除右子树中最小的节点
                //此外，还用左子树中最大的结点，进行替换，实现原理同理。
                tree.data=tmp.data;
                tree.right= delete(tmp.data,tree.right);//删除这个最小的节点同样的也是进行，递归删除。
            }else{
                var tmp=tree;
                if (tree.left!=null){//判断是否只有左子树
                    tree=tree.left;
                }else if (tree.right!=null){//是否只有右子树
                    tree=tree.right;
                }else{//同时没有左子树和右子树
                    tree=null;
                }
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        BinaryTree a=null;
        //a为null时需要重新进行引用，之后就不要了，因为参数类型为值类型的引用类型。
        a=insert(6,a);
        insert(4,a);
        insert(5,a);
        insert(8,a);
        insert(9,a);
        insert(10,a);
        insert(1,a);
        insert(7,a);
//        var b= MaximumOrMinimum.findMaximum(a);
        //删除一个节点，并用层序遍历检测正确性
//        delete(10,a);
//        CengXuBianLi.traversal(a);



    }
}
