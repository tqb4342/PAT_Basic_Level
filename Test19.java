import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
 

/*
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出

肯定坏掉的那些键。

输入描述:
输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、

以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。


输出描述:
按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。

输入例子:
7_This_is_a_test

_hs_s_a_es

输出例子:
7TI
 * 
 */
public class Test19 {
 
    public static void main(String[] args){
        List l=new LinkedList();
        Set set=new HashSet();
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s=sc.next();
        for(int i=0;i<s.length();i++){
            l.add(s.charAt(i));
        }
        for(int i=0;i<s1.length();i++){
            if(l.contains(s1.charAt(i)))continue;
            int size1=set.size();
            set.add(Character.toUpperCase(s1.charAt(i)));
            int size2=set.size();
            if(size2==size1)continue;
            System.out.print(Character.toUpperCase(s1.charAt(i)));
        }
 
         
    }
}
