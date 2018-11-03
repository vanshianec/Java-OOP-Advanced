

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<Reflection> aClass = Reflection.class;

        System.out.println(aClass);

        System.out.println(aClass.getSuperclass());

        Class[] interfaces = aClass.getInterfaces();

        for (Class anInterface : interfaces){
            System.out.println(anInterface);
        }
//Reflection ref = aClass.newInstance();//Deprecated since Java 9

        Reflection ref = aClass.getDeclaredConstructor().newInstance();

        System.out.println(ref);
    }


}

