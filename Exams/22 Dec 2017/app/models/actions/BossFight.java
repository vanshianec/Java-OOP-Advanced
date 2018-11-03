package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Boss;

import java.util.List;

import static app.models.Config.*;

public class BossFight implements Action {

    private List<Targetable> participants;

    public BossFight(){
    }

    @Override
    public String executeAction(List<Targetable> participants) {
        this.participants = participants;
        Targetable boss = participants.remove(0);
        if (!(boss instanceof Boss)) {
            return BOSS_FIGHT_INVALID_BOSS_MESSAGE;
        }

        if (participants.size() < 2) {
            return BOSS_FIGHT_NOT_ENOUGH_PARTICIPANTS_MESSAGE;
        }

        StringBuilder sb = new StringBuilder();
        while (participants.size() > 0) {
            for (int i = 0; i < participants.size(); i++) {
                Targetable hero = participants.get(i);
                hero.attack(boss);
                if (!boss.isAlive()) {
                    boss.giveReward(hero);
                    participants.stream().forEach(p -> {
                        if (!p.getName().equals(hero.getName())) {
                            p.levelUp();
                        }
                    });
                    participants.forEach(p -> p.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
                    sb.append(BOSS_FIGHT_BOSS_HAS_BEEN_SLAIN_MESSAGE).append(System.lineSeparator());
                    participants.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                            .forEach(p -> sb.append(p).append(System.lineSeparator()));
                    return sb.toString().trim();
                }
                boss.attack(hero);
                if(!hero.isAlive()){
                    participants.remove(i--);
                }
            }
        }
        sb.append(BOSS_FIGHT_BOSS_WIN_MESSAGE);
        return sb.toString();

    }


}

