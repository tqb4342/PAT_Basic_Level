import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；然后将计算的和对11取模得
到值Z；最后按照以下关系对应Z值与校验码M的值：
Z：0 1 2 3 4 5 6 7 8 9 10
M：1 0 X 9 8 7 6 5 4 3 2
现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。
输入描述:
输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。
输出描述:
按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常，
则输出“All passed”。
输入例子:
4
320124198808240056
12010X198901011234
110108196711301866
37070419881216001X
输出例子:
12010X198901011234
110108196711301866
37070419881216001X
 * 
 */
public class Test21{

	public static void main(String[] args){
		int[] data ={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char[] m = {'1','0','X','9','8','7','6','5','4','3','2'};
		int n,g=0,f = 0;
		double sum = 0;
		boolean flag = false;
		Scanner read = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		n = read.nextInt();
		String str1 = read.nextLine();
		for(int i=0;i<n;i++){
			str1 = read.nextLine();
			list.add(str1);	
		}
		for(String str:list){
			char[] da = str.toCharArray();
			//判断钱17位有没有飞数字
			for(int j=0;j<17;j++){
				if(da[j]<48||da[j]>57){
					System.out.println(str);
					break;
				}
				if(j==16) flag = true;
			}
			if(flag){
				for(int j=0;j<17;j++){
					sum += ((double)(da[j]-48)*data[j]);
				}
				f  = (int)sum%11;
						if(m[f]!=da[17]) System.out.println(str);
				else{
					g++;
				}
			}
			flag = false; sum  =0;
		}
		if(g==n) System.out.println("All passed");
	}

}



