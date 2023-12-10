import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek17144 {

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R,C,T;
    static int machineHigh=-1, machineLow=-1;
    static int[][] map;

    static void input() throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && machineHigh ==-1){
                    machineHigh = i;
                    machineLow = i+1;
                }
            }
        }
    }

    static void diffusion(){
        Queue<Point> queue= new LinkedList<>();

        int[][] copyMap = new int[R][C];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                copyMap[i][j] = 0;
                if(map[i][j]>=1)
                    queue.offer(new Point(i,j));
            }
        }


        while(!queue.isEmpty()){
            Point current = queue.poll();
            int r = current.x;
            int c = current.y;

            int count = 0;
            int weight = map[r][c]/5;

            if(r>0 && map[r-1][c]!=-1){ // 위로
                count++;
                copyMap[r-1][c] += weight;
            }

            if(r<R-1 && map[r+1][c]!=-1){ //아래로
                count++;
                copyMap[r+1][c] += weight;
            }

            if(c>0 && map[r][c-1]!=-1){
                count++;
                copyMap[r][c-1] += weight;
            }

            if(c<C-1){
                count++;
                copyMap[r][c+1] += weight;
            }
            copyMap[r][c] += -1 * weight * count;
        }


        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                map[i][j]+=copyMap[i][j];
            }
        }
    }

    static void operation(){

        for(int i=machineHigh-1;i>0;i--)
            map[i][0] = map[i-1][0];
        for(int i=0;i<C-1;i++)
            map[0][i] = map[0][i+1];
        for(int i=0;i<machineHigh;i++)
            map[i][C-1] = map[i+1][C-1];
        for(int i=C-1;i>1;i--)
            map[machineHigh][i] = map[machineHigh][i-1];
        map[machineHigh][1] = 0;


        for(int i=machineLow+1;i<R-1;i++)
            map[i][0] = map[i+1][0];
        for(int i=0;i<C-1;i++)
            map[R-1][i] = map[R-1][i+1];
        for(int i=R-1;i>machineLow;i--)
            map[i][C-1] = map[i-1][C-1];
        for(int i=C-1;i>1;i--)
            map[machineLow][i] = map[machineLow][i-1];
        map[machineLow][1]=0;
    }


    static void go() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<T;i++){
            diffusion();
            operation();
        }

        int sum = 0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]==-1)
                    continue;
                sum +=map[i][j];
            }
        }
        bw.append(sum+"\n");

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
