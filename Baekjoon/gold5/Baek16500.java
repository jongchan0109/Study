package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek16500 {

    static String str;
    static int n;
    static int len;


    static List<String> list;
    static boolean[] dp;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        str = bf.readLine();
        n = Integer.parseInt(bf.readLine());
        len = str.length();

        list = new ArrayList<>();

        dp = new boolean[len+1];
        for(int i=0;i<n;i++){
            String temp = bf.readLine();
            list.add(temp);
        }
    }

    static void go() {
        for(int i=len-1;i>=0;i--){
            for(int j = i+1;j<len;j++){
                if(dp[j]){
                    if(list.contains(str.substring(i,j)))
                        dp[i] = true;
                }
            }

            if(list.contains(str.substring(i)))
                dp[i] = true;
        }

        if(dp[0]){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
