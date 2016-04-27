import java.math.BigInteger;
import java.util.Scanner;

public class test1 {
	/*
	 * 给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
	 * 输入描述:
	 *	输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。
	 *输出描述:
对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。
	 */
	public static void main(String[] args) {
		int n;
		Scanner read = new Scanner(System.in);
		n=read.nextInt();
		String cc = read.nextLine();
		BigInteger a = null;
		BigInteger b = null;
		BigInteger c = null;
		String str,str1[];
		for(int i=1;i<=n;i++){
			str = read.nextLine();
			str1 = str.split(" ");
			a = new BigInteger(str1[0]);
			b = new BigInteger(str1[1]);
			c = new BigInteger(str1[2]);
			int tmp = a.add(b).compareTo(c);
			if(tmp==1)
				System.out.println("Case #"+i+": true");
			else
				System.out.println("Case #"+i+": false");
		}
	}
}
