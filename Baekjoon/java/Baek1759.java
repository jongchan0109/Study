import java.util.*;
import java.io.*;

public class Baek1759{
    static int L, C;
    static char[] password, input; // 출력할 배열과 입력 받은 문자 넣을 배열
    static boolean[] isLow; // 모음 인지 체크할 배열
    static boolean[] isChecked; // 방문 처리 할 배열
    static StringBuilder sb = new StringBuilder();

public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 문자 후보 갯수

        input = new char[C]; // 입력받은 암호가 될 수 있는 문자 배열
        isChecked = new boolean[C]; // 방문 처리 할 배열
        isLow = new boolean[C]; // 모음 체크 할 배열
        password = new char[C]; // 출력할 암호 배열

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<input.length; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input); // 알파벳이 증가하는 순서로 배열됨

        // 모음은 true 처리
        for(int i=0; i<input.length; i++) {
            if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
                isLow[i] = true;
            }
        }

        bt(0, 0, 0, 0);
        System.out.println(sb);
        }

static void bt(int depth, int start, int momCnt, int sonCnt) {
        /*
         * depth: 조합된 암호의 길이
         * start: 조합할 암호가 알파벳 순으로 오름차순으로 나올 수 있도록 함
         * momCnt: 모음의 갯수
         * sonCnt: 자음의 갯수
         */

        // 조합된 암호의 길이가 L && 모음의 수가 1개 이상 && 자음의 수가 2개 이상
        if(depth == L && momCnt >= 1 && sonCnt >= 2) {
            for(int i=0; i<L; i++) {
                sb.append(password[i]);
        }
        sb.append("\n");
        return;
        }

        for(int i=start; i<input.length; i++) {
            int mom = momCnt;
            int son = sonCnt;
        // 아직 방문하지 않은 문자라면?
        if(!isChecked[i]) {
            if(isLow[i]) { // 현재 문자가 모음이면 모음 갯수 +1
                mom++;
            }
            else { // 현재 문자가 자음이면 자음 갯수 +1
                son++;
            }
            // 현재 문자를 방문처리 해주고 재귀호출 할 수 있도록 함
            isChecked[i] = true;
            // 암호 조합 배열에 현재 문자 넣음
            password[depth] = input[i];
            // 재귀 호출
            bt(depth + 1, i, mom, son);
            // for문의 다음 i를 위해 방문처리 해제
            isChecked[i] = false;
            }
        }
    }
}
