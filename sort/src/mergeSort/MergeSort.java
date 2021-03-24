package mergeSort;

public class MergeSort {
    //归并排序，一样的参数类型是传值参数的引用类型，进行划分，划分到数组具有天然顺序的性质为止，也就是说一个数组只有一个数组
    //这里的temp是和arrys数组一样长度的任意数组。
    public static void mergeSort(int[] arrays,/*int [] temp,*/int left,int right){
//        arrays.length;
        if (left>=right){//判断边界条件
            return;
        }
        int mid=(left+right)/2;
        mergeSort(arrays,/*temp,*/left,mid);
        mergeSort(arrays,/*temp,*/mid+1,right);
        merge(arrays,/*temp,*/left,mid,right);
        return;
    }

    private static void merge(int[] arrays,/*int[] temp,*/ int left, int mid, int right) {
        //复制数组，进行初始化
        int[] temp=arrays.clone();
        //使用参数传递进来的数组，可减少存储空间分配时产生的浪费。
        int i=left,j=mid+1,k=0;
        //两个数组进行比较
        while (i<=mid&&j<=right){
            if (temp[i]<=temp[j]){
                arrays[left+k]=temp[i];
                k++;
                i++;
            }
            else{
                arrays[left+k]=temp[j];
                k++;
                j++;
            }
        }
        //比较完后，有空余，进行添加
        if (i<=mid){
            while (i<=mid){
                arrays[left+k]=temp[i];
                k++;
                i++;
            }
        }else{
            while (j<=left){
                arrays[left+k]=temp[j];
                k++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a={4,2,5,3,1,6};
        A a1=new A();
        mergeSort(a,/*a.clone(),*/0,a.length-1);
    }
    static class A{
        int[] a;
    }
}
