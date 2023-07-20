import java.text.SimpleDateFormat;
import java.util.*;

public class Exercise10_1 {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2010,0,1); // 2010년 1월 1일로 설정

        for(int i=0;i<12;i++){
            int weekday = c.get(Calendar.DAY_OF_WEEK);
            int secondSunday = (weekday==1)? 8: 16 -weekday;

            c.set(Calendar.DAY_OF_MONTH,secondSunday);
            Date d = c.getTime();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));

            c.add(Calendar.MONTH,1);
            c.set(Calendar.DAY_OF_MONTH,1);
        }
    }
}
