import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test18 {
	String name;
	Date date;
	
	public Test18() {
		super();
	}

	public Test18(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Main [name=" + name + ", date=" + date + "]";
	}

	public static void main(String[] args) {
		int n;
		String str;
		String name;
		Date date;
		Test18 m1 = new Test18();
		Test18 m2 = new Test18();
		Date date1 = new Date("2014/09/07");
		Date date2 = new Date("1814/09/05");
		Scanner read = new Scanner(System.in);
		List<Test18> list = new ArrayList<Test18>();
		n = read.nextInt();
		str = read.nextLine();
		for(int i=0;i<n;i++){
			str = read.nextLine();
			name = str.split(" ")[0];
			date = new Date(str.split(" ")[1]);
			if(date.before(date1)&&date.after(date2))
			list.add(new Test18(name,date));
		}
		m1 = m2 = list.get(0);
		for(Test18 m:list){
			if(m.date.after(m1.date))  m1 = m;
			if(m.date.before(m2.date)) m2 = m;
		}
		System.out.println(list.size()+" "+m2.name+" "+m1.name);
		
	}
	
}
