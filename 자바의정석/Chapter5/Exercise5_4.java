class Exercise5_4
{
    public static void main(String[] args)
    {
        int[][] arr = {
                { 5, 5, 5, 5, 5},
                {10,10,10,10,10},
                {20,20,20,20,20},
                {30,30,30,30,30}
        };
        int total = 0;
        float average = 0;
        for(int[] sub:arr){
            for(int value:sub)
                total+=value;
        }
        average = total/20.0f;
        System.out.println("total="+total);
        System.out.println("average="+average);
    } // end of main
} // end of class