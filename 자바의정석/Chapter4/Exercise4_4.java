public class Exercise4_4 {
    public static void main(String[] args){
        int sum = 0;
        int sign = 1;
        int i=1;
        while (true){
            sum += i*sign;
            if(sum>=100)
                break;
            i+=1;
            sign *= -1;
        }
        System.out.println(i);
    }
}
