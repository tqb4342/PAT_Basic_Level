import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 输入描述:
	每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数
	
	D表示市场最大需求量。随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿
	
	元为单位）。数字间以空格分隔。
	
	
	输出描述:
	对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。
	
	输入例子:
	3 20
	
	18 15 10
	
	75 72 45
	
	输出例子:
	94.50
 * 
 */

public class Test10 implements Comparable<Test10>{
	double kind;
	double price;
	double sprice;
	

	public Test10(double kind, double price) {
		super();
		this.kind = kind;
		this.price = price;
		this.sprice = this.price / this.kind;
	}


	public Test10() {
		super();
	}
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int n;
		double demand;
		double add,meony,meony1;
		Test10 yb = null;
		List<Test10> list = new ArrayList<Test10>();
		n = read.nextInt();
		demand = read.nextDouble();
		int[] data = new int[n];
		int[] data1 = new int[n];
		for(int i=0;i<n;i++){
			data[i] = read.nextInt();
		}
		for(int i=0;i<n;i++){
			data1[i] = read.nextInt();
			list.add(new Test10(data[i],data1[i]));
		}
		Collections.sort(list);
		add = 0;meony = meony1 = 0;
		for(Test10 m:list){
			meony += m.kind;
			if(meony>demand){
				add += m.sprice*(demand-meony1);
				//保留小数点后两位输出。
				System.out.printf("%.2f\n",add); break;
			}else{
				add = add+m.price;
			}
			meony1 = meony;
		}
		
	}


	@Override
	public int compareTo(Test10 o) {
		// TODO Auto-generated method stub
		return sprice<o.sprice?1:-1;
	}

}
