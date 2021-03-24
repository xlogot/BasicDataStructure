package StaticSearch.SequentialSearch;

public class SequentialSearch {
    public int searchByArrays(int[] a, int item){
        //返回的数组下标，使用哨兵来确定数组边界
        int i;
        a[0]=item;
        for (i  = a.length;  a[i]!=item ; i--) ;
        return i;
    }
}
