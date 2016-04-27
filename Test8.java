import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Test8 implements Comparable<Test8>{

	/*
	 * 大家应该都会玩“锤子剪刀布”的游戏：
		现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。 
		输入描述:
		
		输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
		
		表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
		
		
		输出描述:
		
		输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
		
		一，则输出按字母序最小的解。
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int n = read.nextInt();
		List<String> set1 = new ArrayList<String>(); 
		List<String> set2 = new ArrayList<String>(); 
		int a=0,b=0;
		int bb=0,cc=0,jj=0;
		String str = read.nextLine();;
		map.put("C C",0); map.put("C B",-1);  map.put("C J",1);
		map.put("B C",1); map.put("B B",0);  map.put("B J",-1);
		map.put("J C",-1); map.put("J B",1);  map.put("J J",0);
		for(int i=0;i<n;i++){
			str = read.nextLine();
			
			if(map.get(str)==1)  {
				set1.add(str.split(" ")[0]);
				a++;
			}
			if(map.get(str)==-1)  {
				set2.add(str.split(" ")[1]);
				b++;
			}
		}
			System.out.println(a+" "+(n-a-b)+" "+b);
			System.out.println(b+" "+(n-a-b)+" "+a);
			Collections.sort(set1);
			Collections.sort(set2);
			for(String s:set1){
				if(s.equals("B")) bb++;
				if(s.equals("C")) cc++;
				if(s.equals("J")) jj++;
			}
			if(bb>=cc&&bb>=jj)  System.out.print("B ");
			if(cc>bb&&cc>=jj)  System.out.print("C ");
			if(jj>bb&&jj>cc)   System.out.print("J ");
			bb=0;cc=0;jj=0;
			for(String s:set2){
				if(s.equals("B")) bb++;
				if(s.equals("C")) cc++;
				if(s.equals("J")) jj++;
			}
			if(bb>=cc&&bb>=jj)  System.out.println("B");
			if(cc>bb&&cc>=jj)  System.out.println("C");
			if(jj>bb&&jj>cc)   System.out.println("J");
	}

	@Override
	public int compareTo(Test8 o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
