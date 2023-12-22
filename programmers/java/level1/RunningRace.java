package level1;

import java.util.HashMap;
import java.util.Map;

public class RunningRace {

    public static String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map  = new HashMap<>();

        // 등수 초기화
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        // 호출에 기반하여 등수 업데이트
        for (String racer : callings) {
            int currentRank = map.get(racer);

            String frontPlayer = players[currentRank-1];
            map.replace(racer, currentRank - 1);
            map.replace(frontPlayer,currentRank);

            players[currentRank] = frontPlayer;
            players[currentRank-1] = racer;

        }
        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai","mine"};
        String[] callings = {"kai", "kai","mine","mine"};

        String[] result = solution(players, callings);

        // 결과 출력
        for (String entry : result) {
            System.out.println(entry);
        }
    }
}
