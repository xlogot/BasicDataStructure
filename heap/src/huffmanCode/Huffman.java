package huffmanCode;

import minimum.MinimumHeap;

public class Huffman extends MinimumHeap {
    int weight;
    Huffman left,right;

    //这个方法的输入参数就是一个已经整理好的最小堆
    //根据之前实现的堆，不好实现各种操作
    public void  buildHuffmanCode(MinimumHeap h){
        int i;
        Huffman t;
        for (i=1;i<h.size;i++){//需要做size-1次合并
            left=new Huffman();
            left.weight=h.deleteMinimun();
            right=new Huffman();
            right.weight=h.deleteMinimun();
            this.weight=left.weight+right.weight;
            try {
                h.insert(this.weight);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

