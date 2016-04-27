import java.util.Scanner;

public class Test17 {
/*
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印



		 *****
		
		  ***
		
		   *
		
		  ***
		
		 *****
		
		 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递
		
		 增；首尾符号数相等。
		
		
		
		 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
		
		输入描述:
		输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
		
		
		输出描述:
		首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
		
		输入例子:
		19 *
		
		输出例子:
		*****
		
		 ***
		
		  *
		
		 ***
		
		*****
		
		2
 * 
 */
	public static void main(String[] args) {
		String str;
		char c;
		int n,sum = 0,index=0,index1=0,tmp=0;
		int[] data;
		Scanner read = new Scanner(System.in);
		n = read.nextInt();
		str = read.nextLine();
		c = str.toCharArray()[1];
		data = new int[n];
		for(int i=1;i<=n;i++){
			sum += (i*2+1);
		
			if(sum*2+1>n){
				index = i-1;break;
			}
			data[i] = (i*2+1);
			tmp = sum*2+1;
		}
		index1=index;
		sum = 0;
		while(index>=1){
			for(int i=0;i<data[index];i++){
				System.out.print(c);
			}
			System.out.println();
			index--; sum++;
			for(int i=0;i<sum;i++){
				System.out.print(" ");
			}
		}
		System.out.println(c);
		index = 1; sum = (data[index1]-data[index])/2;
		while(index<=index1){
			for(int i=0;i<sum;i++){
				System.out.print(" ");
			}
			sum--;
			for(int i=0;i<data[index];i++){
				System.out.print(c);
			}
			index++;
			System.out.println();
		}
		if(n-tmp!=0)
		System.out.println(n-tmp);
	}
	
}
