
import java.util.*;
public class Test25{
 
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int[] brr=new int[N];
        for(int i=0;i<N;i++){
            brr[i]=sc.nextInt();
        }
        int tag=0;
        for(int i=0;i<N;i++){
            if(brr[i]>brr[i+1]){
                tag=i+1;
                break;
            }
        }
        String str="Insertion Sort";
        for(int i=tag;i<N;i++){
            if(arr[i]!=brr[i]){
                str="Merge Sort";
            }
        }
        if(str.equals("Insertion Sort")){
            int temp=brr[tag];
            for(int i=tag-1;i>=0;i--){
                if(brr[i]<temp){
                    brr[i+1]=temp;
                    break;
                }
                brr[i+1]=brr[i];
                if(i==0){
                    brr[i]=temp;
                }
            }
        }
        if(str.equals("Merge Sort")){
            Merge(brr,tag);
        }
        System.out.println(str);
        for(int i=0;i<N-1;i++){
            System.out.print(brr[i]+" ");
        }
        System.out.println(brr[N-1]);
    }
    static void Merge(int[] arr,int n){
        int[] brr=new int[n*2];
        int d=arr.length%(2*n);
        for(int i=0;i<arr.length-d;i+=2*n){
             
             int k=i;
             int j=i+n;
             int m=0;
             while(k<i+n||j<i+2*n){
                  
                 if(k<i+n&&j<i+2*n){
                 if(arr[k]<arr[j]){
                     brr[m]=arr[k];
                     m++;
                     k++;
                 }
                 if(arr[k]>=arr[j]){
                     brr[m]=arr[j];
                     m++;
                     j++;
                 }
                 }
                 if(k>=i+n&&j<i+2*n){
                     brr[m]=arr[j];
                     m++;
                     j++;
                 }
                 if(j>=i+2*n&&k<i+n){
                     brr[m]=arr[k];
                     m++;
                     k++;
                 }
             }
             for(int p=0;p<2*n;p++){
                 arr[i+p]=brr[p];
             } 
        }
    }
}