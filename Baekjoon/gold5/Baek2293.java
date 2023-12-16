package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2293 {

    static int n, k;
    static int[] arr;
    static int[] dp;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
    }


    static void go() {
        Arrays.sort(arr);
        dp[0] = 1;
        for (int i = 0;i<n;i++){
            for(int j = arr[i];j<=k;j++){
                dp[j] += dp[j-arr[i]];
            }
        }
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        go();
    }
}
