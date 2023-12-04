import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek4485 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int problemCount = 1;
    static int n;
    static int[][] map;
    static int[][] calculateArray;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void input() throws IOException {
        map = new int[n][n];
        calculateArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                calculateArray[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        calculateArray[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (range(nx, ny)) {
                    int newCost = map[nx][ny] + calculateArray[x][y];
                    if (newCost < calculateArray[nx][ny]) {
                        calculateArray[nx][ny] = newCost;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static void go() throws IOException {
        while (true) {
            n = Integer.parseInt(bf.readLine());
            if (n == 0)
                break;
            input();
            bfs();
            bw.write("Problem " + problemCount + ": " + calculateArray[n - 1][n - 1] + "\n");
            problemCount++;
        }
        bw.flush();
        bw.close();
    }

    static boolean range(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException {
        go();
    }
}
