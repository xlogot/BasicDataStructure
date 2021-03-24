package quickSort;

import javax.swing.*;
import java.util.Stack;

public class QuickSort1 {
    static int partition(int[] data,int start,int end){
        int pivotIndex=getMidNumberIndex(data,start,end);//选择start, end, mid的中位数做主元.
        int pivot=data[pivotIndex];
        exchangePivotToTail(data,end,pivotIndex);
        int smallIndex=start;
        for (int i=start;i<end;i++) {
            if (data[i] < pivot) {
                exchange(data, smallIndex, i);
                smallIndex++;
            }
        }
        exchange(data,smallIndex,end);
        return smallIndex;
    }

    private static void exchange(int[] data, int smallIndex, int i) {
        if (smallIndex==i)return;
        int temp=data[i];
        data[i]=data[smallIndex];
        data[smallIndex]=temp;
    }

    private static void exchangePivotToTail(int[] data, int end, int pivotIndex) {
        int temp=data[end];
        data[end]=data[pivotIndex];
        data[pivotIndex]=temp;
    }

    private static int getMidNumberIndex(int[] data,int start,int end) {
        return end;
    }

    static void  quickSort(int[] data,int start,int end){
        if (data==null) return;
        int index = partition(data, start,end);
        if (index>start) quickSort(data,start,index-1);
        if (index<end) quickSort(data,index+1,end);
    }

    public static void main(String[] args) {
        int[] a= {7, 8, 1, 3, 4};
        quickSort(a,0,a.length-1);
    }
}
