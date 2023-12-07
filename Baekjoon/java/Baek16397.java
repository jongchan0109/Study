import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16397 {

    static class Point{
        int index;
        int distance;

        public Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    static int N,T,G;
    static boolean[] isVisit;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        isVisit = new boolean[100000];
    }

    static void BFS() throws IOException{
        Point startPoint = new Point(N,0);
        isVisit[N]=true;
        Queue<Point> queue = new LinkedList<>();

        int result = -1;

        queue.offer(startPoint);
        Point current = startPoint;

        while(!queue.isEmpty()){
            current = queue.poll();
            if (current.index == G) {
                result = current.distance;
                break;
            }

            if(current.distance + 1 > T)
                continue;

            int nextA = current.index + 1;

            if (nextA < 100000 && !isVisit[nextA]) {
                isVisit[nextA] = true;
                queue.offer(new Point(nextA, current.distance + 1));
            }


            int nextB = current.index * 2;

            if (nextB <= 99999 && nextB>0) {
                int nextBReduced = B(nextB);
                if (!isVisit[nextBReduced]) {
                    isVisit[nextBReduced] = true;
                    queue.offer(new Point(nextBReduced, current.distance + 1));
                }
            }

        }

        if(result!=-1){
            bw.write(current.distance+"\n");
        }
        else {
            bw.write("ANG");
        }
        bw.flush();
        bw.close();
    }
    static int B(int x) {
        int result = 0, idx = 10;
        int[] arr = new int[5];

        for(int i = 0, k = 10000; i < 5; i++, k /= 10) {
            arr[i] = (x / k) % 10;

            if(arr[i] != 0)
                idx = Math.min(idx, i);
        }

        arr[idx]--;

        for(int i = 0, k = 10000; i < 5; i++, k /= 10)
            result += arr[i] * k;

        return result;
    }
    public static void main(String[] args) throws IOException {
        input();
        BFS();
    }
}
