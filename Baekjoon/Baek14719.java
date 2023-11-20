import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14719 {
    static int H, W;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void go() {
        int sum = H*W;

        for(int i=H;i>0;i--){
            int[] indexArray = new int[W];
            int index=0;
            for(int j=0;j<W;j++){
                if(arr[j] >= i){
                    indexArray[index++] = j;
                }
            }
            if(index <=1){
                sum -= W;
                continue;
            }
            sum -= index;
            sum -= indexArray[0];
            sum -= (W-1 - indexArray[index-1]);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        go();
    }
}
