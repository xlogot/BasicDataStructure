package AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    public int data;
    public AVLTree left;
    public AVLTree right;
    int height;

    public int getHeight() {
//        if (left == null && right == null) return 0;
        return height;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static AVLTree singleLeftRotation(AVLTree a) {
        //LL旋转
        AVLTree b = a.left;
        a.left = b.right;
        b.right = a;
        a.height = (a.left == null && a.right == null) ? 0 : (a.left != null && a.right == null) ? 1 : (a.right != null && a.left == null) ? 1 : max(a.left.getHeight(), a.right.getHeight()) + 1;
        b.height = (b.left == null && b.right == null) ? 0 : (b.left != null && b.right == null) ? 1 : (b.right != null && b.left == null) ? 1 : max(b.left.getHeight(), b.right.getHeight()) + 1;
        return b;
    }

    public static AVLTree singleRightRotation(AVLTree a) {
        //RR旋转
        AVLTree b = a.right;
        a.right = b.left;
        b.left = a;
        a.height = (a.left == null && a.right == null) ? 0 : (a.left != null && a.right == null) ? 1 : (a.right != null && a.left == null) ? 1 : max(a.left.getHeight(), a.right.getHeight()) + 1;
        b.height = (b.left == null && b.right == null) ? 0 : (b.left != null && b.right == null) ? 1 : (b.right != null && b.left == null) ? 1 : max(b.left.getHeight(), b.right.getHeight()) + 1;
        return b;
    }

    public static AVLTree doubleLeftRightRotation(AVLTree a) {
        //LR旋转
        //将A、B与C做两次单选，返回新的根节点C

        //第一次先B与C进行右单旋。转换后C为A的左节点
        a.left = singleRightRotation(a.left);
        //最后进行A与C进行左单旋。最后返回LR节点、
        //可以不用考虑高度的问题了。
        return singleLeftRotation(a);
    }

    public static AVLTree doubleRightLeftRotation(AVLTree a) {
        a.right = singleLeftRotation(a.right);
        return singleRightRotation(a);
    }

    public static AVLTree insert(AVLTree tree, int item) {
        if (tree == null) {
            tree = new AVLTree();
            tree.data = item;
            tree.height = 0;
            tree.left = tree.right = null;
            return tree;
        } else if (item < tree.data) {
            var temp = insert(tree.left, item);
            tree.left = temp;
            tree.height = (tree.left == null && tree.right == null)
                    ? 0 : (tree.left != null && tree.right == null)
                    ? 1 : (tree.right != null && tree.left == null)
                    ? 1 : max(tree.left.getHeight(), tree.right.getHeight()) + 1;
            //判断是否需要进行整理
            if (tree.left == null && tree.right == null); //无子树
            else if (tree.left != null && tree.right == null)//只有左子树
            {
                if (tree.left.left!= null)
                    tree=singleLeftRotation(tree);
                else if (tree.left.right!= null)
                    tree = doubleLeftRightRotation(tree);
            }
            else {
                if (tree.left.getHeight() - tree.right.getHeight() == 2) {
                    if (item < tree.left.data) {
                        tree = singleLeftRotation(tree);
                    } else {
                        tree = doubleLeftRightRotation(tree);
                    }
                }
            }
        } else if (item > tree.data) {
            var temp = insert(tree.right, item);
            tree.right = temp;
            tree.height = (tree.left == null && tree.right == null)
                    ? 0 : (tree.left != null && tree.right == null)
                    ? 1 : (tree.right != null && tree.left == null)
                    ? 1 : max(tree.left.getHeight(), tree.right.getHeight()) + 1;
            if (tree.left == null && tree.right == null);//无子树
            else if (tree.right != null && tree.left == null)//只有右子树
            {
                if (tree.right.left!=null){
                    tree=doubleRightLeftRotation(tree);
                }else if (tree.right.right!=null){
                    tree=singleRightRotation(tree);
                }
            } else {
                if ((tree.left.getHeight() - tree.right.getHeight())== 2) {
                    if (item < tree.right.data) {
                        tree = singleRightRotation(tree);
                    } else {
                        tree = doubleRightLeftRotation(tree);
                    }
                }
            }
        }
        tree.height = (tree.left == null && tree.right == null)
                ? 0 : (tree.left != null && tree.right == null)
                ? 1 : (tree.right != null && tree.left == null)
                ? 1 : max(tree.left.getHeight(), tree.right.getHeight()) + 1;
        return tree;
    }

    public static void traversal(AVLTree tree) {//层序遍历，检验有效性
        Queue<AVLTree> queue = new LinkedList<AVLTree>();//linkedList实现了队列接口
        AVLTree i = tree;
        queue.add(i);
        while (!queue.isEmpty()) {//结束条件是队列是不是空的
            var t = queue.remove();
            System.out.println(t.data);
            if (t.left != null)
                queue.add(t.left);
            if (t.right != null)
                queue.add(t.right);
        }

    }

    public static void main(String[] args) {
        AVLTree a = null;

        a = insert(a, 8);
        a = insert(a, 9);
        a = insert(a, 5);
        a = insert(a, 6);
        a = insert(a, 11);
        a = insert(a, 5);
        a = insert(a, 12);
        a = insert(a, 2);
        a = insert(a, 7);
        a = insert(a, 13);
        a = insert(a, 1);
        a = insert(a, 6);
        a = insert(a, 9);
        a = insert(a, 10);
        traversal(a);

    }
}

