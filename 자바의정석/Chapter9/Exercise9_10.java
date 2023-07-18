class Exercise9_10
{
    public static String format(String str,int length,int alignment){
        int diff = length-str.length();
        if(diff<0)
            return str.substring(0,length);
        char[] source = str.toCharArray();
        char[] result = new char[length];
        for(int i=0;i<result.length;i++)
            result[i] = ' ';
        switch (alignment){
            case 0:
            default :
                System.arraycopy(source,0,result,0,source.length);
                break;
            case 1:
                System.arraycopy(source,0,result,diff/2,source.length);
                break;
            case 2:
                System.arraycopy(source,0,result,diff,source.length);
                break;
        }
        return new String(result);

    }
    public static void main(String[] args) {
        String str = "가나다";
        System.out.println(format(str,7,0)); // 왼쪽 정렬
        System.out.println(format(str,7,1)); // 가운데 정렬
        System.out.println(format(str,7,2)); // 오른쪽 정렬
    }
}