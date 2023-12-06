import java.io.*;
import java.util.StringTokenizer;

public class Baek17406 {

    static class Rotate{
        int r,c,s;

        public Rotate(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean cross(Point other){
            if(this.x>=other.x && this.y >=other.y)
                return true;
            return false;
        }
    }
    static int N,M,K;
    static int[][] arr;
    static Rotate[] rotates;
    static int min = Integer.MAX_VALUE;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        rotates = new Rotate[K];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            int r,c,s;
            st = new StringTokenizer(bf.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            rotates[i] = new Rotate(r,c,s);
        }

    }
    static void rotate(int[][] map, Point topLeft, Point bottomRight) {
        if (topLeft.cross(bottomRight))
            return;

        int temp = map[topLeft.x][topLeft.y];

        // 위 -> 오른쪽
        for (int i = topLeft.x; i < bottomRight.x; i++)
            map[i][topLeft.y] = map[i + 1][topLeft.y];

        // 오른쪽 -> 아래쪽
        for (int j = topLeft.y; j < bottomRight.y; j++)
            map[bottomRight.x][j] = map[bottomRight.x][j + 1];

        // 아래쪽 -> 왼쪽
        for (int i = bottomRight.x; i > topLeft.x; i--)
            map[i][bottomRight.y] = map[i - 1][bottomRight.y];

        // 왼쪽 -> 위
        for (int j = bottomRight.y; j > topLeft.y + 1; j--)
            map[topLeft.x][j] = map[topLeft.x][j - 1];

        map[topLeft.x][topLeft.y + 1] = temp;

        rotate(map, new Point(topLeft.x + 1, topLeft.y + 1), new Point(bottomRight.x - 1, bottomRight.y - 1));
    }


    static void calculate(int[][] map){
        for(int i=1;i<=N;i++){
            int sum = 0;
            for(int j= 1;j<=M;j++){
                sum += map[i][j];
            }
            min = Math.min(min,sum);
        }
    }

    static int[][] copyArr(){
        int[][] map = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                map[i][j] = arr[i][j];
            }
        }
        return map;
    }
    static void swap(int[] indices, int i, int depth){
        int temp = indices[i];
        indices[i] = indices[depth];
        indices[depth] = temp;
    }

    static void permuteRotations(int[] indices, int depth) throws IOException {
        if (depth == K) {
            int[][] map = copyArr();
            for (int i = 0; i < K; i++) {
                Rotate rotation = rotates[indices[i]];
                Point topLeft = new Point(rotation.r - rotation.s, rotation.c - rotation.s);
                Point bottomRight = new Point(rotation.r + rotation.s, rotation.c + rotation.s);
                rotate(map, topLeft, bottomRight);
            }
            calculate(map);
            return;
        }

        for (int i = depth; i < K; i++) {
            swap(indices, i, depth);
            permuteRotations(indices, depth + 1);
            swap(indices, i, depth);  // 원상복구
        }
    }

    static void applyRotations() throws IOException {
        int[] indices = new int[K];
        for (int i = 0; i < K; i++) {
            indices[i] = i;
        }
        permuteRotations(indices, 0);
    }

    static void go() throws IOException{
        applyRotations();


        bw.write(min+"\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
