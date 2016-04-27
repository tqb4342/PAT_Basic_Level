import java.util.Scanner;

public class Test4 {
	
	/*
	 * 题目描述
		大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很
		
		 快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是
		
		 第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、
		
		 以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，
		
		 请帮助福尔摩斯解码得到约会的时间。
		
		输入描述:
		输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。
		
		
		输出描述:
		在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
		
		四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。
		
		输入例子:
		3485djDkxh4hhGE
		
		2984akDfkkkkggEdsb
		
		s&hgsfdk
		
		d&Hyscvnm
		
		输出例子:
		THU 14:04
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		String[] week = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		String[] str = new String[4];
		String we = null;
		int h=0,s=0;
		Scanner read = new Scanner(System.in);
		for(int i=0;i<4;i++){
			str[i] = read.nextLine();
		}
		int min1 = str[0].length()<str[1].length()?str[0].length():str[1].length();
		int min2 = str[2].length()<str[3].length()?str[2].length():str[3].length();
		for(int i=0,j=0;i<min1;i++){
			if((str[0].charAt(i)>='A' && str[0].charAt(i)<='Z') && (str[1].charAt(i)>='A' && str[1].charAt(i)<='Z')){
				j++;
				if(j==1 && str[0].charAt(i)==str[1].charAt(i)){
					 we = week[(int)str[0].charAt(i)-65];
				}
				if(j!=1 && str[0].charAt(i)==str[1].charAt(i)){
					h = (int)str[0].charAt(i)-64+9;  break;
				}
			}
			if(j!=0 && (str[0].charAt(i)>='0' && str[0].charAt(i)<='9') && (str[1].charAt(i)>='0' && str[1].charAt(i)<='9')){
				if(str[0].charAt(i)==str[1].charAt(i)){
					h = (int)str[0].charAt(i)-48;  break;
				}
			}
		}
		
		
		for(int i=0;i<min2;i++){
			if((str[2].charAt(i)>='a' && str[2].charAt(i)<='z') && (str[3].charAt(i)>='a' && str[3].charAt(i)<='z')){
				if(str[2].charAt(i)==str[3].charAt(i)){
					 s = i; break;
				}
			}
		}
		if(s<10&&h<10)
		System.out.println(we+" 0"+ h+":0"+s);
		else{
			if(h<10)  System.out.println(we+" 0"+ h+":"+s);
			if(s<10) System.out.println(we+" "+ h+":0"+s);
			if(s>=10&&h>=10) System.out.println(we+" "+ h+":"+s);
		}
		
	}
	
}
