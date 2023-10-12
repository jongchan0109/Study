import java.io.*;
import java.util.*;

class Rule
{
    int start,end,add;

    public Rule(int start, int end, int add)
    {
        this.start = start;
        this.end = end;
        this.add = add;
    }
}

public class Baek15732 {
    static int N,K,D;
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        Rule[] rules = new Rule[K];

        for(int i=0;i<K;i++)
        {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int add = Integer.parseInt(st.nextToken());

            rules[i] = new Rule(start,end,add);
        }


        int result = 0;
        int max = 0;
        for(int i=1;i<=N;i++)
        {
            result += arr[i];
            if(result>=D) {
                max = i;
                break;
            }
        }
        System.out.println(max);
    }
}
