package battle;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import models.BaseCard;

@RequiredArgsConstructor
public class SingleAttack {

    @Getter @Setter @NonNull
    private BaseCard Attacker;
    @Getter @Setter @NonNull
    private BaseCard Defender;
    @Getter
    private boolean isAttackerAlive = true;
    @Getter
    private boolean isDefenderAlive = true;

    public void Execute(){
        if (Defender.isDivineShield()){
            Defender.setDivineShield(false);
        } else {
            if (Defender.getHealth() < Attacker.getAttack()){
                isDefenderAlive = false;
            } else {
                Defender.setHealth(Defender.getHealth() - Attacker.getAttack());
            }
        }
        if (Attacker.isDivineShield()){
            Attacker.setDivineShield(false);
        } else {
            if (Attacker.getHealth() < Defender.getAttack()){
                isAttackerAlive = false;
            } else {
                Attacker.setHealth(Attacker.getHealth() - Defender.getAttack());
            }
        }
    }
}
