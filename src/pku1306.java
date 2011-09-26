import java.math.BigInteger;
import java.util.Scanner;


public class pku1306 {
	public static BigInteger combination(BigInteger a, BigInteger b) {
		BigInteger ret = BigInteger.ONE;
		int int_b = b.intValue();
		for (int i = 0; i < int_b; ++i) {
			ret = ret.multiply(a);
			a = a.subtract(BigInteger.ONE);
		}
		for (int i = 0; i < int_b; ++i) {
			ret = ret.divide(b);
			b = b.subtract(BigInteger.ONE);
		}
		return ret;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n, m;
		while (true) {
			n = sc.next(); m = sc.next();
			if (n.equals("0") && m.equals("0")) break;
			BigInteger big_n = new BigInteger(n);
			BigInteger big_m = new BigInteger(m);
			System.out.print(big_n + " things taken " + big_m + " at a time is ");
			if (big_n.subtract(big_m).compareTo(big_m) < 0) System.out.print(combination(big_n, big_n.subtract(big_m)));
			else System.out.print(combination(big_n, big_m));
			System.out.println(" exactly.");
		}
	}
}
