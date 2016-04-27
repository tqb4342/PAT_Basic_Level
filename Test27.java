import java.util.Scanner;

public class Test27 {
	/*
	 * 题目描述
		如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
		十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
		输入描述:
		输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0, 
		17)区间内的整数，Knut是[0, 29)区间内的整数。
		输出描述:
		在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
		输入例子:
		10.16.27 14.1.28
		输出例子:
		3.2.1
	 * 
	 */
	public static void main(String[] args) {
		int Galleon1,Galleon2,Galleon;
		int Sickle1,Sickle2,Sickle;
		int Knut1,Knut2,Knut;
		Scanner read = new Scanner(System.in);
		String str = read.nextLine();
		String[] data = str.split(" ");
		str = "";
		Galleon1 = Integer.parseInt(data[0].split("\\.")[0]);
		Sickle1 = Integer.parseInt(data[0].split("\\.")[1]);
		Knut1 = Integer.parseInt(data[0].split("\\.")[2]);
		Galleon2 = Integer.parseInt(data[1].split("\\.")[0]);
		Sickle2 = Integer.parseInt(data[1].split("\\.")[1]);
		Knut2 = Integer.parseInt(data[1].split("\\.")[2]);
		if(Knut2-Knut1>=0){
			Knut = Knut2-Knut1;
		}else{
			if(Sickle2>0){
				Sickle2--;
				Knut = Knut2-Knut1+29;
			}else{
				Galleon2--;Sickle2 = Sickle2+16;
				Knut = Knut2-Knut1+29;
			}
		}
		
		if(Sickle2-Sickle1>=0){
			Sickle = Sickle2-Sickle1;
		}else{
			Galleon2--;Sickle = Sickle2+17-Sickle1;
		}
		Galleon = Galleon2-Galleon1;
		if(Galleon<0){
			
			if(Knut!=0){
				Knut = 29-Knut;
					Sickle = 16-Sickle;
					Galleon++;
			}else {
				if(Sickle!=0){
					Sickle = 17-Sickle;
					Galleon++;
				}
			}
				
			
		}
		str = str+Galleon+"."+Sickle+"."+Knut;
		System.out.println(str);
	}
}
