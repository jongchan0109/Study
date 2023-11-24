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
    static int[][] dp; // 추가된 부분
    static final int INF = 987654321;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        moves = new Move[N + 1];
        dp = new int[N + 1][K + 1]; // 추가된 부분

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int walkTime = Integer.parseInt(st.nextToken());
            int walkMoney = Integer.parseInt(st.nextToken());
            int rideTime = Integer.parseInt(st.nextToken());
            int rideMoney = Integer.parseInt(st.nextToken());

            moves[i] = new Move(walkTime, walkMoney, rideTime, rideMoney);
        }
    }

    // 최대 모금액 계산하는 함수
    static int go(int min, int index) {
        if (min < 0)
            return -INF;
        if (index == N+1)
            return 0;
        if (dp[index][min] != 0)
            return dp[index][min];

        // 재귀적인 경우 계산
        int walkCase = go(min - moves[index].walkTime, index + 1) + moves[index].walkMoney;
        int rideCase = go(min - moves[index].rideTime, index + 1) + moves[index].rideMoney;

        // 도보와 자전거 중에서 최대값 선택
        dp[index][min] = Math.max(walkCase, rideCase);

        return dp[index][min];
    }

    public static void main(String[] args) throws IOException {
        input();
        int answer = go(K, 1);
        System.out.println(answer);
    }
}
