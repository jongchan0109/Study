import java.util.stream.Stream;

public class Exercise14_4 {
    public static void main(String[] args){
        String[] strArr = {"aaa","bb","c","dddd"};
        Stream<String> strStream = Stream.of(strArr);

        int sum = strStream.mapToInt(s->s.length()).sum();
        System.out.println(sum);
    }
}
