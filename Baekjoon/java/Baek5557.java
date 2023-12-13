import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek5557 {
    static int N;
    static int[] arr;
    static long[][] dp;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int[N];
        dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void calculate(){
        dp[0][arr[0]] = 1;
        int plus,minus;
        for(int i=1;i<N-1;i++){
            for(int j=0;j<21;j++){
                if(dp[i-1][j]!= 0){
                    plus = j + arr[i];
                    minus = j - arr[i];
                    if(0<= plus && plus <=20){
                        dp[i][plus] += dp[i-1][j];
                    }
                    if(0<= minus && minus <=20){
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

    }

    static void go(){
        calculate();
        long sum = 0;

        sum = dp[N-2][arr[N-1]];
        System.out.println(sum);

    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
