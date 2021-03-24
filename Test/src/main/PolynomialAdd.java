package main;

public class PolynomialAdd {

    public void test() {
        LinkNode a=new LinkNode(4,3);
        a.AddNode(a,2,10);

        LinkNode b=new LinkNode(2,3);
        b.AddNode(b,1,1);
        b.AddNode(b,0,1);

        var c=add(a,b);
    }

    public LinkNode add(LinkNode a,LinkNode b){
        var c=new LinkNode();

        if (a==null&&b==null){
            return null;
        }
        if (a==null) {
            c = b;
            c.next=add(null ,b.next);
        }else   if (b==null){
            c=a;
            c.next=add(a.next,null);
        }
        else {
            if (a.index == b.index) {
                c.index=a.index;
                c.coefficient = a.coefficient + b.coefficient;
                c.next= add(a.next, b.next);
            } else if (a.index > b.index) {
                c = a;
                c.next=add(a.next,b);
            } else {
                c = b;
                c.next=add(a,b.next);
            }
        }
        return c;

    }
}
class LinkNode{
    int index;
    int coefficient;
    LinkNode next;

    public LinkNode(){};
    public LinkNode(int i,int c){
        index=i;
        coefficient=c;
    }

    public LinkNode AddNode(LinkNode node,int index,int coefficient)
    {
        if (node.next == null)
        {
            node.next = new LinkNode(index,coefficient);
            return node;
        }
        AddNode(node.next, index,coefficient);
        return node;
    }
}
