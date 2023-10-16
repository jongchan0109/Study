import java.io.*;
import java.util.*;

public class Baek9466 {

    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    static void dfs(int current) {
        visited[current] = true;
        int next = students[current];

        if (visited[next]) {
            if (!finished[next]) {
                for (int i = next; i != current; i = students[i]) {
                    cnt++;
                }
                cnt++;
            }
        } else {
            dfs(next);
        }

        finished[current] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - cnt);
        }
    }
}
