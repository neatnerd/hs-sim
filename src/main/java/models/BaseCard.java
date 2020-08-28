package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseCard {
    private int Attack;
    private int Health;
    private boolean DivineShield;
    private boolean Taunt;
    private int TavernTier;

    public void OnTurnStart(GameState state){};
    public void OnTurnEnd(GameState state){};
    public void OnOtherMinionPlayed(GameState state, BaseCard otherMinion){};
    public void OnOtherMinionSummon(GameState state, BaseCard otherMinion){};
    public void OnOtherMinionDeath(GameState state, BaseCard otherMinion){};
    public void OnMinionSummon(BaseCard card){};
    public void OnDeath(GameState state){};
}
