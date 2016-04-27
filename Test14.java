import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test14 {

	public static void main(String[] args) {
		String str;
		int index = 0;
		char symbol; //保存指数符号
		char[] data; //保存指数
		int sum = 0; //保存指数的大小
		Scanner read = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		str = read.nextLine();
		list.add(str.charAt(1)-48);
		for(int i=3;i<str.length();i++){
			if(str.charAt(i)=='E'){
				index = i;
				break;
			}
			list.add(str.charAt(i)-48);
		}
		if(str.charAt(0)=='-') System.out.print('-');
		
		symbol = str.charAt(index+1);
		data = new char[str.length()-index-2];
		//保存指数
		for(int i=index+2,j=0;i<str.length();i++){
			data[j++] = str.charAt(i);
		}
		for(int i=0,j=data.length-1;i<data.length;i++){
			sum += ((int)(data[i]-48)*Math.pow(10,j--));
		}
		if(str.charAt(index+1)=='-'){
				System.out.print("0.");
				for(int i=1;i<sum;i++)
					System.out.print("0");
				for(int d:list)
					System.out.print(d);
		}else{
			
			if(sum<list.size()-1){
				System.out.print(list.get(0));
				for(int i=1;i<=sum;i++)
				System.out.print(list.get(i));
				System.out.print(".");
				for(int i=sum+1;i<list.size();i++)
				System.out.print(list.get(i));
			}
			if(sum==list.size()-1){
				for(int d:list){
					System.out.print(d);
				}
			}
			if(sum>list.size()-1){
				for(int d:list){
					System.out.print(d);
				}
				for(int i=0;i<sum-list.size()+1;i++){
					System.out.print("0");
				}
			}
		}
	}

}
