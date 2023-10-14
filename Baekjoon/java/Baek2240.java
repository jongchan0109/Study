import java.util.*;
import java.io.*;
public class Baek2240 {
    static int T,W;
    static int[][] dp;
    static int count(int[] arr)
    {
        int pos = 1;

        for(int t=1;t<=T;t++)
        {
            int treePos = arr[t];

            for(int w=0;w<=W;w++)
            {
                if(w==0)
                {
                    pos = 1;
                    if(treePos == pos)
                        dp[t][w] = dp[t-1][w]+1;
                    else
                        dp[t][w] = dp[t-1][w];
                    continue;
                }
                if(w%2==0)
                {
                    pos = 1;
                    if(treePos == pos)
                        dp[t][w] = Math.max(dp[t-1][w]+1,dp[t-1][w-1]);
                    else
                        dp[t][w] = Math.max(dp[t-1][w],dp[t-1][w-1]+1);
                }
                else
                {
                    pos = 2;
                    if(treePos == pos)
                        dp[t][w] = Math.max(dp[t-1][w]+1,dp[t-1][w-1]);
                    else
                        dp[t][w] = Math.max(dp[t-1][w],dp[t-1][w-1]+1);
                }
            }
        }
        return dp[T][W];
    }

    public static void main(String args[]) throws IOException
    {
        int result;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] arr = new int[T+1];
        dp = new int[T+1][W+1];

        for(int i=1;i<T+1;i++)
        {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        result = count(arr);
        System.out.println(result);
    }
}
