package src;

import src.Interfaces.Attacker;
import src.Interfaces.Command;
import src.Interfaces.Target;


public class TargetCommand implements Command {
    private Attacker attacker;
    private Target target;
    public TargetCommand(Attacker attacker,Target target){
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
