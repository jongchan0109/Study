class UnsupportedFuctionException extends RuntimeException{
    private final  int ERR_CODE;
    public UnsupportedFuctionException(String str,int errCode){
        super(str);
        ERR_CODE = errCode;
    }
    public int getErrorCode(){
        return ERR_CODE;
    }
    public String getMessage(){
        return "["+getErrorCode()+"]"+super.getMessage();
    }

}

class Exercise8_9
{
    public static void main(String[] args) throws Exception
    {
        throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
    }
}