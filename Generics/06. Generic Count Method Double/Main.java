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
        List<Box<Double>> boxes = new ArrayList<>();
        while (N -- > 0){
            Double value = Double.parseDouble(reader.readLine());
            Box<Double> box = new Box(value);
            boxes.add(box);
        }
        Box<Double> element = new Box(Double.parseDouble(reader.readLine()));
        System.out.println(Box.compareValues(boxes,element));

    }

}

