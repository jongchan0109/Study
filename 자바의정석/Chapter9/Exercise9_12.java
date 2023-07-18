class Exercise9_12
{
    public static int getRand(int from,int to){
        if(from>to){
            int temp = from;
            from = to;
            to = temp;
        }
        return from + (int)(Math.random()*(to-from+1));
    }
    public static void main(String[] args)
    {
        for(int i=0; i< 20; i++)
            System.out.print(getRand(1,-3)+",");
    }
}