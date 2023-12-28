package technologies.lambdaStreams;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(3);
        Integer a = 217;
        Integer b = 216;
        map.put(a, "First");
        map.put(b, "Second");
        map.put(218, "Three");

        int[] arr = new int[]{1,2,3,4,5};
        int [] res = Arrays.stream(arr).flatMap(value -> IntStream.of(value + 1).filter(value1 -> value1 > 2)).toArray();
        System.out.println(Arrays.toString(res));
    }
}
