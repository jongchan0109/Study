class Exercise9_6 {
    public static String fillZero(String src, int length) {
        if (src == null || src.length() == length)
            return src;
        else if (length <= 0)
            return "";
        else if(src.length()>length)
            return src.substring(0,length);
        else {
            char[] cpy = new char[length];
            for (int i = 0; i < length; i++)
                cpy[i] = '0';
            for (int i = 0; i < src.length(); i++)
                cpy[i] = src.charAt(i);
            return new String(cpy);
        }

    }

    public static void main(String[] args) {
        String src = "12345";
        System.out.println(fillZero(src, 10));
        System.out.println(fillZero(src, -1));
        System.out.println(fillZero(src, 3));
    }
}