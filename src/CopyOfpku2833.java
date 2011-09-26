import java.math.BigDecimal;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class CopyOfpku2833 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n1, n2, n;
			n1 = sc.nextInt(); n2 = sc.nextInt(); n = sc.nextInt();
			if (n1 == 0 && n2 == 0 && n == 0) break;
			PriorityQueue<BigDecimal> bigs;
			PriorityQueue<BigDecimal> smalls;
			if (n1 != 0) {
				bigs = new PriorityQueue<BigDecimal>(n1);
			} else {
				bigs = new PriorityQueue<BigDecimal>(1);
				bigs.add(BigDecimal.ZERO);
			}
			if (n2 != 0) {
				smalls = new PriorityQueue<BigDecimal>(n2, Collections.reverseOrder());
			} else {
				smalls = new PriorityQueue<BigDecimal>(1, Collections.reverseOrder());
				smalls.add(BigDecimal.ZERO);
			}
			BigDecimal sum = BigDecimal.ZERO;
			for (int i = 0; i < n; ++i) {
				int p = sc.nextInt();
				BigDecimal big_p = BigDecimal.valueOf((double)p);
				sum = sum.add(big_p);
				if (bigs.size() < n1) { bigs.add(big_p); }
				else if (bigs.peek().compareTo(big_p) < 0) {
					bigs.poll();
					bigs.add(big_p);
				}
				if (smalls.size() < n2) { smalls.add(big_p); }
				else if (smalls.peek().compareTo(big_p) > 0) {
					smalls.poll();
					smalls.add(big_p);
				}
			}
			BigDecimal sum_of_bigs = BigDecimal.ZERO;
			for (int i = 0; i < n1; ++i) {
				sum_of_bigs = sum_of_bigs.add(bigs.poll());
			}
			BigDecimal sum_of_smalls = BigDecimal.ZERO;
			for (int i = 0; i < n2; ++i) {
				sum_of_smalls = sum_of_smalls.add(smalls.poll());
			}
			BigDecimal bunshi = (sum.subtract(sum_of_bigs)).subtract(sum_of_smalls);
			BigDecimal bunbo = new BigDecimal((double)(n - n1 - n2));
			BigDecimal ans = bunshi.divide(bunbo);
			System.out.printf("%.6f\n", ans.doubleValue());
		}
	}
}
