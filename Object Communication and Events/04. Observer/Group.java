package src;

import src.Interfaces.AttackGroup;
import src.Interfaces.Attacker;
import src.Interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {

    }

    @Override
    public void groupAttack() {
       attackers.stream().forEach(attacker -> attacker.attack());
    }
}
