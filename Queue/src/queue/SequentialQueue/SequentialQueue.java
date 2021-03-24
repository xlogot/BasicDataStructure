package queue.SequentialQueue;

//环形顺序存储队列，通过mod最大数进行设计
public class SequentialQueue {
    private int size;
    int[] dataStorage;

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    int front=-1,rear=-1;
    SequentialQueue(int maxSize){
        size=maxSize;
        dataStorage=new  int[maxSize];
    }
    public void InQueue(int item) throws Exception {
        //队列加一个数，rear加一个.
        if ((rear+1)%size==front) throw  new  Exception("queue is full");
        rear=(rear+1)%size;
        dataStorage[rear]=item;
    }
    public int DeQueue() throws Exception {
        //代码流程大概记住第一个
        if ((front+1)%size==rear) throw new  Exception("queue is empty");
        front=(front+1)%size;
        return dataStorage[front];
    }


}
