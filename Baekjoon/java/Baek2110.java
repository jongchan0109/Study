import java.util.*;
import java.io.*;
public class Baek2110 {
    static int N,C;
    static int[] arr;
    static void input() throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(bf.readLine());
        Arrays.sort(arr);
    }

    static int count(int dis)
    {
        int cnt=1;
        int last = arr[0];
        for(int i=1;i<N;i++)
        {
            if(arr[i]-last>=dis)
            {
                cnt++;
                last = arr[i];
            }
        }
        return cnt;
    }
    static int go()
    {
        int lo = 1;
        int hi = arr[N-1];
        int ret=1;

        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            int result = count(mid);
            if(result<C)
            {
               hi = mid - 1;
               continue;
            }

            lo = mid+1;
            ret = mid;

        }
        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        input();
        System.out.println(go());
    }
}
