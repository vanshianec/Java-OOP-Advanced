

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        List<Field> fields = new ArrayList<>();
        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        Class<Reflection> reflectionClass = Reflection.class;
        Method methods [] = reflectionClass.getDeclaredMethods();
        Field allFields[] = reflectionClass.getDeclaredFields();

        for (Field field : allFields) {
            if(!Modifier.isPrivate(field.getModifiers())){
                fields.add(field);
            }
        }

        for (Method method : methods) {
            if(method.getName().startsWith("get") && !method.getReturnType().equals(void.class)){
                if(!Modifier.isPublic(method.getModifiers())){
                    getters.add(method);
                }
            }
            else if(method.getName().startsWith("set") && method.getReturnType().equals(void.class)){
                if(!Modifier.isPrivate(method.getModifiers())){
                    setters.add(method);
                }
            }

        }
        fields.stream().sorted((f1,f2) -> f1.getName().compareTo(f2.getName()))
                .forEach(field -> {
                    String name = field.getName();
                    System.out.printf("%s must be private!%n",name);
                });

        getters.stream().sorted((m1,m2) -> m1.getName().compareTo(m2.getName()))
        .forEach(method -> {
            String name = method.getName();
            System.out.printf("%s have to be public!%n",name);
        });
        setters.stream().sorted((m1,m2) -> m1.getName().compareTo(m2.getName()))
                .forEach(method -> {
                    String name = method.getName();
                    System.out.printf("%s have to be private!%n",name);
                });

    }


}

