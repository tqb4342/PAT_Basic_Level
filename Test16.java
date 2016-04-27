import java.util.Scanner;

public class Test16 {
	public static final int CLK_TCK  =100;
	public static void main(String[] args) {
		double c1,c2,tmp;
		int h,m,s;
		Scanner read = new Scanner(System.in);
		c1 = read.nextDouble();
		c2 = read.nextDouble();
		tmp = c2-c1;
		tmp = Math.round(tmp/100);
		h = (int)tmp/3600;
		m = (int)(tmp-h*3600)/60;
		s = (int)tmp-(h*3600+m*60);
		if(h<10)
			System.out.print("0"+h);
		else System.out.print(h);
		if(m<10)
			System.out.print(":0"+m);
		else System.out.print(":"+m);
		if(s<10)
			System.out.print(":0"+s);
		else System.out.print(":"+s);
		
	}
	
}
