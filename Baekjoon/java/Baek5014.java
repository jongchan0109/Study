import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek5014 {
    static int F, S, G, U, D;
    static boolean[] isVisited;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        isVisited = new boolean[F + 1];
    }

    static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        isVisited[S] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == G) {
                    return moves;
                }
                if (current + U <= F && !isVisited[current + U]) {
                    queue.offer(current + U);
                    isVisited[current + U] = true;
                }
                if (current - D > 0 && !isVisited[current - D]) {
                    queue.offer(current - D);
                    isVisited[current - D] = true;
                }
            }
            moves++;
        }

        return -1; // 목표 층에 도달할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        input();
        int result = BFS();
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }
}
