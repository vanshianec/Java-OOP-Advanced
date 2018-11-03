

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Field> privateFields = new ArrayList<>();
        List<Field> protectedFields = new ArrayList<>();
        List<Field> publicFields = new ArrayList<>();
        List<Field> allFields = Arrays.stream(RichSoilLand.class.getDeclaredFields()).collect(Collectors.toList());

        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            } else if (Modifier.isProtected(field.getModifiers())) {
                protectedFields.add(field);
            } else if (Modifier.isPublic(field.getModifiers())) {
                publicFields.add(field);
            }
        }

        String command = reader.readLine();
        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    for (Field privateField : privateFields) {
                        System.out.printf("private %s %s%n", privateField.getType().getSimpleName(), privateField.getName());
                    }
                    break;
                case "protected":
                    for (Field protectedField : protectedFields) {
                        System.out.printf("protected %s %s%n", protectedField.getType().getSimpleName(), protectedField.getName());
                    }
                    break;
                case "public":
                    for (Field publicField : publicFields) {
                        System.out.printf("public %s %s%n", publicField.getType().getSimpleName(), publicField.getName());
                    }
                    break;
                case "all":
                    for (Field field : allFields) {
                        System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
                    }
                    break;
            }
            command = reader.readLine();

        }


    }
}

