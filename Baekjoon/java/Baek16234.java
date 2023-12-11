import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16234 {

    static class Country{
        boolean east,south,isVisit, west, north;
        int population;
        int r,c;

        public Country(int population,int r,int c) {
            this.east = false;
            this.south = false;
            this.isVisit = false;
            this.west = false;
            this.north = false;
            this.population = population;
            this.r = r;
            this.c = c;
        }
    }
    static int N,L,R;

    static Country[][] map;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new Country[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = new Country(Integer.parseInt(st.nextToken()),i,j);
            }
        }
    }

    static int openCountry(){
        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j!= N-1){
                    int abs = Math.abs(map[i][j].population - map[i][j+1].population);
                    if(L <= abs && abs<= R) {
                        map[i][j].east = true;
                        map[i][j+1].west = true;
                        count++;
                    }
                }
                if(i != N-1){
                    int abs = Math.abs(map[i][j].population - map[i+1][j].population);
                    if(L <= abs && abs<= R) {
                        map[i][j].south = true;
                        map[i+1][j].north = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static void move(){
        Queue<Country> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j].isVisit)
                    continue;

                map[i][j].isVisit = true;
                if(map[i][j].east == false && map[i][j].south == false && map[i][j].north == false && map[i][j].west == false)
                    continue;
                queue.offer(map[i][j]);
                Queue<Country> copyQueue = new LinkedList<>();
                int sum = 0;

                while(!queue.isEmpty()){
                    Country current = queue.poll();
                    copyQueue.offer(current);
                    sum += current.population;

                    if(current.east && !map[current.r][current.c+1].isVisit){
                        Country next = map[current.r][current.c+1];
                        next.isVisit = true;
                        queue.offer(next);
                    }

                    if(current.south && !map[current.r+1][current.c].isVisit){
                        Country next = map[current.r+1][current.c];
                        next.isVisit = true;
                        queue.offer(next);
                    }

                    if(current.west && !map[current.r][current.c-1].isVisit){
                        Country next = map[current.r][current.c-1];
                        next.isVisit = true;
                        queue.offer(next);
                    }

                    if(current.north && !map[current.r-1][current.c].isVisit){
                        Country next = map[current.r-1][current.c];
                        next.isVisit = true;
                        queue.offer(next);
                    }
                }
                sum /= copyQueue.size();

                while(!copyQueue.isEmpty()){
                    Country current = copyQueue.poll();
                    map[current.r][current.c].population = sum;
                }
            }
        }
    }

    static void close(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                map[i][j].east = false;
                map[i][j].south = false;
                map[i][j].west = false;
                map[i][j].north = false;
                map[i][j].isVisit = false;
            }
        }
    }

    static void go(){
        int cnt = 0;

        while(true){
            int moveResult = openCountry();
            if(moveResult == 0)
                break;
            move();
            close();
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
