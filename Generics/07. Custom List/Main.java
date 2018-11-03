import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<>();
        String[] command = reader.readLine().split(" ");
        String element;
        while(!command[0].equals("END")) {

            switch (command[0]) {
                case "Add":
                    String value = command[1];
                    list.add(value);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    element = command[1];
                    System.out.println(list.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = command[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.Print();
                    break;

            }
            command = reader.readLine().split(" ");
        }

    }


}


