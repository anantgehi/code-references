package prim_arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Objective -- Accept no of data samples(of type double) from User(using scanner)
Create suitable array & display it using for-each loop , to confirm default values.

Accept data from User(scanner) & store it in the array.
Display array data using for-each loop
 */
public class Test1 {

	public static void main(String[] args) {
//		int count;
//		System.out.println(count);
		Scanner sc = new Scanner(System.in);
		System.out.println("How many nos (double) you want to enter ?");
		double[] data;// data : ref type of a var , array type of ref, --->4/8/16 bytes allocated on
						// the stack , for storing the ref. This will refer to array object holding
						// prims : double
		data = new double[sc.nextInt()];// 1. [D class will be loaded in Meth area , array obj in heap , ref assigned to
										// data.
		//display array contents  : def inited contents.
		//for -each
		System.out.println("def contents of double[] :");
		for(double d : data) //d=data[0],d=data[1]......d=data[data.length-1]
			System.out.println(d);
		//display the name of the loaded class for this double[]
		System.out.println("Name of the cls loaded "+data.getClass());//[D : compiler created class
		double[] data2=new double[100];//no new cls loading , new array obj --> data2
		System.out.println("Name of the cls loaded "+data2.getClass());//[D
		double[][] data3=new double[3][4];//new cls loaded : [[D
		System.out.println("Name of the cls loaded "+data3.getClass());//[[D
		//Accept data from User(scanner) & store it in the array. : for
		for(int i=0;i<data.length;i++)
		{
			System.out.println("Enter array data");
			data[i]=sc.nextDouble();
		}
		//display : for each
		System.out.println("contents of double[]  after init :");
		for(double d : data) //d=data[0],d=data[1]......d=data[data.length-1]
			System.out.println(d);
	//can u draw mem pic for array creation ?
		//use Arrays.toString : to display array contents
		System.out.println("Arrays contents via Arrays.toString "+Arrays.toString(data));
		sc.close();

	}

}
