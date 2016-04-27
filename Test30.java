import java.util.Scanner;
/*
 * 题目描述
	字符串APPAPT中包含了两个单词“PAT”，其中第一个PAT是第2位(P),第4位(A),第6位(T)；第二个PAT是第3位(P),第4位(A),第6位(T)。
	现给定字符串，问一共可以形成多少个PAT？
	输入描述:
	输入只有一行，包含一个字符串，长度不超过105，只包含P、A、T三种字母。
	输出描述:
	在一行中输出给定字符串中包含多少个PAT。由于结果可能比较大，只输出对1000000007取余数的结果。
	输入例子:
	APPAPT
	输出例子:
	2
 * 
 */
public class Test30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String orgStr = "";
        while (in.hasNext()) {
            orgStr = in.nextLine();
        }
        char[] arr = orgStr.toCharArray();
        int pNum = 0;
        int paNum = 0;
        int patNum = 0;
        for(char val : arr){
            if((""+val).equals("P")){
                pNum++;
            }else if((""+val).equals("A")){
                paNum +=pNum;
                paNum = paNum%1000000007;
            }else {
                patNum +=paNum;
                patNum = patNum%1000000007;
            }
        }
        System.out.println(patNum);
    }
}