package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class characterClass =  Class.forName("app.models.participants."+className);
        Targetable character = (Targetable) characterClass.getDeclaredConstructor(String.class).newInstance(name);
        return character;
    }
}
