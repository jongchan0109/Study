import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14863 {
    static class Move {
        int walkTime;
        int walkMoney;
        int rideTime;
        int rideMoney;

        Move(int walkTime, int walkMoney, int rideTime, int rideMoney) {
            this.walkTime = walkTime;
            this.walkMoney = walkMoney;
            this.rideTime = rideTime;
            this.rideMoney = rideMoney;
        }
    }

    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static Move[] moves;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        moves = new Move[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int walkTime = Integer.parseInt(st.nextToken());
            int walkMoney = Integer.parseInt(st.nextToken());
            int rideTime = Integer.parseInt(st.nextToken());
            int rideMoney = Integer.parseInt(st.nextToken());

            moves[i] = new Move(walkTime, walkMoney, rideTime, rideMoney);
        }
    }

    static void go() {
        // DP 배열 초기화
        int[][] dp = new int[N + 1][K + 1];

        // DP 진행
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i][moves[i].walkTime] = moves[i].walkMoney;
                dp[i][moves[i].rideTime] = moves[i].rideMoney;
            } else {
                for (int j = 0; j <= K; j++) {
                    // 도보 이동
                    if (dp[i - 1][j] == 0)
                        continue;

                    if (j + moves[i].walkTime <= K) {
                        dp[i][j + moves[i].walkTime] = Math.max(dp[i][j + moves[i].walkTime], dp[i - 1][j] + moves[i].walkMoney);
                    }

                    // 자전거 이동
                    if (j + moves[i].rideTime <= K) {
                        dp[i][j + moves[i].rideTime] = Math.max(dp[i][j + moves[i].rideTime], dp[i - 1][j] + moves[i].rideMoney);
                    }

                }
            }
        }
        // 최대 모금액 찾기
        int maxMoney = 0;
        for (int j = 0; j <= K; j++) {
            maxMoney = Math.max(maxMoney, dp[N][j]);
        }

        System.out.println(maxMoney);
    }

    public static void main(String[] args) throws IOException {
        input();
        go();
    }
}
