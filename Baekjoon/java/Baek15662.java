import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15662 {

    static class Gear{
        char[] cog;

        public Gear(String str) {
            cog = new char[8];

            for(int i=0;i<8;i++){
                if(str.charAt(i)=='1')
                    cog[i] = 'S';
                else
                    cog[i] = 'N';
            }
        }
        void turnRight(){
            char temp = cog[0];

            for(int i = 8;i>1;i--){
                cog[i%8] = cog[i-1];
            }
            cog[1] = temp;
        }
        void turnLeft(){
            char temp = cog[0];
            for(int i=0;i<7;i++){
                cog[i] = cog[i+1];
            }
            cog[7] = temp;
        }

        @Override
        public String toString(){
            String str = "";
            for(int i=0;i<8;i++){
                str+=cog[i];
            }
            return str;
        }
    }

    static Gear[] gears;
    static int N;

    static int T;
    static int[] select;
    static int[] leftRight;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        gears = new Gear[N+1];


        for(int i=1;i<=N;i++){
            String str = bf.readLine();
            gears[i] = new Gear(str);
        }
        T = Integer.parseInt(bf.readLine());
        select = new int[T];
        leftRight = new int[T];

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            select[i] = Integer.parseInt(st.nextToken());
            leftRight[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void rotation(int sel, int leftOrRight){
        Gear current = gears[sel];
        Gear temp;


        char save1 = current.cog[6];
        char save2 = current.cog[2];


        if(leftOrRight == -1)
            current.turnLeft();
        else
            current.turnRight();

        int sign = leftOrRight;
        int idx = sel-1;

        while(idx>=1){
            temp =gears[idx];
            if(temp.cog[2] == save1)
                break;
            save1 = temp.cog[6];
            if(sign==-1)
            {
                temp.turnRight();
                sign = 1;
            }
            else{
                temp.turnLeft();
                sign = -1;
            }
            idx--;
        }

        idx = sel+1;
        sign = leftOrRight;

        while(idx<=N){
            temp = gears[idx];
            if(temp.cog[6] == save2)
                break;
            save2 = temp.cog[2];
            if(sign==-1)
            {
                temp.turnRight();
                sign = 1;
            }
            else{
                temp.turnLeft();
                sign = -1;
            }
            idx++;
        }

    }

    static void go(){
        for(int i=0;i<T;i++){
            rotation(select[i],leftRight[i]);
        }

        int sum = 0;
        for(int i=1;i<=N;i++){
            if(gears[i].cog[0]=='S')
                sum++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
    }
}
