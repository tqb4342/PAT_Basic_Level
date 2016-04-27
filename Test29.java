import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 
 * 题目描述
	小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
	下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
	为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
	全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
	输入描述:
	每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
	输出描述:
	如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
	输入例子:
	ppRYYGrrYBR2258
	YrR8RrY
	输出例子:
	Yes 8
 */
public class Test29 {
	public static void main(String[] args) {
		String str1,str2,str3="";
		Scanner read = new Scanner(System.in);
		List<Character> list = new ArrayList<Character>();
		str1 = read.nextLine();
		str2 = read.nextLine();
		for(int i=0;i<str1.length();i++){
			list.add(str1.charAt(i));
		}
		for(int i=0;i<str2.length();i++){
			for(int j=0;j<list.size();j++){
				if(str2.charAt(i)==list.get(j)){
					str3+=list.get(j);
					list.remove(j);
					break;
				}
			}
		}
		if(str3.equals(str2)){
			System.out.println("Yes "+(str1.length()-str2.length()));
		}else{
			System.out.println("No "+(str2.length()-str3.length()));
		}
	}
}
