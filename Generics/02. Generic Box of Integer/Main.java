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
        List<Box<Integer>> boxes = new ArrayList<>();
        while (N -- > 0){
            int value = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box(value);
            boxes.add(box);
        }

        boxes.forEach(System.out::println);
    }

}

