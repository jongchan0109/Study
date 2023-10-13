import java.io.*;
import java.util.*;

public class Baek1344 {
    static int A,B;
    static double pa,pb;
    static int[] prime = {2,3,5,7,11,13,17};
    static long permutation(int n)
    {
        if(n==0 || n==1)
            return 1;
        else
            return n*permutation(n-1);
    }
    static long combination(int n,int r)
    {
        return permutation(n)/ (permutation(n-r)*permutation(r));
    }
    static double probability(double percent)
    {
        double result = 0;
        for (int pri:prime) {
            result += combination(18,pri)* Math.pow(percent,pri) * Math.pow(1-percent,18-pri);
        }
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        B = Integer.parseInt(st.nextToken());
        pa = (double)A/100;
        pb = (double)B/100;

        double ppa = probability(pa);
        double ppb = probability(pb);
        System.out.println(ppa + ppb - ppa*ppb);


    }
}
