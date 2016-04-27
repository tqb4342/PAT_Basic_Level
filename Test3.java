import java.util.Scanner;

public class Test3 {

	
	/*
	 * 题目描述
		令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
		
		输入描述:
		输入在一行中给出M和N，其间以空格分隔。
		
		
		输出描述:
		输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
		
		输入例子:
		5 27
		
		输出例子:
		11 13 17 19 23 29 31 37 41 43
		
		47 53 59 61 67 71 73 79 83 89
		
		97 101 103
	 * 
	 * 
	 * 
	 */
	
	
	
	public static boolean isPrime(long n){
	    for(int i=2;i<=Math.sqrt(n);i++){
	         if(n%i == 0)
	              return false; 
	    }
	    return true; 
	}
	
	
	public static void main(String[] args) {
		
			int n,m,j=0,i=0;
			long s = 1;
			boolean flag = true;
			Scanner read = new Scanner(System.in);
			n = read.nextInt();
			m = read.nextInt();
			int d = m-n+1;
			
			
			i=0;
			while(flag){
				s++;
				boolean b = Test3.isPrime(s);
				if(b) {
					i++;
					if(i-n+1==d) {
						System.out.println(s);
						break;
					}
					if(j!=0)  {
						
						j++;
						if(j%10==0)  {
							System.out.println(s);
						}else
						System.out.print(s+" ");
					}
					if(i==n)  {
						
							System.out.print(s+" ");
							j++;
						
					}
					
				}
				
			}
	}

}
