import java.util.Scanner;

/*
 * 
 * 给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到

一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。



例如，我们从6767开始，将得到



7766 - 6677 = 1089

9810 - 0189 = 9621

9621 - 1269 = 8352

8532 - 2358 = 6174

7641 - 1467 = 6174

... ...



现给定任意4位正整数，请编写程序演示到达黑洞的过程。

输入描述:
输入给出一个(0, 10000)区间内的正整数N。


输出描述:
如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例。注意每个数字按4位数格

式输出。

输入例子:
6767

输出例子:
7766 - 6677 = 1089

9810 - 0189 = 9621

9621 - 1269 = 8352

8532 - 2358 = 6174
 * 
 */

public class Test9 {

	 //min的值为0，max的值为待排序数组中最大值+1
    public static void bucketSort(int[] data, int min, int max) {  
        // 缓存数组  
        int[] tmp = new int[data.length];  
        // buckets用于记录待排序元素的信息  
        // buckets数组定义了max-min个桶  
        int[] buckets = new int[max - min];  
        // 计算每个元素在序列出现的次数  
        for (int i = 0; i < data.length; i++) {  
            buckets[data[i] - min]++;  
        }  
        // 计算“落入”各桶内的元素在有序序列中的位置  
        for (int i = 1; i < max - min; i++) {  
            buckets[i] = buckets[i] + buckets[i - 1];  
        }  
        // 将data中的元素完全复制到tmp数组中  
        System.arraycopy(data, 0, tmp, 0, data.length);  
        // 根据buckets数组中的信息将待排序列的各元素放入相应位置  
        for (int k = data.length - 1; k >= 0; k--) {  
            data[--buckets[tmp[k] - min]] = tmp[k];  
        }  
    }  
	  public static int shi(int[] data){
		  return data[0]*1000+data[1]*100+data[2]*10+data[3];
	  }
	  
	  public static int[] chai(int data){
		  int[] d = new int[4];
		  for(int i=0,j=3;i<4;i++){
			  d[i] = (int) (data/(Math.pow(10, j)));
			  data = data%(int) (Math.pow(10, j));
			  j--;
		  }
		  return d;
	  }
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int[] data = new int[4];
		int[] data1 = new int[4];
		String str = read.nextLine();
		for(int i=0;i<str.length();i++){
			data[i] = str.toCharArray()[i]-48;
		}
		int tmp = Test9.shi(data);
		while(tmp!=6174){
			Test9.bucketSort(data,0,10);
			if(data[0]==data[1]&&data[1]==data[2]&&data[2]==data[3]){
				System.out.println(str+" - "+str+" = 0000");
				break;
			}
			for(int i=3,j=0;i>=0;i--){
				data1[i] = data[j++];
			}
			tmp = Test9.shi(data1) - Test9.shi(data);
			if(tmp>=1000)
				System.out.println(""+data1[0]+data1[1]+data1[2]+data1[3]+" - "+data[0]+data[1]+data[2]+data[3]+" = "+tmp);
			if(tmp<1000&&tmp>=100)
				System.out.println(""+data1[0]+data1[1]+data1[2]+data1[3]+" - "+data[0]+data[1]+data[2]+data[3]+" = 0"+tmp);
			if(tmp<100&&tmp>=10)
				System.out.println(""+data1[0]+data1[1]+data1[2]+data1[3]+" - "+data[0]+data[1]+data[2]+data[3]+" = 00"+tmp);
			data = Test9.chai(tmp);
		}
		
	}

}
