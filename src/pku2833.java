import java.math.BigDecimal;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class pku2833 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n1, n2, n;
			n1 = sc.nextInt(); n2 = sc.nextInt(); n = sc.nextInt();
			if (n1 == 0 && n2 == 0 && n == 0) break;
			PriorityQueue<Long> bigs = new PriorityQueue<Long>(n1);
			PriorityQueue<Long> smalls = new PriorityQueue<Long>(n2, Collections.reverseOrder());
			long sum = 0;
			for (int i = 0; i < n; ++i) {
				long p = sc.nextInt();
				sum += p;
				if (bigs.size() < n1) { bigs.add(p); }
				else if (bigs.peek() < p) {
					bigs.poll();
					bigs.add(p);
				}
				if (smalls.size() < n2) { smalls.add(p); }
				else if (smalls.peek() > p) {
					smalls.poll();
					smalls.add(p);
				}
			}
			long sum_of_bigs = 0;
			for (int i = 0; i < n1; ++i) {
				sum_of_bigs += bigs.poll();
			}
			long sum_of_smalls = 0;
			for (int i = 0; i < n2; ++i) {
				sum_of_smalls += smalls.poll();
			}
			BigDecimal bunshi = new BigDecimal(sum - sum_of_bigs - sum_of_smalls);
			BigDecimal bunbo = new BigDecimal(n - n1 - n2);
			BigDecimal ans = bunshi.divide(bunbo);
			System.out.printf("%.6f\n", ans.doubleValue());
		}
	}
}
