package binarySearchTree;

public class test {

    static class Sam
    {
        public String a;
        public Sam(String b){
            a=b;
        }
        public Sam(){};
    }

    public static void f(Sam a) {
        if (a==null){
            a=new Sam();
            a.a="a";
            return;
        }
        System.out.println(a.hashCode());
        a.a = "b";
        System.out.println(a.hashCode());
    }

    public static void f(String a) {
//        System.out.println(a.hashCode());
        a = new String("b");
        System.out.println(a.hashCode());
    }
    public static void f(StringBuilder a){
        System.out.println(a.hashCode());
        a.append("b");
        System.out.println(a.hashCode());
    }
    public static void f(int a){
        a=0;
    }

    public static void main(String[] args) {
//        Sam a=new Sam();
//        Sam a=new Sam("a");
//        a.a="a";
//        String a=null;
//        StringBuilder a=new StringBuilder();
//        a.append("c");
//        System.out.println(a.hashCode() + "----");
//        int a=1;
        Sam a=new Sam();
        f(a);
//        System.out.println(a.a.hashCode());
//        System.out.println(a.hashCode() + "----");
//        System.out.println(a.a);
//        System.out.println(a);
    }
}
