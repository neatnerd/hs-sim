package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseCard {
    protected int Attack;
    protected int Health;
    protected boolean DivineShield;
    protected boolean Taunt;
    protected int TavernTier;
    protected boolean Golden;

    // default constructor is used for initial state
    public BaseCard(){
        Attack = 0;
        Health = 0;
        DivineShield = false;
        Taunt = false;
        Golden = false;
        TavernTier = 1;
    }

    public void EventProcessor(EventType eventType, Event event, GameState state){};
}
