

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        Class<Reflection> reflectionClass = Reflection.class;
        Method methods [] = reflectionClass.getDeclaredMethods();

        for (Method method : methods) {
            if(method.getName().startsWith("get") && !method.getReturnType().equals(void.class)){
                getters.add(method);
            }
            else if(method.getName().startsWith("set") && method.getReturnType().equals(void.class)){
                setters.add(method);
            }
        }
        getters.stream().sorted((m1,m2) -> m1.getName().compareTo(m2.getName()))
        .forEach(method -> {
            String name = method.getName();
            Class returnType = method.getReturnType();
            System.out.printf("%s will return %s%n",name,returnType);
        });
        setters.stream().sorted((m1,m2) -> m1.getName().compareTo(m2.getName()))
                .forEach(method -> {
                    String name = method.getName();
                    Class[] parameterTypes = method.getParameterTypes();
                    System.out.printf("%s and will set field of %s%n",name,parameterTypes[0]);
                });

    }


}

