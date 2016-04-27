import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/*
 * 输入在第1行给出不超过105的正整数N，即参赛人数。随后N行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号（从1开始
连续编号）、及其比赛成绩（百分制），中间以空格分隔。
输出描述:
在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。
输入例子:
6
3 65
2 80
1 100
2 70
3 40
3 0
输出例子:
2 150
 * 
 */
public class Test22 {
	int id;
	int grade;
	
	public Test22() {
		super();
	}

	public Test22(int id, int grade) {
		super();
		this.id = id;
		this.grade = grade;
	}

	public static void main(String[] args) {
		int n;
		int id;
		int grade;
		Scanner read = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<Integer>();
		List<Test22> list = new ArrayList<Test22>();
		n = read.nextInt();
		int sum = 0;
		Test22[] m = new Test22[n];
		for(int i=0;i<n;i++){
			id = read.nextInt();
			grade = read.nextInt();
			m[i] = new Test22(id,grade);
			set.add(id);
		}
		for(int g:set){
			for(int i=0;i<n;i++){
				if(m[i].id==g) sum+=m[i].grade;
			}
			list.add(new Test22(g,sum));
			sum = 0;
		}
		Test22 wa = new Test22(0,0);
		for(Test22 w:list){
			if(w.grade>wa.grade) wa = w;
		}
		System.out.println(wa.id+" "+wa.grade);

	}

}
