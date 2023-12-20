package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2636 {

    static int r, c;
    static int cheese=0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(map[i][j]==1)
                    cheese++;
            }
        }
    }

    static boolean range(int row,int col){
        return 0<=row && row<r && 0<= col && col<c;
    }

    static void BFS(){
        visited = new boolean[r][c];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int i=0;i<4;i++){
                int nextRow = current[0] + dr[i];
                int nextCol = current[1] + dc[i];

                if(range(nextRow,nextCol) && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;

                    if(map[nextRow][nextCol] == 0){
                        queue.offer(new int[] {nextRow,nextCol});
                    } else{
                        map[nextRow][nextCol] = 0;
                        cheese--;
                    }
                }
            }

        }

    }

    static void solve() {
        int priorCheese=0,time=0;

        while(cheese!=0){
            priorCheese = cheese;
            BFS();
            time++;
        }

        System.out.println(time);
        System.out.println(priorCheese);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
