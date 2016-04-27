
import java.util.Scanner;
/*
 * 给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，则称这个数列是完美数列。
现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。
输入描述:
输入第一行给出两个正整数N和p，其中N（<= 105）是输入的正整数的个数，p（<= 109）是给定的参数。第二行给出N个正整数，每个数
不超过109。
输出描述:
在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。
输入例子:
10 8
2 3 20 4 5 1 6 7 8 9
输出例子:
8
 * 
 */
public class Test20 {
	public static void quickSort(int a[]){
	    qSort(a, 0, a.length - 1);
	}
	public static void qSort(int a[],int low,int high){
	    int pivot = 0;
	    if(low < high){
	        //将数组一分为二
	        pivot = partition(a,low,high);
	        //对第一部分进行递归排序
	        qSort(a,low,pivot);
	        //对第二部分进行递归排序
	        qSort(a,pivot + 1,high);
	    }
	}
	//partition函数，实现三数中值分割法
	public static int partition(int a[],int low,int high){

	    int pivotkey = a[low];   //选取第一个元素为枢轴记录
	    while(low < high){
	        //将比枢轴记录小的交换到低端
	        while(low < high && a[high] >= pivotkey){
	            high--;
	        }
	        //采用替换而不是交换的方式操作
	        a[low] = a[high];
	        //将比枢轴记录大的交换到高端
	        while(low < high && a[low] <= pivotkey){
	            low++;
	        }
	        a[high] = a[low];
	    }
	    //枢纽所在位置赋值
	    a[low] = pivotkey;
	    //返回枢纽所在的位置
	    return low;
	}
	
	public static void main(String[] args) {
		int n,p;
		int[] d = null;
		Scanner read = new Scanner(System.in);
		n = read.nextInt();
		p = read.nextInt();
		d = new int[n];
		for(int i=0;i<n;i++){
			//data = read.nextInt();
			//list.add(data);
			d[i] = read.nextInt();
		}
		//Collections.sort(list);
		Test20.quickSort(d);   //

		int max = 1;
		 for(int i=0;i<n;i++)
	        {
	                for(int j=i+max-1;j<n;j++)
	                {
	                        if(d[i]*p<d[j])
	                                break;
	                        if(j-i+1>max)
	                        max =j-i+1;
	                }
	        }
			System.out.println(max);
	}
	
}
