import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 输入描述:
	输入第1行给出3个正整数，分别为：N（<=105），即考生总数；L（>=60），为录取最低分数线，即德分和才分均不低于L的考生才有资格
	
	被考虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到
	
	但德分到线的一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于H，但是德分不低于才分的考生属于“才德兼
	
	亡”但尚有“德胜才”者，按总分排序，但排在第二类考生之后；其他达到最低线L的考生也按总分排序，但排在第三类考生之后。
	
	
	随后N行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为8位整数，德才分为区间[0, 100]内的整数。数字间以空格分隔。
	
	
	输出描述:
	输出第1行首先给出达到最低分数线的考生人数M，随后M行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。当某类考生中有多人
	
	总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
 * 
 * 
 */



public class Test5 implements Comparable<Test5>{
	
	 long sid;
	 int dgra;
	 int cgra;
	 int sum;
	 public static int NN;

	static Scanner read = new Scanner(System.in);
	
	
	public Test5() {
		super();
	}


	@Override
	public String toString() {
		return sid + " " + dgra + " " + cgra;
	}


	public Test5(long sid, int dgra, int cgra) {
		super();
		this.sid = sid;
		this.dgra = dgra;
		this.cgra = cgra;
		this.sum = this.dgra+this.cgra;
	}

	
	public static void scanf(Test5[] stu, int n ){
		long sid;
		int dgra;
		int cgra;
		for(int i=0;i<n;i++){
			sid = read.nextLong();
			dgra = read.nextInt();
			cgra = read.nextInt();
			stu[i] = new Test5(sid,dgra,cgra);
		}
	}
	
	public static List<Test5> Distrubute(Test5[] stu,int N,int L,int H){
		List<Test5> list = new ArrayList<Test5>();
		List<Test5> stu1 = new ArrayList<Test5>();
		List<Test5> stu2 = new ArrayList<Test5>();
		List<Test5> stu3 = new ArrayList<Test5>();
		List<Test5> stu4 = new ArrayList<Test5>();
		
		for(int i=0;i<N;i++){
			if(stu[i].cgra>=H&&stu[i].dgra>=H){
				stu1.add(new Test5(stu[i].sid,stu[i].dgra,stu[i].cgra));
				
			}
			if(stu[i].dgra>=H&&stu[i].cgra<H&&stu[i].cgra>=L){
				stu2.add(new Test5(stu[i].sid,stu[i].dgra,stu[i].cgra));
			}
			if(stu[i].dgra<H&&stu[i].dgra>=stu[i].cgra&&stu[i].cgra>=L){
				stu3.add(new Test5(stu[i].sid,stu[i].dgra,stu[i].cgra));
			}
			if(stu[i].dgra<stu[i].cgra&&stu[i].dgra>=L&&stu[i].dgra<H){
				stu4.add(new Test5(stu[i].sid,stu[i].dgra,stu[i].cgra));
			}
			
		}

		Collections.sort(stu1);
		Collections.sort(stu2);
		Collections.sort(stu3);
		Collections.sort(stu4);
		for(int i=0;i<stu1.size();i++){
			list.add(stu1.get(i));
		}
		for(int i=0;i<stu2.size();i++){
			list.add(stu2.get(i));
		}
		for(int i=0;i<stu3.size();i++){
			list.add(stu3.get(i));
		}
		for(int i=0;i<stu4.size();i++){
			list.add(stu4.get(i));
		}
		
		return list;
	}
	

	public static void main(String[] args) {
		int N,L,H;
		N = read.nextInt();
		L = read.nextInt();
		H = read.nextInt();
		
		Test5[] stu = new Test5[N];
		//输入
		Test5.scanf(stu,N);
		
		List<Test5> list = Test5.Distrubute(stu, N, L, H);
		System.out.println(list.size());
		for(Test5 m:list){
			System.out.println(m);
		}
		
		
	}
	@Override
	public int compareTo(Test5 o) {
		Test5 p=o;
		  int n= sum<p.sum?1:(sum==p.sum?0:-1);
		  if(n==0)
		  {
		   n=dgra<p.dgra?1:(dgra==p.dgra?0:-1);
		   if(n==0)
			   n=sid>p.sid?1:-1;
		  }
		  return n;
		
	}
	
	
	
	
	
	
}
