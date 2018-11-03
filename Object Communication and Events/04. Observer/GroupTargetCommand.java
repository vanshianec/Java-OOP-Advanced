package src;

import src.Interfaces.AttackGroup;
import src.Interfaces.Attacker;
import src.Interfaces.Command;
import src.Interfaces.Target;

public class GroupTargetCommand implements Command {

    private AttackGroup group;
    private Target target;

    public GroupTargetCommand(AttackGroup group, Target target) {
        this.group = group;
        this.target = target;
    }



    @Override
    public void execute() {
        this.group.groupTarget(this.target);
    }
}
