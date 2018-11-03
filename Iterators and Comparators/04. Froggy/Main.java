import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("[, ]+")).map(Integer::parseInt).collect(Collectors.toList());
        Lake<Integer> lake = new Lake(numbers);
        List<String> result = new ArrayList<>();
        for (Integer integer : lake) {
            result.add(integer+"");
        }
        String uselessLine =reader.readLine();
        System.out.println(String.join(", ",result));



    }
}
