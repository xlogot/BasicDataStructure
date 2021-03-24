package StaticSearch.binarySearch;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Implement{

//    public  int seatchItem(int[] a,int item){
//        var sortedArrays=quickSort(a,0,a.length-1);
//        var retuenedIndex=searchByBinarySearch(sortedArrays,item,0,a.length-1 );
//        //在排好序的数组返回的下标的情况下，对原数组进行锁定。
//
//    }
    public  int searchByBinarySearch(int[] a,int item,int left,int right){
        //二分查找,要求数据需要有序存放
        var mid=(right+left)/2;
        int c=-1;//返回的下标
        if (left>right) return -1;//判断没有找到这个数，因为left，right越界了
//        if (left+1==right){
//            /*判断不存在的值，不存在的值一定会落在相邻两个元素之间，
//            此外相邻元素的数值一样的话也可能会这样，因此需要区分开来。
//            这段可以不需要了。
//            如果递归中没有mid-1，而是mid则开启此方法，但是没有检测有效性*/
//            if (item!=a[left]&&item!=a[right]) return -1;
//        }
        if (a[mid]==item){
            return mid;
        }else   if (item<a[mid]){
            c=searchByBinarySearch(a,item,left,mid-1/*这里必须要这么做，否则不能判定没有找到这个数，因为mid-1可以判定left是否比right大*/ );
        }else   if (item>a[mid]){
            c=searchByBinarySearch(a,item,mid+1,right);
        }
        return  c;
    }
}
