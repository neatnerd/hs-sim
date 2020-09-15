package instances.tier1;

import instances.SimpleCard;
import models.*;

public class VulgarHomunculus extends BaseCard {

    public VulgarHomunculus(){
        super();
        id = 7;
        Attack = 2;
        Health = 4;
        Taunt = true;
        TavernTier = 1;
        Race = MinionRace.DEMON;
    }

    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.PLAY && event.getCard() == this){
            state.Trigger(EventType.DAMAGE_PLAYER,
                    new Event(event.getPlayer(), new SimpleCard(-2, 0), null));
        }
    }
}
