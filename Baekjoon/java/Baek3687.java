import java.util.*;
import java.io.*;

public class Baek3687 {

    static ArrayList<Integer> large = new ArrayList<>();

    static long[] minDp;

    static void max(int n) {
        if (n == 0) return;
        if (n % 2 != 0) {
            large.add(7);
            max(n - 3);
        } else {
            large.add(1);
            max(n - 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        minDp = new long[101];
        Arrays.fill(minDp, Long.MAX_VALUE);
            minDp[2] = 1;
            minDp[3] = 7;
            minDp[4] = 4;
            minDp[5] = 2;
            minDp[6] = 6;
            minDp[7] =8;
            minDp[8] = 10;

            String[] add = {"1","7","4","2","0","8"};

            for(int i=9;i<=100;i++)
            {
                for(int j=2;j<=7;j++)
                {
                    String line = minDp[i-j]+add[j-2];
                    minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
                }
            }

        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            large.clear();
            max(n);

            System.out.print(minDp[n]);
            System.out.print(" ");
            for (int num : large) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
