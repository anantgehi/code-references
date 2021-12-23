import java.util.*;
class TestBasicRules
{
public static void main(String[] args)
 {
    int data=100;//method local variable : by default un -inited
	System.out.print("data ="+data);//javac DOES NOT //allow accessing of any un-inited vars
	data++;
	String s="123456";
	s++;
	Scanner sc=new Scanner(System.in);
	sc += 10;
	
 }
}