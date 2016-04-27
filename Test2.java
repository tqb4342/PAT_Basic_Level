import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class Test2 {
	
	/*
	 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
	 * 
		A1 = 能被5整除的数字中所有偶数的和；
		
		A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
		
		A3 = 被5除后余2的数字的个数；
		
		A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
		
		A5 = 被5除后余4的数字中最大数字。
	 * 
	 * 输入描述:
		每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
		
		
		输出描述:
		对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
		
		若其中某一类数字不存在，则在相应位置输出“N”。
	 */

	@SuppressWarnings("null")
	public static void main(String[] args) {
		int n,N = 5;
		int[] sum = new int[5];
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		n = read.nextInt();
		int[] arr = new int[n];
		 DecimalFormat df = new DecimalFormat ("#.0");
		ArrayList<Integer>[] list = new ArrayList[5];
		for(int i=0;i<5;i++){
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<n;i++){
			arr[i] = read.nextInt();
			if(arr[i]%5==0) list[0].add(arr[i]);
			if(arr[i]%5==1) list[1].add(arr[i]);
			if(arr[i]%5==2) list[2].add(arr[i]);
			if(arr[i]%5==3) list[3].add(arr[i]);
			if(arr[i]%5==4) list[4].add(arr[i]);
		}
		int j=0;
		for(int i=0;i<5;i++){
			for(int d:list[i]){
				if(d%2==0&&i==0) sum[i] += d;
				if(i==1){
					if(j%2==0) sum[i] += d;
					else sum[i] -= d;
					j++;
				}
				if(i==2){
					sum[i] = list[i].size();
				}
				if(i==3){
					sum[i] += d;
				}
				if(i==4){
					//sum[i] = d;
					if(d>sum[i]) sum[i] = d;
				}
			}
		}
	Double sum3 = (double)sum[3]/list[3].size();
	j=0;
		for(int d:list[0]){
			if(d%2==0) j++;
		}
		if(j==0) System.out.print("N ");
		else  System.out.print(sum[0]+" ");
		for(int i=1;i<4;i++){
			if(list[i].size()==0) System.out.print("N ");
			else{
				if(i==3) System.out.print(df.format(sum3)+" ");
				else System.out.print(sum[i]+" ");
			}
			
		
		}
		if(list[4].size()!=0)
		System.out.println(sum[4]);
		else  System.out.println("N");
	}
}
