import java.util.Scanner;

public class Test28 {
	public int value;
	public int num;
	public static void main(String[] args) {
		int n,m;
		Scanner read = new Scanner(System.in);
		n = read.nextInt();
		int[] data = new int[n];
		for(int i=0;i<n;i++){
			data[i] = read.nextInt();
		}
		m = read.nextInt();
		Test28[] stu = new Test28[m];
		for(int i = 0;i<m;i++){
			stu[i] = new Test28();
			stu[i].value = read.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(data[i] == stu[j].value){
					stu[j].num++;
				}
			}
		}
		for(int i=0;i<m-1;i++){
			System.out.print(stu[i].num+" ");
		}
		System.out.println(stu[m-1].num);
		
	}
}
