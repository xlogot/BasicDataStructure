package main;




public class Main {
    public static void main(String[] args) throws Exception {
//        Stack a=new Stack();

//        System.out.println("aaa");
//        int[] b=new int[11];
//        int c=b.length;
//        String str1="aaa";
//        str1.length();
//        //基本类型的包装类
//        Integer da= 7;
//        da.toString();

//        IStack stack=new SequentialStack(11);
//        stack.push(10);
//        stack.push(11);
//        stack.push(11);
//        stack.push(11);
//        var d=stack.pop();

//        var a=new PolynomialAdd();
//        a.test();
//        int i=1>>>1;

        //快速查找代码测试
//        int[] test1=new int[]{1,4,3,11,5,6,78,4,645,6};
//        int i=0;
//        int j=1;
//        int k=i+j;
//        String s="ssss";

//        s>>>=3;
//        s[3]='x';
//        int c=s.length();
//        s=s+1;
//        var test = test1.clone();
//        Implement a=new Implement();
////        a.quickSort(test,0,test.length-1);
//        var b=a.searchByBinarySearch(test,7,0,test.length-1);
//        System.out.println(b);
//        int[] n1={2};
//        int[] n2={1,3,4};
//        int num1Length=n1.length;
//        int num2Length=n2.length;
//        boolean a=num1Length%2==1 ? false:true;
//        var a=findMedianSortedArrays(n1,n2);
//        int[] temp=new int[num1Length+num2Length];
//        int i=10;
        int num=50;
        num=num++*2;
        System.out.println(num);

//        int i1=i++ + ++i;
    }

    int add(int a,int b){
        return  a+b;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length=nums1.length;
        int num2Length=nums2.length;

        int length=num2Length+num1Length;
        int mid=length/2;
        boolean isJiShu=length%2==1 ? true:false;

        int i=0,j=0,k=0;
        int[] temp=new int[num1Length+num2Length];
        if (num1Length==0){
            temp=nums2;
        }else   if (num2Length==0){
            temp=nums1;
        }
        while(i<num1Length&&j<num2Length){
            if(nums1[i]<nums2[j]){
                temp[k]=nums1[i];
                k++;i++;
            }else{
                temp[k]=nums2[j];
                k++;j++;
            }
        }

        if(i<num1Length){
            while(i<num1Length){
                temp[k]=nums1[i];
                k++;i++;
            }
        }else{
            while(j<num2Length){
                temp[k]=nums2[j];
                k++;j++;
            }
        }
        if(isJiShu==true){
            return temp[mid];
        }else{
            double a=temp[mid];
            double b=temp[mid-1];
            return (a+b)/2;
        }
    }
}
