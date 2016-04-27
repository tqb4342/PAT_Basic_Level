import java.util.Scanner;
 
 
public class Test26 {
    public static void main(String[] args) {
        int n,tmp;
        String str;
char c;
        Scanner read = new Scanner(System.in);
        str = read.nextLine();
        n  = Integer.parseInt(str.split(" ")[0]);
        c = str.split(" ").clone()[1].charAt(0);
         tmp = (int) Math.round((double)n/2.0);
         for(int i=0;i<n;i++){
             System.out.print(c);
         }
         System.out.println();
         for(int i=0;i<tmp-2;i++){
             for(int j=0;j<n;j++){
                 if(j==0||j==n-1){
                     System.out.print(c);
                 }
                 else  System.out.print(" ");
             }
             System.out.println();
         }
         for(int i=0;i<n;i++){
             System.out.print(c);
         }
         System.out.println();
    }
}