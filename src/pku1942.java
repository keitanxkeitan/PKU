import java.math.BigInteger;
import java.util.Scanner;


public class pku1942 {
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
		String m, n;
		while (true) {
			m = sc.next(); n = sc.next();
			if (m.equals("0") && n.equals("0")) break;
			BigInteger big_m = new BigInteger(m);
			BigInteger big_n = new BigInteger(n);
			if (big_m.compareTo(big_n) < 0) System.out.println(combination(big_m.add(big_n), big_m));
			else System.out.println(combination(big_m.add(big_n), big_n));
			
		}
	}
}
