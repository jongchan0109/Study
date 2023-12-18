package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10026 {
    static int n;

    static int countNot = 0;
    static int countYes = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] map;
    static boolean[][] visited;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String temp = bf.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = temp.charAt(j);
            }
        }
    }

    static boolean range(int x,int y){
        return 0<=x && x<n && 0<=y && y<n;
    }

    static void DFS(int x,int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (range(nx, ny)) {
                if (!visited[nx][ny] && map[x][y] == map[nx][ny])
                    DFS(nx, ny);
            }
        }
    }

    static void go(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    DFS(i,j);
                    countNot++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = false;
                if(map[i][j] == 'R')
                    map[i][j] = 'G';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    DFS(i,j);
                    countYes++;
                }
            }
        }


        System.out.println(countNot+" "+countYes);
    }



    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
