public class Exercise4_3 {
    public static void main(String[] args) {
        int totalSum = 0;
        int sum = 0;
        for(int i=1;i<=10;i++)
        {
            sum +=i;
            totalSum +=sum;
        }
        System.out.println(totalSum);
    }
}
