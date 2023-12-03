import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek16235 {
    static int N, M, K;
    static int[][] map;
    static int[][] plus;
    static int x, y, z;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static Deque<Tree> treeList = new LinkedList<>();

    static class Tree implements Comparable<Tree> {
        int posX, posY, age;

        public Tree(int posX, int posY, int age) {
            this.posX = posX;
            this.posY = posY;
            this.age = age;
        }

        @Override
        public int compareTo(Tree otherTree) {
            return this.age-otherTree.age;
        }
    }


    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        plus = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                plus[j][i] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            treeList.add(new Tree(x, y, z));
        }
    }

    static void go() {
        for (int time = 0; time < K; time++) {

            Queue<Tree> dieList = new LinkedList<>();



            for (int i = 0; i < treeList.size();) { // 봄
                Tree tree = treeList.poll();
                if (map[tree.posY][tree.posX] >= tree.age) {
                    map[tree.posY][tree.posX] -= tree.age;
                    tree.age++;
                    treeList.add(tree);
                    i++;
                } else {
                    dieList.add(tree);
                }
            }
            int size = dieList.size();


            for (Tree t : dieList) {
                map[t.posY][t.posX] += t.age / 2;
            }


            size = treeList.size();
            Queue<Tree> tempList = new LinkedList<>();


            for (Tree t : treeList) {
                if (t.age % 5 == 0) {
                    tempList.add(t);
                }
            }

            while (!tempList.isEmpty()) {
                Tree t = tempList.poll();
                for (int i = 0; i < 8; i++) {
                    int nX = t.posX + dx[i];
                    int nY = t.posY + dy[i];
                    if (range(nX, nY)) {
                        treeList.addFirst(new Tree(nX, nY, 1));
                    }
                }
            }

            for (int i = 1; i <= N; i++) { //겨울
                for (int j = 1; j <= N; j++) {
                    map[i][j] += plus[i][j];
                }
            }
        }
        System.out.println(treeList.size());

    }

    static boolean range(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    public static void main(String args[]) throws IOException {
        input();
        go();
    }
}
