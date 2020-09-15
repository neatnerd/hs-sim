package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class BaseCard {
    protected int id = -1;
    protected int Attack;
    protected int Health;
    protected boolean DivineShield;
    protected boolean Taunt;
    protected int TavernTier;
    protected boolean Golden;
    protected MinionRace Race;

    // default constructor is used for initial state
    // implementing class is expected to override properties
    // whenever it is necessary
    public BaseCard(){
        Attack = 0;
        Health = 0;
        DivineShield = false;
        Taunt = false;
        Golden = false;
        TavernTier = 1;
        Race = MinionRace.NEUTRAL;
    }

    /**
     * If a minion supposed to listen to board changes, this methods needs to be implemented
     * @param eventType type of the current event
     * @param event event content
     * @param state current state of the game
     */
    public void EventProcessor(EventType eventType, Event event, GameState state){};


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseCard)) return false;

        BaseCard card = (BaseCard) o;

        if (id != card.id) return false;
        if (Attack != card.Attack) return false;
        if (Health != card.Health) return false;
        if (DivineShield != card.DivineShield) return false;
        if (Taunt != card.Taunt) return false;
        if (TavernTier != card.TavernTier) return false;
        if (Golden != card.Golden) return false;
        return Race == card.Race;
    }

    @Override
    public int hashCode() {
        // we exclude Tavern Tier and Race, because
        // id reflects these properties, i.e. there
        // is no second minion with same id, but
        // different TavernTier and Race
        int result = id;
        result = 31 * result + Attack;
        result = 31 * result + Health;
        result = 31 * result + (DivineShield ? 1 : 0);
        result = 31 * result + (Taunt ? 1 : 0);
        result = 31 * result + (Golden ? 1 : 0);
        return result;
    }
}
