

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<BlackBoxInt> reflectionClass = BlackBoxInt.class;
        Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt)constructor.newInstance();

        Method[] methods = reflectionClass.getDeclaredMethods();
        String input = reader.readLine();
        while(!input.equals("END")){
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);
            for (Method method : methods) {
                if(command.equals(method.getName())){
                    method.setAccessible(true);
                    method.invoke(blackBoxInt,value);
                    Field field = reflectionClass.getDeclaredField("innerValue");
                    field.setAccessible(true);
                    System.out.println(field.get(blackBoxInt));
                }
            }

            input = reader.readLine();
        }


    }
}

