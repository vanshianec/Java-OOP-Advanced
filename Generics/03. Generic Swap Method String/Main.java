import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        List<Box<String>> boxes = new ArrayList<>();
        while (N -- > 0){
            String value = reader.readLine();
            Box<String> box = new Box(value);
            boxes.add(box);
        }
        int [] indexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        Box.swap(boxes,firstIndex,secondIndex);
        boxes.forEach(System.out::println);
    }

}

