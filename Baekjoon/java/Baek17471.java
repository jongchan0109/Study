import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17471 {
    static int N;
    static int[][] incidentArray;
    static int[] population;
    static boolean selected[];
    static int minValue;

    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        incidentArray = new int[N][N];
        population = new int[N];
        selected = new boolean[N];
        minValue = Integer.MAX_VALUE;
        st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            population[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int x=0;x<m;x++){
                int j = Integer.parseInt(st.nextToken());
                incidentArray[i][j-1] = 1;
            }
        }
    }
    public static void divide(int index){
        if(index == N){
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(selected[i])
                    aList.add(i);
                else
                    bList.add(i);
            }
            if(aList.size()==N || aList.size()==0)
                return;

            if(BFS(aList) && BFS(bList)){
                calculate(aList,bList);
            }
            return;
        }

        selected[index] = true;
        divide(index+1);
        selected[index] = false;
        divide(index+1);
    }

    public static void calculate(List<Integer> aList, List<Integer> bList){
        int aSum = 0;
        int bSum = 0;
        for(int i=0;i<aList.size();i++){
            aSum += population[aList.get(i)];
        }
        for(int i=0;i<bList.size();i++){
            bSum += population[bList.get(i)];
        }
        int dif = Math.abs(aSum-bSum);
        if(dif<minValue){
            minValue = dif;
        }

    }
    public static boolean BFS(List<Integer> list){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N];
        isVisited[list.get(0)] = true;
        queue.offer(list.get(0));
        int count = 1;

        while(!queue.isEmpty()){
            int qur = queue.poll();
            for(int i=0;i<N;i++){
                if(incidentArray[qur][i]==1 && list.contains(i)&& isVisited[i]==false){
                    queue.offer(i);
                    isVisited[i] = true;
                    count++;
                }
            }
        }
        if(count ==list.size())
            return true;
        else
            return false;
    }
    public static void go(){
        divide(0);
        if(minValue == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(minValue);
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
