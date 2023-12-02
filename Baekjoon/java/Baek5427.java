import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek5427 {
    static int T;
    static char[][] map;
    static int w, h, result;
    static Queue<Point> person;
    static Queue<Point> fire;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static BufferedReader bf;
    static StringTokenizer st;
    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static void startInput() throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
    }

    static void input() throws IOException {

        person = new LinkedList<>();
        fire = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '@')
                    person.offer(new Point(i, j, 0));
                else if (map[i][j] == '*')
                    fire.offer(new Point(i, j, 0));
            }
        }
    }

    static void go() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            input();
            result = 0;
            bfs();
            if (result == 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(result+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void bfs() {
        while (!person.isEmpty()) {
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Point temp = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];
                    if (range(nx, ny))
                        if(map[nx][ny] == '.' || map[nx][ny] == '@') {
                            fire.offer(new Point(nx, ny, 0));
                            map[nx][ny] = '*';
                        }
                }
            }
            size = person.size();
            for (int i = 0; i < size; i++) {
                Point temp = person.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        result = temp.time + 1;
                        return;
                    }

                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        person.offer(new Point(nx, ny, temp.time + 1));
                    }
                }
            }
        }
    }

    static boolean range(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }

    public static void main(String[] args) throws IOException {
        startInput();
        go();
    }
}
