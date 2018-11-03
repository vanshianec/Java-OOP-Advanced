package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

import static app.models.Config.*;

public class OneVsOne implements Action {

    private List<Targetable> participants;

    public OneVsOne(){
    }

    public String executeAction(List<Targetable> participants) {

        this.participants = participants;

        String error = ONE_VS_ONE_INVALID_PARTICIPANTS_COUNT_MESSAGE;

        if(participants.size()!=2){
            return error;
        }
        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()){
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            }else {
                break;
            }
        }

        if (firstHero.isAlive()){
            sb.append(String.format(ONE_VS_ONE_HERO_IS_VICTORIOUS_MESSAGE_FORMAT, firstHero.getName(), System.lineSeparator(),firstHero.toString()));
        }else {
            sb.append(String.format(ONE_VS_ONE_HERO_IS_VICTORIOUS_MESSAGE_FORMAT, secondHero.getName(), System.lineSeparator(),secondHero.toString()));
        }

        return sb.toString();
    }
}
