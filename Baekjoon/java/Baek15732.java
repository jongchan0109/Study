import java.io.*;
import java.util.*;

class Rule {
    long A, B, C;

    public Rule(long A, long B, long C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
}

public class Baek15732 {
    static long N, K, D;
    static Rule[] rules;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        D = Long.parseLong(st.nextToken());

        rules = new Rule[(int) K];
        long maxEnd = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            rules[i] = new Rule(A, B, C);
            maxEnd = Math.max(maxEnd, B);
        }

        long left = 1;
        long right = maxEnd;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalD = 0;

            for (int i = 0; i < K; i++) {
                Rule rule = rules[i];
                long start = rule.A;
                long end = rule.B;
                long gap = rule.C;
                if (mid < start) continue;
                long boxes = Math.min(mid, end) - start;
                if (boxes < 0) continue;
                long num = 1 + boxes / gap;
                totalD += num;
            }

            if (totalD >= D) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
