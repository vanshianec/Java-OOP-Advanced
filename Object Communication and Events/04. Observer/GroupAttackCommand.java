package src;

import src.Interfaces.AttackGroup;
import src.Interfaces.Attacker;
import src.Interfaces.Command;
import src.Interfaces.Target;

public class GroupAttackCommand implements Command {
    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
