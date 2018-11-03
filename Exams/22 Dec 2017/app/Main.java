package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.engines.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.models.participants.Boss;
import app.models.participants.Character;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader consoleReader = new ConsoleReader();
        Writer consoleWriter = new ConsoleWriter();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        ActionFactory actionFactory = new ActionFactoryImpl();
        Battlefield battlefield = new BattlefieldImplementation(consoleWriter,targetableFactory,actionFactory);
        Engine engine = new EngineImpl(consoleReader,consoleWriter,battlefield);
        engine.run();




    }
}
