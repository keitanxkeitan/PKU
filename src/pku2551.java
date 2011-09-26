import java.math.BigInteger;
import java.util.Scanner;


public class pku2551 {
	public static void main(String args[]) {
		System.out.println(BigInteger.valueOf(9999).multiply(BigInteger.valueOf(36)));
		Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//			String n = sc.next();
			for (int a = 1; a <= 10000; ++a) {
				if (a % 2 == 0 || a % 5 == 0) continue;
//			BigInteger bn = new BigInteger(n);
				BigInteger bn = BigInteger.valueOf(a);
				BigInteger bi = BigInteger.ONE;
			for (int i = 1; ; ++i) {
				if (bi.remainder(bn) == BigInteger.ZERO) {
					System.out.println(i);
					break;
				}
				bi = bi.multiply(BigInteger.valueOf(10)).add(BigInteger.ONE);
			}
		}
	}
}
