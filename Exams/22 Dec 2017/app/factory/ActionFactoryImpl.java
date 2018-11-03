package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return (Action)Class.forName("app.models.actions."+actionName).getDeclaredConstructor().newInstance();
    }
}
