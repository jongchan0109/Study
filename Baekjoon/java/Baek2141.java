import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2141 {

    static int N;
    static Town[] towns;

    static long[] sum;
    static class Town implements Comparable<Town> {
        int location;
        int population;

        public Town(int location, int population) {
            this.location = location;
            this.population = population;
        }

        @Override
        public int compareTo(Town o) {
            return Integer.compare(this.location, o.location);
        }
    }

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        towns = new Town[N];
        sum = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int location = Integer.parseInt(st.nextToken());
            int population = Integer.parseInt(st.nextToken());

            towns[i] = new Town(location, population);
        }

    }

    static void go() {
        Arrays.sort(towns);
        sum[0] = towns[0].population;
        for(int i=1;i<N;i++){
            sum[i] = sum[i-1]+towns[i].population;
        }

        binarySearch();
    }

    static void binarySearch() {
        int left = 0;
        int right = N - 1;
        long dist = Long.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (sum[mid] >= sum[N - 1] - sum[mid]) {
                right = mid - 1;
                dist = Math.min(dist, towns[mid].location);
            } else {
                left = mid + 1;
            }
        }
        System.out.println(dist);
    }

    public static void main(String[] args) throws IOException {
        input();
        go();
    }
}
