import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Test12 {
 
    public static void main(String[] args) {
        double A,B,C;
        int d,len,c;
        List<Integer> list = new ArrayList<Integer>();
        Scanner read = new Scanner(System.in);
        A = read.nextDouble();
        B = read.nextDouble();
        d = read.nextInt();
        C = A + B;
        while(C!=0){
            list.add((int)C%d);
            C = (int)C/d;
        }
        len = list.size();
        c = len-1;
        int[] data = new int[len];
        for(int j:list){
            data[c--] = j;
        }
        for(int i=0;i<len;i++){
            System.out.print(data[i]);
        }
        System.out.println();
    }
 
}