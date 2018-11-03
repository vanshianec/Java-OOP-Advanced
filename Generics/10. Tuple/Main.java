import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        String firstName = firstLine.split(" ")[0]+ " " + firstLine.split(" ")[1];
        String secondName = firstLine.split(" ")[2];
        String secondLine = reader.readLine();
        String name = secondLine.split(" ")[0];
        int liters = Integer.parseInt(secondLine.split(" ")[1]);
        String thirdLine = reader.readLine();
        int integer = Integer.parseInt(thirdLine.split(" ")[0]);
        double d = Double.parseDouble(thirdLine.split(" ")[1]);

        Tuple<String,String> t1 = new Tuple<>(firstName,secondName);
        Tuple<String,Integer> t2 = new Tuple<>(name,liters);
        Tuple<Integer,Double> t3 = new Tuple<>(integer,d);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

    }


}


