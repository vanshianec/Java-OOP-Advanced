package app.core;

import app.contracts.*;
import app.io.ConsoleWriter;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static app.constansts.Constants.*;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;

    public BattlefieldImplementation(Writer writer, TargetableFactory targetableFactory, ActionFactory actionFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = targetableFactory;
        this.actionFactory = actionFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action = actionFactory.create(actionName, participantNames);

            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames) {
                if (this.participants.containsKey(name)) {
                    actionParticipants.add(this.participants.get(name));
                } else {
                    writer.writeLine(String.format(NOT_ON_THE_BATTLEFIELD_MESSAGE_FORMAT, name, actionName));
                    return;
                }
            }

            writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            writer.writeLine(ACTION_DOES_NOT_EXIST_MESSAGE);
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)) {
            writer.writeLine(PARTICIPANT_EXIST_MESSAGE);
            return;
        }

        try {
            Targetable targetable = targetableFactory.create(name, className);
            this.participants.put(targetable.getName(), targetable);
            writer.writeLine(
                    String.format(CHARACTER_ENTERED_THE_BATTLEFIELD_MESSAGE_FORMAT,
                            targetable.getClass().getSimpleName(),
                            targetable.getName()));
        } catch (Exception e) {
            writer.writeLine(PARTICIPANT_DOES_NOT_EXIST_MESSAGE);
        }
    }


    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            writer.writeLine(MISSING_PARTICIPANTS_MESSAGE);
            return;
        }

        for (String name : this.participants.keySet()) {
            writer.writeLine(this.participants.get(name).toString());
            writer.writeLine(LINE_SEPARATOR_WITH_STARS);
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            writer.writeLine(MISSING_ACTIONS_MESSAGE);
            return;
        }

        for (Action executedAction : executedActions) {
            writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()) {
                writer.writeLine(String.format(HERO_HAS_BEEN_REMOVED_FORMAT, name));
            } else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
