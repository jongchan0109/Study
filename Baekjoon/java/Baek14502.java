import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek14502 {

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;
    static int[][] map;
    static int[] dx = {0,0,-1,1}; // 상하좌우
    static int[] dy = {-1,1,0,0};

    static int max = 0;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(){
        Queue<Point> queue = new LinkedList<>();

        int[][] copy = copyMap();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 2){
                    queue.offer(new Point(i,j));
                }
            }
        }

        while(!queue.isEmpty()){
            Point current = queue.poll();
            for(int i=0;i<4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(range(nx,ny) && copy[nx][ny] == 0){
                    queue.offer(new Point(nx,ny));
                    copy[nx][ny] = 2;
                }
            }
        }
        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                if(copy[i][j]==0)
                    count++;
        }

        max = Math.max(max,count);
    }

    static int[][] copyMap(){
        int[][] copy = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    static boolean range(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }


    static void dfs(int wall){
        if(wall==3) {
            bfs();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void go(){
        dfs(0);
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
