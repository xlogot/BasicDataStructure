package stack.LinkStack;
import ListNode.*;
import stack.IStack;

public class LinkedStack implements IStack {
    ListNode topNode = new ListNode();
    public boolean isEmpty(){
        return  topNode.next.equals(null);
    }
    public void push(int item){
        //在链表的根部进行栈的操作
        var node=topNode;
        var tempNode=new ListNode();
        tempNode.data=item;
        tempNode.next=node.next;
        node.next=tempNode;
    }
    public int  pop() throws Exception {
        var node=topNode;
        var result=node.next;
        if (isEmpty()) throw  new  Exception("stack is empty");
        var resultData=result.data;
        topNode.next=result.next;
        return resultData;
    }
}
