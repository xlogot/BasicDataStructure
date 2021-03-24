package bubbleSort;


import java.util.function.IntBinaryOperator;

public class Sort {
    public  static void bubbleSort(int[] arrays,int length){
        for (int p=length-1;p>=0;p--){
            boolean flag=false;
            for (int i = 0; i < p; i++) {
                if (arrays[i]>arrays[i+1]){
                    var temp=arrays[i];
                    arrays[i]=arrays[i+1];
                    arrays[i+1]=temp;
                    flag=true;
                }
            }
            if (flag==false) break;
        }
    }
}
