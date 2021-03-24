package quickSort;

public class QuickSort {
    /*快速排序,注意这里传值参数的引用类型，会改变传进来的引用对象的值，在调用此方法前需要赋值一个新的对象*/
    public static int[] quickSort(int[] arrays,int p,int r){
        if (p<r){//判定边界条件
            var q=partition(arrays, p, r);
            quickSort(arrays,p,q-1 );
            quickSort(arrays,q+1,r);
        }
        return arrays;
    }
    public static int partition(int[] arrays,int p,int r){
        var x=arrays[r];//将数组中的最后一个元素，设置为主元
        var i=p-1;
        for (int j=p;j<=r-1;j++){
            if (arrays[j] <= x) {
                i=i+1;
                var temp=arrays[i];
                arrays[i]=arrays[j];
                arrays[j]=temp;
            }
        }
        var temp=arrays[i+1];
        arrays[i+1]=arrays[r];//主元进行交换到数组内。
        arrays[r]=temp;
        return i+1;
    }
}
