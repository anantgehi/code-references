class TestPrimTypes
{
public static void main(String[] args)
 {
    System.out.println("Range of Bytes : "+Byte.MIN_VALUE+"--"+Byte.MAX_VALUE);
	System.out.println("Range of ints : "+Integer.MIN_VALUE+"--"+Integer.MAX_VALUE);
	byte b1=-10;
	byte b2=20;
	//byte b3=b1+b2;//RHS : int , LHS : byte
	short s1=150;
	s1=b1;
	short s2=(short)(b1+s1);//RHS : short , LHS :short
	b1 += 20;//b1 =(byte) (b1 + 20);
	b2=++b1;//no javac err
	double d1=45.67;
	d1=3.45f;//RHS : float ---> double
	//float f1=2.3456;//javc err , double ---X---float
	float f2=23.45;
	long l1=4625657;
	l1=(long)f2;//float --> long : narrowing conversion !
	
	
 }
}