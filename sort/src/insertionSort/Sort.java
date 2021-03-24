package insertionSort;

public class Sort {
    public static void sort(int[] arrays,int length){
        for (int p=1;p<length;p++){
            var temp=arrays[p];
            int i;
            for (i=p;i>0&&arrays[i-1]>temp;i--){
                arrays[i]=arrays[i-1];
            }
            arrays[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] a={0,1,2,3};
        sort(a,a.length);
    }
}
