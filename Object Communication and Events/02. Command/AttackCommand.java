package src;

import src.Interfaces.Attacker;
import src.Interfaces.Command;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
