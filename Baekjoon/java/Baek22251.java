import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek22251 {

    static int n,k,p,x;
    static int[] digit;
    static int[][] arr = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        digit = new int[k];
    }

    static int transformation(int idx, int count, int num){

        if(idx == k){
            if(1<= num && num <=n && 1<= count && count<=p)
                return 1;
            return 0;
        }

        int result = 0;

        for(int i=0;i<=9;i++){
            result += transformation(idx+1, count + arr[digit[idx]][i],10*num+i);
        }

        return result;
    }

    static void go(){

        for(int i=0;i<k;i++){
            digit[i] = 0;
        }

        int mod = 10;
        int cpy_x = x;

        for(int i=k-1;i>=0;i--){
            digit[i] = cpy_x % mod;
            cpy_x /= 10;
        }
        int result = transformation(0,0, 0);

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
