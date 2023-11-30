import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak17070 {
    static int N;
    static int[][] array;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        array = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int move(int x, int y, int state) { // state ==1 가로, state==2 세로, state==3 대각선
        if (x == N && y == N)
            return 1;

        int count = 0;

        if (state == 1) {
            if (y + 1 <= N && array[x][y+1] == 0) {
                count += move(x, y+1, 1); // 가로 이동
            }
        } else if (state == 2) {
            if (x + 1 <= N && array[x+1][y] == 0) {
                count += move(x+1, y, 2);
            }
        } else {
            if (y+1 <= N && array[x][y+1] == 0) {
                count += move(x, y+1, 1);
            }
            if (x + 1 <= N && array[x+1][y] == 0) {
                count += move(x+1, y , 2);
            }
        }
        if (x + 1 <= N && y + 1 <= N && array[x + 1][y + 1] == 0 && array[x][y + 1] == 0 && array[x + 1][y] == 0)
            count += move(x + 1, y + 1, 3);
        return count;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(move(1, 2, 1));
    }
}
