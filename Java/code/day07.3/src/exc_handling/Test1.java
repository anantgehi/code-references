package exc_handling;

public class Test1 {

	public static void main(String[] args) {
		try {
			int a = 10;
			int b = 10;
			System.out.println("Result " + (a / b));//AE
			String s = "12345adsg";
			System.out.println("int value " + Integer.parseInt(s));//NFE
			int[] data = { 12, 34, 678 };
			System.out.println(data[2]);//AOB
			String s2 = null;
			System.out.println("char at 0th index " + s2.charAt(0));
			System.out.println("end of try...");
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println("in catch-all");
			System.out.println("err mesg "+e.getMessage());
			System.out.println("name n mesg "+e);//e.toString
			e.printStackTrace();
		}
//		catch (NumberFormatException e) {
//			System.out.println(2);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(3);
//		} catch (NullPointerException e) {
//			System.out.println(4);
//		}
		System.out.println("main cntd....");

	}

}
