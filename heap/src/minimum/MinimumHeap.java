package minimum;

public class MinimumHeap {
    int[] elements;//可以使用arraylist进行实现
    public int size;
    int capacity;

    public MinimumHeap(int maxSize) {
        elements =new int[maxSize];
        size=0;
        capacity=maxSize;
        elements[0]=Integer.MIN_VALUE;
    }

    public MinimumHeap() {}

    public void insert(int item) throws Exception {
        int i;
        if (isFull()){
            throw new Exception("full");
        }
        i=++size;
        for (;elements[i/2]>item;i/=2){//与哨兵比较退出这个循环
            elements[i]=elements[i/2];
        }
        elements[i]=item;
    }

    private boolean isFull() {
        return size==capacity;
    }

    public int deleteMinimun(){
        int parent,child;
        int mini=elements[1];
        int temp=elements[size];

        for (parent=1;parent*2<=size/*边界条件*/;parent=child){
            child=parent*2;
            if ((child!=size/*确定不是最后一个元素*/)&&(elements[child+1]<elements[child])) child++;
            if (temp<elements[child]) break;
            else{
                elements[parent]=elements[child];//父节点和子节点交换
            }
        }
        elements[parent]=temp;
        size--;
        return mini;
    }

    public void buildMinimumHeap(int[] arrays){
        elements=new int[1000];
        elements[0]=Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            elements[i+1]=arrays[i];
        }
        size=arrays.length;
        capacity=elements.length;
        int i;
        //从最后一个节点的父节点开始整理各个子堆。迭代地进行整理各个堆
        for (i=size/2;i>0;i--) percDown(i);

    }

    private void percDown(int p) {
        int parent,child;
        int x;
        x=elements[p];
        //和删除最大节点类似
        for (parent=p;parent*2<=size;parent=child){
            child=parent*2;
            if ((child!=size)&&(elements[child+1]<elements[child])) child++;
            if (x<elements[child]) break;
                /*值得注意的是，这里仅仅只是将子节点的值赋给了父节点，并没有实现交换它们值
                 * 直到退出循环时可以将p值赋给
                 * 需要注意的是，仅仅交换了子节点比父节点大的值，不需要将其它值进行交换，避免额外的操作
                 * */
            else elements[parent]=elements[child];
            //如果交换条件始终得不到满足，循环到叶结点时，就会退出。将p值赋给最终属于它的位置
        }
        elements[parent]=x;
    }
}
