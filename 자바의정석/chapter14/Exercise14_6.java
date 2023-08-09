import java.util.*;
import java.util.stream.*;

public class Exercise14_6 {
    public static void main(String[] args){
        new Random().ints(1,46).distinct().limit(6).sorted().forEach(System.out::println);
    }
}
