package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek13913 {

    static int n,k;
    static int[] count;
    static int[] parent;
    static boolean[] visited;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[200002];
        parent = new int[200002];
        count = new int[200002];
    }

    static boolean range(int x){
        return 0<=x && x<=200001;
    }

    static void bfs(){

        visited[n] = true;
        count[n] = 0;
        parent[n] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == k) {
                break;
            }
            int temp = current+1;
            if(range(temp) && !visited[temp]){
                visited[temp] = true;
                count[temp] = count[current]+1;
                parent[temp] = current;
                queue.offer(temp);
            }
            temp = current-1;
            if(range(temp)&&!visited[temp]){
                visited[temp] = true;
                count[temp] = count[current]+1;
                parent[temp] = current;
                queue.offer(temp);
            }
            temp = current*2;
            if(range(temp)&&!visited[temp]){
                visited[temp] = true;
                count[temp] = count[current]+1;
                parent[temp] = current;
                queue.offer(temp);
            }
        }
        System.out.println(count[k]);

        int start = k;
        Deque<Integer> route = new LinkedList<>();
        while(start != -1){
            route.offer(start);
            start = parent[start];
        }
        while(!route.isEmpty()){
            System.out.print(route.removeLast()+" ");
        }

    }

    public static void main(String[] args) throws IOException{
        input();
        bfs();
    }
}
