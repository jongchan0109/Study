import java.util.*;
import java.io.*;

class Back implements Comparable<Back>
{
    int w,v;
    Back(int w,int v)
    {
        this.w = w;
        this.v = v;
    }
    @Override
    public int compareTo(Back b)
    {
        if (this.w == b.w) {
            // w가 같을 때 v(가치)가 큰 아이템을 우선 선택
            return b.v - this.v;
        }
        return this.w - b.w;
    }
}

public class Baek12865 {
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Back[] arr = new Back[N];
        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new Back(w, v);
            sum[i] = 0;
        }
        Arrays.sort(arr);
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (arr[i - 1].w <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1].w] + arr[i - 1].v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
