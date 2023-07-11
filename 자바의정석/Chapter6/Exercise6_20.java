class Exercise6_20
{
    static int[] shuffle(int[] arr){
        if(arr==null ||arr.length==0)
            return arr;

        int n = arr.length;
        int[] result = new int[n];
        System.arraycopy(arr,0,result,0,n);

        for(int i=0;i<n;i++){
            int tmp =0;
            int idx = (int)(Math.random()*n);
            tmp = result[i];
            result[i] = result[idx];
            result[idx] =tmp;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result));
    }
}