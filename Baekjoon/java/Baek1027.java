import java.io.*;
import java.util.StringTokenizer;

public class Baek1027 {

    static class Building{
        int height;
        int location;
        int count;

        public Building(int height, int location) {
            this.height = height;
            this.location = location;
            this.count = 0;
        }
    }

    static int N;
    static Building[] buildings;


    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        buildings = new Building[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++)
            buildings[i] = new Building(Integer.parseInt(st.nextToken()),i);
    }

    static int calculate(int idx){
        int cnt = 0;
        double tmp = 0.0;

        for(int i=idx-1;i>=1;i--){
            double slope = (double) (buildings[idx].height - buildings[i].height)/(idx-i);

            if(i == idx-1 || tmp>slope){
                cnt++;
                tmp = slope;
            }
        }

        for(int i=idx+1;i<=N;i++){
            double slope = (double) (buildings[idx].height - buildings[i].height)/(idx-i);

            if(i == idx+1 || tmp<slope){
                cnt++;
                tmp = slope;
            }
        }
        return cnt;
    }



    static void go() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1;i<=N;i++){
            buildings[i].count = calculate(i);
        }

        int max = 0;

        for(int i=1;i<=N;i++){
            max = Math.max(buildings[i].count,max);
        }

        bw.append(max+"\n");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
