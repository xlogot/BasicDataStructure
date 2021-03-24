package binaryTree.serialOut;

public class OutputSerial {
    public static StringBuilder preOrderSerialOutput(String midOrder, String postOrder){
        //获取后序遍历的最后一个字符，得到根节点
        if (midOrder.equals("")){
            return null;
        }
        int s=postOrder.length();//获得序列的长度
        char t=postOrder.charAt(s-1);
        if (s==1){
            return new StringBuilder(midOrder);
        }
        //根据得到的字符，对中序遍历序列进行分割左子树和右子树
        int index=midOrder.indexOf(t);
        //
        String leftSubTreeSerial=midOrder.substring(0,index);
        String rightSubTreeSerial=midOrder.substring(index+1,s);
        //
        var a=leftSubTreeSerial.length();
        String left=postOrder.substring(0,a);
        var b=a+rightSubTreeSerial.length();
        String right=postOrder.substring(leftSubTreeSerial.length(),b);
        //
        StringBuilder result=new StringBuilder();

        result.append(t);
        //
        var u= preOrderSerialOutput(leftSubTreeSerial,left);
        if (u!=null) result.append(u);
        var v= preOrderSerialOutput(rightSubTreeSerial,right);
        if (v!=null) result.append(v);
        return result;
    }

    //后序输出
    public static StringBuilder postOrderSerialOutput(String midOrder, String preOrder){
        //判断是否为空字符串
        if (midOrder.equals("")){
            return null;
        }
        //获取前序遍历的第一个字符，得到根节点
        char t=preOrder.charAt(0);
        int s=preOrder.length();//获得序列的长度
        if (s==1){
            return new StringBuilder(midOrder);
        }
        //根据得到的字符，对中序遍历序列进行分割左子树和右子树
        int index=midOrder.indexOf(t);
        //
        String leftSubTreeSerial=midOrder.substring(0,index);
        String rightSubTreeSerial=midOrder.substring(index+1,s);
        //
        var a=leftSubTreeSerial.length();
        String left=preOrder.substring(1,a+1);
        var b=a+rightSubTreeSerial.length();
        String right=preOrder.substring(a+1,s);
        //
        StringBuilder result=new StringBuilder();
        //
        var u= postOrderSerialOutput(leftSubTreeSerial,left);
        if (u!=null) result.append(u);
        var v= postOrderSerialOutput(rightSubTreeSerial,right);
        if (v!=null) result.append(v);
        result.append(t);
        return result;
    }

    public static void main(String[] args) {
        String a="fdbeacg";
        String b="fdebgca";
        StringBuilder c= preOrderSerialOutput(a,b);//输出前序序列
        StringBuilder e=postOrderSerialOutput(a,c.toString());
        var f=e.toString().equals(b);
    }
}
