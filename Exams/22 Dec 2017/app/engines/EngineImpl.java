package app.engines;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Reader reader;
    private Writer writer;
    private Battlefield battleField;
    private static final String TERMINATE_COMMAND = "Peace";
    private static final String INVALID_COMMAND_MESSAGE = "Invalid command";

    public EngineImpl(Reader reader, Writer writer, Battlefield battleField) throws IOException {
        this.reader = reader;
        this.writer = writer;
        this.battleField = battleField;
    }

    @Override
    public void run() throws IOException {
        String line = reader.readLine();
        while (!TERMINATE_COMMAND.equals(line)) {
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0].toLowerCase()) {
                case "createparticipant":
                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case "createaction":
                    String[] participants = new String[lineTokens.length-2];
                    for (int i=0;i<participants.length;i++){
                        participants[i] = lineTokens[i+2];
                    }
                    battleField.createAction(lineTokens[1],participants );
                    break;
                case "createspecial":
                    battleField.createSpecial(lineTokens[1],lineTokens[2]);
                case "statparticipants":
                    battleField.reportParticipants();
                    break;
                case "statactions":
                    battleField.reportActions();
                    break;
                default:
                    writer.writeLine(INVALID_COMMAND_MESSAGE);
                    break;
            }

            line = reader.readLine();
        }
    }
}
