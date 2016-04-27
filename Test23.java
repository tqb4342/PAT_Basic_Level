import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文
	字会是怎样？
	输入描述:
	输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过10^5个字符的串。可用的
	字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。
	注意：如果上档键坏掉了，那么大写的英文字母无法被打出。
	输出描述:
	在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。
	输入例子:
	7+IE.
	7_This_is_a_test.
	输出例子:
	_hs_s_a_tst
 * 
 */
public class Test23 {
	
	public static void main(String[] args) {
		String bad,tmp="";
		String str;
		Scanner read = new Scanner(System.in);
		List<Character> list = new ArrayList<Character>();
		bad = read.nextLine();
		str = read.nextLine();
		for(int i=0;i<bad.length();i++){
			if(bad.charAt(i)>='A'&&bad.charAt(i)<='Z'){
				tmp += (char)(bad.charAt(i)+32);
				tmp += bad.charAt(i);
			}
			else if(bad.charAt(i)=='+'){
				tmp += "QWERTYUIOPLKJHGFDSAZXCVBNM";
				tmp += bad.charAt(i);
			}
			else if(bad.charAt(i)=='_'){
				tmp += " ";
				tmp += bad.charAt(i);
			}
			else{
				tmp += bad.charAt(i);
			}
			
		}

		for(int i=0;i<str.length();i++){
		
			list.add(str.charAt(i));
		}
		for(int i=0;i<list.size();i++){
			if(!tmp.contains(list.get(i)+"")){
				System.out.print(list.get(i));
			}else{
				System.out.print("");
			}
		}
	}
	
}
