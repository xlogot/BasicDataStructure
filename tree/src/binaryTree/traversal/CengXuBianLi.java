package binaryTree.traversal;

import binaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CengXuBianLi {
    //二叉树的层序遍历，通过队列进行实现的。
    public static void traversal(BinaryTree tree) {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();//linkedList实现了队列接口
        BinaryTree i = tree;
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
}
