
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * 给定一个常数K以及一个单链表L，请编写程序将L中每K个结点反转。例如：给定L为1→2→3→4→5→6，K为3，则输出应该为
	3→2→1→6→5→4；如果K为4，则输出应该为4→3→2→1→5→6，即最后不到K个元素不反转。
	输入描述:
	每个输入包含1个测试用例。每个测试用例第1行给出第1个结点的地址、结点总个数正整数N(<= 105)、以及正整数K(<=N)，即要求反转的
	子链结点的个数。结点的地址是5位非负整数，NULL地址用-1表示。
	接下来有N行，每行格式为：
	Address Data Next
	其中Address是结点地址，Data是该结点保存的整数数据，Next是下一结点的地址。
	输出描述:
	对每个测试用例，顺序输出反转后的链表，其上每个结点占一行，格式与输入相同。
	输入例子:
	00100 6 4
	00000 4 99999
	00100 1 12309
	68237 6 -1
	33218 3 00000
	99999 5 68237
	12309 2 33218
	输出例子:
	00000 4 33218
	33218 3 12309
	12309 2 00100
	00100 1 99999
	99999 5 68237
	68237 6 -1
 * 
 * 
 */
public class Test15 {
	
	String Address;
	Integer Data;
	String Next;
	public Test15() {
		super();
	}
	public Test15(String address, Integer data, String next) {
		super();
		Address = address;
		Data = data;
		Next = next;
	}
	public static int shi(char[] data){
		int sum = 0;
		for(int i=0,j=data.length-1;i<data.length;i++){
			sum += ((int)(data[i]-48)*Math.pow(10,j--));
		}
		return sum;
	}
	
	@Override
	public String toString() {
		return Address + " " + Data + " " + Next;
	}
	public static void main(String[] args) {
		String str;//作为输入字符串
		String fadd,address,next,adde;
		Integer N,data;
		Integer k;
		int multiple = 0;
		Test15[] chain = null;
		Test15[] chain1 = null;
		Map<String, Test15> map = new HashMap<String, Test15>();
		Scanner read = new Scanner(System.in);
		str = read.nextLine();
		fadd = str.split(" ")[0];
		adde = fadd;
		N = Test15.shi(str.split(" ")[1].toCharArray());
		k = Test15.shi(str.split(" ")[2].toCharArray());
		chain = new Test15[N];
		chain1 = new Test15[N];
		for(int i=0;i<N;i++){
			str = read.nextLine();
			address = str.split(" ")[0];data = Test15.shi(str.split(" ")[1].toCharArray()); next = str.split(" ")[2];
			chain[i] = new Test15(address,data,next);
			map.put(address, chain[i]);
		}
		//将链表放到map中去，组成链表形式。
//		int g = 0,s=0,ii=N-1;
//		adde = "-1";
//		while(true){
//			for(int j=0;j<N;j++){
//				if(s==N)  break;
//				if(chain[j].Address.equals(fadd)){
//					chain1[g++] = chain[j];	
//					fadd = chain[j].Next;  s++;
//				}
//				if(s==N)  break;
//				if(chain[j].Next.equals(adde)){
//					chain1[ii--] = chain[j];	
//					adde = chain[j].Address;  s++;
//				}
//			}
//			if(s==N)  break;
//		}
		int g = 0;
		while(!adde.equals("-1")){
			chain1[g] = map.get(adde);
			adde = chain1[g].Next;
			g++;
		}
		multiple = N/k;
		for(int i=1;i<=multiple;i++){
			fadd = chain1[i*k-1].Next;
			for(int j=i*k-1;j>i*k-k;j--){
				chain1[j].Next = chain1[j-1].Address;
				System.out.println(chain1[j]);
			}
			chain1[i*k-k].Next = fadd;
			System.out.println(chain1[i*k-k]);
		}
		for(int i=multiple*k;i<N;i++){
			System.out.println(chain1[i]);
		}
	}

}
