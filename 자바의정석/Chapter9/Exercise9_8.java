class Exercise9_8 {
    static double round(double d, int n){
        int m = (int)Math.pow(10,n);
        d *= m;
        d += 0.5;
        return ((int)d)/((double)m);
    }
    public static void main(String[] args) {
        System.out.println(round(3.1415,1));
        System.out.println(round(3.1415,2));
        System.out.println(round(3.1415,3));
        System.out.println(round(3.1415,4));
        System.out.println(round(3.1415,5));
    }
}