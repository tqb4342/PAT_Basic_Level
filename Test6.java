import java.util.Scanner;

/*
 * 题目描述
		正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。
		
		
		
		现给定A、DA、B、DB，请编写程序计算PA + PB。
		
		输入描述:
		输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 1010。
		
		
		输出描述:
		在一行中输出PA + PB的值。
 * 
 * 
 */


public class Test6 {
	public static void main(String[] args) {
		String A,B,str ;
		char Da,Db;
		int a=0,b=0,suma = 0,sumb = 0;
		Scanner read = new Scanner(System.in);
		str = read.nextLine();
		A = str.split(" ")[0]; Da = str.split(" ")[1].toCharArray()[0];
		B = str.split(" ")[2]; Db = str.split(" ")[3].toCharArray()[0];
		//System.out.println(A+" "+Da+" "+B+" "+Db);
		for(int i = 0;i<A.length();i++){
			if(A.charAt(i)==Da) a++;
		}
		for(int i = 0;i<B.length();i++){
			if(B.charAt(i)==Db) b++;
		}
		for(int i=a-1;i>=0;i--){
			suma += (((int)Da-48)*Math.pow(10, i));
		}
		for(int i=b-1;i>=0;i--){
			sumb += (((int)Db-48)*Math.pow(10, i));
		}
		System.out.println(suma+sumb);
		
	}
}
