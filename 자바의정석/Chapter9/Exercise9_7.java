class Exercise9_7 {
    static boolean contains(String src,String target) {
        int i = src.indexOf(target);
        if (i == -1) {
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        System.out.println(contains("12345","23"));
        System.out.println(contains("12345","67"));
    }
}