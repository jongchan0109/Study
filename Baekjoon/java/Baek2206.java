import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2206 {

    static class Point{
        int x,y;
        boolean destroyed;
        int distance;

        public Point(int x, int y, boolean destroyed, int distance) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.distance = distance;
        }
    }

    static char[][] map;
    static boolean[][][] visited;
    static int N,M;

    static int[] dx = {-1,0,1,0}; // 좌 상 우 하
    static int[] dy = {0,1,0,-1};

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for(int i=1;i<=N;i++){
            String str = bf.readLine();
            for(int j=1;j<=M;j++){
                map[i][j] = str.charAt(j-1);
            }
        }
    }

    static boolean range(int x, int y){
        return 1<= x && x <=N && 1<=y && y <=M;
    }

    static void go(){
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(1,1,false,1));

        while(!queue.isEmpty()){
            Point current = queue.poll();
            if(current.x == N && current.y == M){
                System.out.println(current.distance);
                return;
            }


            for(int i=0;i<4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(range(nx,ny)) {
                    if(map[nx][ny] == '0'){
                        if(!current.destroyed && !visited[nx][ny][0]) {
                            queue.offer(new Point(nx, ny, false, current.distance + 1));
                            visited[nx][ny][0] = true;
                        }
                        else if(current.destroyed && !visited[nx][ny][1]){
                            queue.offer(new Point(nx, ny, true, current.distance + 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                    else{
                        if(!current.destroyed){
                            queue.offer(new Point(nx,ny,true, current.distance+1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }


    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
