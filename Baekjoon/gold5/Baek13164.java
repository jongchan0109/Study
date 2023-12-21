package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek13164 {

    static int n,k;
    static int[] peoples;

    static void input() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        peoples = new int[n];

        for(int i=0;i<n;i++){
            peoples[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve(){
        Arrays.sort(peoples);
        List<Integer> dif = new ArrayList<>();

        for(int i=0;i<n-1;i++){
            dif.add(peoples[i+1]-peoples[i]);
        }

        Collections.sort(dif);
        int result = 0;

        for(int i=0;i<n-k;i++){
            result+=dif.get(i);
        }
        System.out.println(result);

    }

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
}
