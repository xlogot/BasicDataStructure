package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class t11 {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> it=list.iterator();
        while (it.hasNext()){
            var str=(String)it.next();
            System.out.println(str);
        }

    }

}//9
