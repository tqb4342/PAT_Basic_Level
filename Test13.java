import java.util.*;
public class Test13 {
  
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=sc.nextInt();
        }
        int i=0;
        for(i=1;i<10;i++){
            if(arr[i]!=0){
                  
                System.out.print(i);
                arr[i]--;
                break;
            }
        }
        if(arr[0]!=0){
            while(arr[0]>0){
            System.out.print(0);
            arr[0]--;
            }
        }
        while(i<10){
           if(arr[i]!=0){
               while(arr[i]>0){
               System.out.print(i);
               arr[i]--;
               }
           }
           i++;
        }
    }
}