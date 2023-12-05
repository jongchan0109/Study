import java.io.*;

public class Baek7682 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static char[][] map;

    static void calculate(String str) throws IOException {
        map = new char[3][3];
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = str.charAt(3 * i + j);
                if (map[i][j] == 'X')
                    xCount++;
                else if (map[i][j] == 'O')
                    oCount++;
            }
        }
        // 완성된 경우

        // X로 완성된 경우
        if(bingo('X')){
            if(xCount == oCount+1 && !bingo('O'))
            {
                bw.append("valid\n");
                return;
            }
            bw.append("invalid\n");
            return;
        }
        // O로 완성된 경우
        if(bingo('O')){
            if(xCount == oCount){
                bw.append("valid\n");
                return;
            }
            bw.append("invalid\n");
            return;
        }
        if(xCount == 5 && oCount == 4)
        {
            bw.append("valid\n");
            return;
        }
        bw.append("invalid\n");

    }

    static boolean bingo(char ch) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == ch && map[i][1] == ch && map[i][2] == ch)
                return true;
            else if (map[0][i] == ch && map[1][i] == ch && map[2][i] == ch)
                return true;
        }
        if (map[0][0] == ch && map[1][1] == ch && map[2][2] == ch)
            return true;
        if (map[0][2] == ch && map[1][1] == ch && map[2][0] == ch)
            return true;
        return false;

    }

    static void go() throws IOException {
        while (true) {
            String str = bf.readLine();
            if (str.equals("end"))
                break;
            calculate(str);
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        go();
    }
}
