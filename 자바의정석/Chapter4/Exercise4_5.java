public class Exercise4_5 {
    public static void main(String[] args){
        int i=0;
        int j;
        while(i<=10){
            j = 0;
            while(j<=i)
            {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
