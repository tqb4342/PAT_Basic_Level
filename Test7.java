import java.math.BigInteger;
import java.util.Scanner;

public class Test7 {
	
	/*
	 * 本题要求计算A/B，其中A是不超过1000位的正整数，B是1位正整数。你需要输出商数Q和余数R，使得A = B * Q + R成立。

		输入描述:
		输入在1行中依次给出A和B，中间以1空格分隔。
		
		
		输出描述:
		在1行中依次输出Q和R，中间以1空格分隔。
		
		输入例子:
		123456789050987654321 7
		
		输出例子:
		17636684150141093474 3
	 * 
	 */
	
	public static void main(String[] args) {
		int n;
		Scanner read = new Scanner(System.in);
		String cc = read.nextLine();
		BigInteger a = new BigInteger(cc.split(" ")[0]);
		BigInteger b = new BigInteger(cc.split(" ")[1]);
		BigInteger[] c = a.divideAndRemainder(b);
		System.out.println(c[0]+" "+c[1]);
	}
	
}
