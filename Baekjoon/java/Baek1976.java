import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek1976 {
    static int N,M;
    static int[][] incidentArray;

    static int[] route;
    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        incidentArray = new int[N][N];
        route = new int[M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0;j<N;j++){
                incidentArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine()," ");
        for(int i=0;i<M;i++){
            route[i] = Integer.parseInt(st.nextToken());
        }
    }
    static boolean DFS(int start,int end){
        boolean[] isVisit = new boolean[N];

        Stack<Integer> stack = new Stack<>();
        isVisit[start] = true;
        stack.push(start);

        while(!stack.isEmpty()){
            int city = stack.pop();
            if (city == end) {
                return true;
            }
            for(int i=0;i<N;i++){
                if(isVisit[i]==false && incidentArray[city][i]==1){
                    if(end==i){
                        return true;
                    }
                    stack.push(i);
                    isVisit[i]=true;
                }
            }
        }
        return false;
    }
    static void go(){
        for(int i=0;i<M-1;i++){
            if(!DFS(route[i]-1,route[i+1]-1)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
